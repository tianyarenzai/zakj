package com.zakj.utils;

import java.io.FileReader;
import java.io.Reader;
import java.util.Properties;

public class ConfigUtil {

	private static Properties props = new Properties();

	static {
		try {
			props.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("config.properties"));
		} catch (Exception e) {
			try {
				Reader reader = new FileReader(System.getProperty("user.dir") + System.getProperty("file.separator")
						+ "conf" + System.getProperty("file.separator") + "config.properties");
				props.load(reader);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}

	public static String getValue(String key) {
		return props.getProperty(key);
	}

}
