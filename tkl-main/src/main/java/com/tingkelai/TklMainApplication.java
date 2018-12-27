package com.tingkelai;

import com.tingkelai.util.env.EnvConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TklMainApplication{

	private static Logger logger = LoggerFactory.getLogger(TklMainApplication.class);

	public static void main(String[] args) {
		logger.debug("====tingkelai start");
		System.out.println("========== 听客来系统启动 ===========");
		args = EnvConfig.getEnvArgs();
		SpringApplication springApplication = new SpringApplication(TklMainApplication.class);
//		List<File> fileList = new ArrayList<>();
//		fileList = FileUtil.getFileList(GlobalConfig.CONFIG_ROOT_PATH, fileList);
//		Set<String> sourceSet = FileUtil.getFilePathSet(GlobalConfig.CONFIG_ROOT_PATH);
//		springApplication.setSources(sourceSet);
//		springApplication.setDefaultProperties(EnvConfig.getProperties());
//		springApplication.setAdditionalProfiles(sourceSet.toArray(new String[0]));
		springApplication.run(args);
//		SpringApplication.run(TklMainApplication.class, args);
		logger.debug("====tingkelai start");
		System.out.println("========== 听客来系统启动 ===========");
	}
}
