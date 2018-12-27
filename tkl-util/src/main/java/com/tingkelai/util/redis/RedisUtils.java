package com.tingkelai.util.redis;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.HashMap;
import java.util.Map;

/**
 * 说明：这并不是完整的工具类，缺少不少方法
 */
@Configuration
@PropertySource(value = "file:${TKL_CONFIG_PATH}/application-test.properties")
public class RedisUtils {

    //Redis服务器IP
    @Value("${spring.redis.host}")
    private static String ADDR = "127.0.0.1";

    //Redis的端口号
    @Value("${spring.redis.port}")
    private static int PORT = 6379;

    //访问密码
    @Value("${spring.redis.password}")
    private static String AUTH;

    //可用连接实例的最大数目，默认值为8；
    //如果赋值为-1，则表示不限制；如果pool已经分配了maxActive个jedis实例，则此时pool的状态为exhausted(耗尽)。
    @Value("${spring.redis.jedis.pool.max-active}")
    private static int MAX_ACTIVE = 8;

    //控制一个pool最多有多少个状态为idle(空闲的)的jedis实例，默认值也是8。
    @Value("${spring.redis.jedis.pool.max-idle}")
    private static int MAX_IDLE = 8;

    //等待可用连接的最大时间，单位毫秒，默认值为-1，表示永不超时。如果超过等待时间，则直接抛出JedisConnectionException；
    @Value("${spring.redis.jedis.pool.max-wait}")
    private static int MAX_WAIT = 1;

    @Value("${spring.redis.timeout}")
    private static int TIMEOUT;

    //在borrow一个jedis实例时，是否提前进行validate操作；如果为true，则得到的jedis实例均是可用的；
    private static boolean TEST_ON_BORROW = false;

    private static int expire = 60 * 1000 * 60 * 24;

    private static JedisPool jedisPool = null;

    /**
     * 初始化Redis连接池
     */
    static {
        try {
            JedisPoolConfig config = new JedisPoolConfig();
            config.setMaxIdle(MAX_IDLE);
            config.setMaxWaitMillis(MAX_WAIT);
            config.setTestOnBorrow(TEST_ON_BORROW);
            config.setMaxTotal(MAX_ACTIVE);
            //为了测试方便，没有加密码认证，部署时可以加上密码
            jedisPool = new JedisPool(config, ADDR, PORT, TIMEOUT);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取Jedis实例
     *
     * @return
     */
    public static Jedis getJedis() {
        try {
            if (jedisPool != null) {
                Jedis resource = jedisPool.getResource();
                return resource;
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 释放jedis资源
     *
     * @param jedis
     */
    public static void returnResource(Jedis jedis, boolean isBroken) {
        if (jedis != null) {
            if (isBroken) {
                jedisPool.returnBrokenResource(jedis);
            } else {
                jedisPool.returnResource(jedis);
            }
        }
    }

    /**
     * 删除key
     */
    public static void delKey(String fileName) {
        //判断redis中是否有相应的key值,如果有，删除该值
        boolean isBroken = false;
        Jedis jedis = null;
        try {
            jedis = getJedis();
            boolean flag = jedis.exists(fileName);
            if (flag) {
                jedis.del(fileName);
            }
        } catch (Exception e) {
            isBroken = true;
        } finally {
            returnResource(jedis, isBroken);
        }
        return;
    }

    /**
     * 通过key获取redis中的value值
     *
     * @param key
     * @return
     */
    public static String getKey(String key) {
        String res = "";
        boolean isBroken = false;
        Jedis jedis = null;
        try {
            jedis = getJedis();
            boolean flag = jedis.exists(key);
            if (flag) {
                res = jedis.get(key);
            }
        } catch (Exception e) {
            isBroken = true;
        } finally {
            returnResource(jedis, isBroken);
        }
        return res;
    }

    /**
     * redis添加值
     *
     * @param key
     * @param value
     */
    public static void setKey(String key, String value) {
        setKey(key, value, expire);
        return;
    }

    /**
     * redis添加值
     *
     * @param key
     * @param value
     */
    public static void setKey(String key, String value, int expire) {
        boolean isBroken = false;
        Jedis jedis = null;
        try {
            jedis = getJedis();
            jedis.set(key, value);
            jedis.expire(key, expire);
        } catch (Exception e) {
            isBroken = true;
        } finally {
            returnResource(jedis, isBroken);
        }
        return;
    }

    /**
     * redis添加值
     *
     * @param key
     */
    public static boolean isExist(String key) {
        boolean flag = false;
        boolean isBroken = false;
        Jedis jedis = null;
        try {
            jedis = getJedis();
            flag = jedis.exists(key);
        } catch (Exception e) {
            isBroken = true;
        } finally {
            returnResource(jedis, isBroken);
        }
        return flag;
    }

    /**
     * redis map添加值
     *
     * @param key
     * @param value
     */
    public static void setKeyMap(String key, HashMap<String, String> value) {
        setKeyMap(key, value, expire);
        return;
    }

    /**
     * redis map添加值
     *
     * @param key
     * @param value
     */
    public static void setKeyMap(String key, HashMap<String, String> value, int expire) {
        boolean isBroken = false;
        Jedis jedis = null;
        try {
            jedis = getJedis();
            jedis.hmset(key, value);
            jedis.expire(key, expire);
        } catch (Exception e) {
            isBroken = true;
        } finally {
            returnResource(jedis, isBroken);
        }
        return;
    }

    /**
     * redis map获取key对应的值
     *
     * @param key
     * @return
     */
    public static Map<String, String> getKeyMap(String key) {
        boolean isBroken = false;
        Jedis jedis = null;
        Map<String, String> map = new HashMap<String, String>();
        try {
            jedis = getJedis();
            map = jedis.hgetAll(key);
        } catch (Exception e) {
            isBroken = true;
        } finally {
            returnResource(jedis, isBroken);
        }
        return map;
    }


    /**
     * redis map中删除key
     *
     * @param key
     * @param field
     */
    public static void hdel(String key, String field) {
        boolean isBroken = false;
        Jedis jedis = null;
        try {
            jedis = getJedis();
            if (jedis.hget(key, field) != null) {
                jedis.hdel(key, field);
            }
        } catch (Exception e) {
            isBroken = true;
        } finally {
            returnResource(jedis, isBroken);
        }
        return;
    }

    /**
     * redis map中判断key是否存在
     *
     * @param key
     * @param field
     * @return
     */
    public static boolean hExist(String key, String field) {
        boolean resBoolean = false;
        boolean isBroken = false;
        Jedis jedis = null;
        try {
            jedis = getJedis();
            String value = jedis.hget(key, field);
            if (value != null) {
                resBoolean = true;
            }
        } catch (Exception e) {
            isBroken = true;
        } finally {
            returnResource(jedis, isBroken);
        }
        return resBoolean;
    }
}
