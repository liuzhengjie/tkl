package com.tingkelai;

import com.tingkelai.util.env.EnvConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 系统config模块入口
 * 2018-11-23 14:37:09
 * @author liuzhengjie
 * @version 1.0
 */
@ComponentScan(basePackages = { "com.tingkelai.**" })
@MapperScan(basePackages = "com.tingkelai.dao")
@EnableTransactionManagement  // 启注解事务管理，等同于xml配置方式的 <tx:annotation-driven />
public class TklConfigApplication{

	private static Logger logger = LoggerFactory.getLogger(TklConfigApplication.class);

	public static void main(String[] args) {
		logger.debug("====tingkelai config module start");
		System.out.println("========== 听客来config模块启动 ===========");
		args = EnvConfig.getEnvArgs();
		SpringApplication springApplication = new SpringApplication(TklConfigApplication.class);
//		springApplication.setDefaultProperties(EnvConfig.getProperties());
		springApplication.run(args);
		System.out.println("======== 听客来config模块启动成功！ ===========");
	}
//
//	@Override
//	public void setEnvironment(Environment environment) {
//		logger.info("====配置文件路径：" + GlobalConfig.CONFIG_ROOT_PATH);
//		try {
//			AbstractEnvironment env = (AbstractEnvironment) environment;
//			Properties properties = new Properties();
//			List<File> fileList = new ArrayList<>();
//			fileList = FileUtil.getFileList(GlobalConfig.CONFIG_ROOT_PATH, fileList);
//			for(File file : fileList){
//				String fileName = file.getName();
//				if(fileName.endsWith(".yml") || fileName.endsWith(".yaml") || fileName.endsWith(".properties")){
//					String configPath = file.getPath();
//					GlobalConfig.load(configPath, properties);
//				}
//			}
//			Set<String> set = properties.stringPropertyNames();
//			Map<String, Object> map = new HashMap<>();
//			for(String temp : set){
//				map.put(temp, properties.get(temp));
//			}
//			env.getPropertySources().addFirst(new SystemEnvironmentPropertySource("myconfig", map));
//		}catch (Exception e){
//			e.printStackTrace();
//		}
//	}
}
