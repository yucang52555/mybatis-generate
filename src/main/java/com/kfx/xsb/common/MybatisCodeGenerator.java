package com.kfx.xsb.common;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

public class MybatisCodeGenerator {
//	protected static final Logger logger = LoggerFactory.getLogger(MybatisCodeGenerator.class);

	public static void main(String[] args) throws Exception{
		List<String> warnings = new ArrayList<String>();
		boolean overwrite = true;
//		PropertyConfigurator.configure("src/main/resources/log4j.properties");
		File configFile = new File("src/main/java/com/kfx/xsb/mybatis/generatorConfig.xml");
		ConfigurationParser cp = new ConfigurationParser(warnings);
		Configuration config = cp.parseConfiguration(configFile);
		DefaultShellCallback callback = new DefaultShellCallback(overwrite);
		MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
		myBatisGenerator.generate(null);
	}
}
