package com.tingkelai.config;

import com.alibaba.druid.filter.Filter;
import com.alibaba.druid.filter.stat.StatFilter;
import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.wall.WallConfig;
import com.alibaba.druid.wall.WallFilter;
import com.tingkelai.util.env.EnvConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

/**
 * Druid配置
 *
 * @author liuzhengjie
 * 2018-11-22 15:29:03
 */
@Configuration
public class DruidConfig {
    private Logger logger = LoggerFactory.getLogger(DruidConfig.class);

    @Autowired
    private Environment env;

//    @Value("${spring.datasource.url:#{null}}")
    private String dbUrl = EnvConfig.getPropertyString("spring.datasource.url");
//    @Value("${spring.datasource.username: #{null}}")
    private String username = EnvConfig.getPropertyString("spring.datasource.username");
//    @Value("${spring.datasource.password:#{null}}")
    private String password = EnvConfig.getPropertyString("spring.datasource.password");
//    @Value("${spring.datasource.driverClassName:#{null}}")
    private String driverClassName = EnvConfig.getPropertyString("spring.datasource.driverClassName");
//    @Value("${spring.datasource.initialSize:#{null}}")
    private Integer initialSize = EnvConfig.getPropertyInteger("spring.datasource.initialSize");
//    @Value("${spring.datasource.minIdle:#{null}}")
    private Integer minIdle  = EnvConfig.getPropertyInteger("spring.datasource.minIdle:");
//    @Value("${spring.datasource.maxActive:#{null}}")
    private Integer maxActive  = EnvConfig.getPropertyInteger("spring.datasource.maxActive");
//    @Value("${spring.datasource.maxWait:#{null}}")
    private Integer maxWait  = EnvConfig.getPropertyInteger("spring.datasource.maxWait");
//    @Value("${spring.datasource.timeBetweenEvictionRunsMillis:#{null}}")
    private Integer timeBetweenEvictionRunsMillis = EnvConfig.getPropertyInteger("spring.datasource.timeBetweenEvictionRunsMillis");
//    @Value("${spring.datasource.minEvictableIdleTimeMillis:#{null}}")
    private Integer minEvictableIdleTimeMillis = EnvConfig.getPropertyInteger("spring.datasource.minEvictableIdleTimeMillis");
//    @Value("${spring.datasource.validationQuery:#{null}}")
    private String validationQuery = EnvConfig.getPropertyString("spring.datasource.validationQuery");
//    @Value("${spring.datasource.testWhileIdle:#{null}}")
    private Boolean testWhileIdle  = EnvConfig.getPropertyBoolean("spring.datasource.testWhileIdle");
//    @Value("${spring.datasource.testOnBorrow:#{null}}")
    private Boolean testOnBorrow  = EnvConfig.getPropertyBoolean("spring.datasource.testOnBorrow");
//    @Value("${spring.datasource.testOnReturn:#{null}}")
    private Boolean testOnReturn = EnvConfig.getPropertyBoolean("spring.datasource.testOnReturn");
//    @Value("${spring.datasource.poolPreparedStatements:#{null}}")
    private Boolean poolPreparedStatements  = EnvConfig.getPropertyBoolean("spring.datasource.poolPreparedStatements");
//    @Value("${spring.datasource.maxPoolPreparedStatementPerConnectionSize:#{null}}")
    private Integer maxPoolPreparedStatementPerConnectionSize = EnvConfig.getPropertyInteger("spring.datasource.maxPoolPreparedStatementPerConnectionSize");
//    @Value("${spring.datasource.filters:#{null}}")
    private String filters = EnvConfig.getPropertyString("spring.datasource.filters");
//    @Value("${spring.datasource.connectionProperties:#{null}}")
    private String connectionProperties = EnvConfig.getPropertyString("spring.datasource.connectionProperties");


    @Bean
    @Primary
    public DataSource dataSource(){
        System.out.println(env.getProperty("justTest"));
        System.out.println(env.getProperty("justTest2.tingkelai"));
        System.out.println(env.getProperty("url"));
        DruidDataSource datasource = new DruidDataSource();
//        if(env.getProperty("url") != null){
//            System.err.println(env.getProperty("url"));
//            datasource.setUrl(env.getProperty("url"));
//        }else{
//        }
            datasource.setUrl(dbUrl);
        datasource.setUsername(username);
        datasource.setPassword(password);
        datasource.setDriverClassName(driverClassName);
        //configuration
        if(initialSize != null) {
            datasource.setInitialSize(initialSize);
        }
        if(minIdle != null) {
            datasource.setMinIdle(minIdle);
        }
        if(maxActive != null) {
            datasource.setMaxActive(maxActive);
        }
        if(maxWait != null) {
            datasource.setMaxWait(maxWait);
        }
        if(timeBetweenEvictionRunsMillis != null) {
            datasource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
        }
        if(minEvictableIdleTimeMillis != null) {
            datasource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
        }
        if(validationQuery!=null) {
            datasource.setValidationQuery(validationQuery);
        }
        if(testWhileIdle != null) {
            datasource.setTestWhileIdle(testWhileIdle);
        }
        if(testOnBorrow != null) {
            datasource.setTestOnBorrow(testOnBorrow);
        }
        if(testOnReturn != null) {
            datasource.setTestOnReturn(testOnReturn);
        }
        if(poolPreparedStatements != null) {
            datasource.setPoolPreparedStatements(poolPreparedStatements);
        }
        if(maxPoolPreparedStatementPerConnectionSize != null) {
            datasource.setMaxPoolPreparedStatementPerConnectionSize(maxPoolPreparedStatementPerConnectionSize);
        }

        if(connectionProperties != null) {
            datasource.setConnectionProperties(connectionProperties);
        }
        if(initialSize != null){
            datasource.setInitialSize(initialSize);//初始化时建立物理连接的个数
        }
        if(maxActive != null){
            datasource.setMaxActive(maxActive); //最大连接池数量
        }
        if(minIdle != null){
            datasource.setMinIdle(0); //最小连接池数量
        }
        if(maxWait != null){
            datasource.setMaxWait(maxWait); //获取连接时最大等待时间，单位毫秒
        }
        if(validationQuery != null){
            datasource.setValidationQuery(validationQuery); //用来检测连接是否有效的sql
        }
        if(testOnBorrow != null){
            datasource.setTestOnBorrow(testOnBorrow); //申请连接时执行validationQuery检测连接是否有效
        }
        if(testWhileIdle != null){
            datasource.setTestWhileIdle(testWhileIdle); //建议设置为true，不影响性能，并且保证安全性
        }
        if(poolPreparedStatements != null){
            datasource.setPoolPreparedStatements(poolPreparedStatements); //是否缓存preparedStatement,也就是PSCache
        }

        List<Filter> filters = new ArrayList<>();
        filters.add(statFilter());
        filters.add(wallFilter());
        datasource.setProxyFilters(filters);

        logger.debug("====datasource start:" + datasource);
        return datasource;
    }

    @Bean
    public StatFilter statFilter(){
        StatFilter statFilter = new StatFilter();
        statFilter.setLogSlowSql(true); //slowSqlMillis用来配置SQL慢的标准，执行时间超过slowSqlMillis的就是慢。
        statFilter.setMergeSql(true); //SQL合并配置
        statFilter.setSlowSqlMillis(3000);//slowSqlMillis的缺省值为3000，也就是3秒。
        return statFilter;
    }

    @Bean
    public WallFilter wallFilter(){
        WallFilter wallFilter = new WallFilter();
        //允许执行多条SQL
        WallConfig config = new WallConfig();
        config.setMultiStatementAllow(true);
        wallFilter.setConfig(config);
        return wallFilter;
    }

    // 配置事物管理器
    @Bean(name="transactionManager")
    public DataSourceTransactionManager transactionManager(){
        return new DataSourceTransactionManager(dataSource());
    }
}