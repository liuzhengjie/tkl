package com.tingkelai;

import com.tingkelai.config.env.EnvConfig;
import com.tingkelai.config.env.GlobalConfig;
import com.tingkelai.util.FileUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.AbstractEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.core.env.SystemEnvironmentPropertySource;

import java.io.File;
import java.util.*;

@SpringBootApplication
public class TklMainApplication{

	private static Logger logger = LoggerFactory.getLogger(TklMainApplication.class);

	public static void main(String[] args) {
		logger.debug("====tingkelai start");
		System.out.println("========== 听客来系统启动 ===========");
//		args = EnvConfig.getEnvArgs();
		SpringApplication springApplication = new SpringApplication(TklMainApplication.class);
//		List<File> fileList = new ArrayList<>();
//		fileList = FileUtil.getFileList(GlobalConfig.CONFIG_ROOT_PATH, fileList);
//		Set<String> sourceSet = FileUtil.getFilePathSet(GlobalConfig.CONFIG_ROOT_PATH);
//		springApplication.setSources(sourceSet);
		springApplication.setDefaultProperties(EnvConfig.getProperties());
//		springApplication.setAdditionalProfiles(sourceSet.toArray(new String[0]));
		springApplication.run(args);
//		SpringApplication.run(TklMainApplication.class, args);
		logger.debug("====tingkelai start");
		System.out.println("========== 听客来系统启动 ===========");
	}
}
