package com.tingkelai.shiro.jwt;

import com.auth0.jwt.JWTSigner;
import com.auth0.jwt.JWTVerifier;
import com.tingkelai.util.env.EnvConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * jwt工具类
 *
 * 2018-12-5 14:10:53
 * @author liuzhengjie
 * @version 1.0
 */
public class JwtUtil {

    /** 日志 */
    private static Logger logger = LoggerFactory.getLogger(JwtUtil.class);

    //默认token名字
//    @Value("${tkl.jwt.tokenName}")
    public static String TOKEN_NAME = EnvConfig.getPropertyString("tkl.jwt.tokenName");

    public static String USER_ID_NAME = "userId";

    public static String TEAM_ID_NAME = "teamId";

    //密钥
//    @Value("${tkl.jwt.apiKey}")
    public static String apiKey =  EnvConfig.getPropertyString("tkl.jwt.apiKey");

    //token到期时间小于autoUpdateSeconds时，自动更新token
//    @Value("${tkl.jwt.autoUpdateSeconds}")
    private static Integer autoUpdateSeconds =  EnvConfig.getPropertyInteger("tkl.jwt.autoUpdateSeconds");

    //auth token有效期为15天
//    @Value("${tkl.jwt.authTokenExpireSeconds}")
    private static Integer authTokenExpireSeconds = EnvConfig.getPropertyInteger("tkl.jwt.authTokenExpireSeconds");

//    @Value("${tkl.jwt.showIssuedAt}")
    private static Boolean showIssuedAt = EnvConfig.getPropertyBoolean("tkl.jwt.showIssuedAt");

    // 到期时间标识
    private static final String DEADLINE_FLAG = "deadLine";

    /**
     * 生成sessionToken签名
     * @param map 需要进行签名的对象，键值对以HashMap的形式存储
     * @return 返回签名
     */
    public static String signSessionToken(Map<String, Object> map){
        JWTSigner signer = new JWTSigner(apiKey);
        JWTSigner.Options options = new JWTSigner.Options();
        options.setExpirySeconds(authTokenExpireSeconds);
        options.setIssuedAt(showIssuedAt);
        map.put(TOKEN_NAME, apiKey);
        map.put(DEADLINE_FLAG, new Date().getTime());
        return signer.sign(map, options);
    }

    /**
     * 验证sessionToken的签名
     * @param token 需要验证的token
     * @return 验证成功，则返回解析之后的Map对象
     */
    public static Map<String, Object> verifySessionToken(String token){
        try {
            JWTVerifier verifier = new JWTVerifier(apiKey);
            return verifier.verify(token);
        } catch (Exception e) {
            return new HashMap<>();
        }
    }

    /**
     * 判断token是否过期，是否需要更新
     * @param token
     * @param map
     * @return
     */
    public static String refreshToken(String token, Map<String, Object> map){
        String refreshToken = token;
        try{
            //获取token到期时间，如果现在还有指定时间到期，则刷新token
            Long deadline = (Long)map.get(DEADLINE_FLAG);
            if(deadline == null){
                logger.warn("====token已过期，需重新登录");
                return null;
            }

            //当前时间
            Date newDate = new Date();
            long surplus = newDate.getTime() - deadline;
            if(surplus < 0){
                logger.warn("====token已过期，需重新登录");
                return null;
            }else if(surplus < autoUpdateSeconds){
                map.put(DEADLINE_FLAG, newDate);
                refreshToken = signSessionToken(map);
            }
        }catch (Exception e){
            logger.warn("====更新token失败" + e);
        }
        return refreshToken;
    }

    /**
     * 将token设置为失效
     * @param token
     */
    public static void expireToken(String token) {
        if(token != null){
            Map<String, Object> map = verifySessionToken(token);
            if(map.containsKey(apiKey)){
                map.remove(DEADLINE_FLAG);
            }
        }
    }
}
