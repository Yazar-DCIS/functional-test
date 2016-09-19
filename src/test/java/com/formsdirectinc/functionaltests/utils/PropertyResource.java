package com.formsdirectinc.functionaltests.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Class for Property File Invoke
 *
 * @author:Orina <br>
 *               Revision: $Rev$
 */

public class PropertyResource {

	private static final String DEFAULT_PROPERTIES_PATH = "src/test/resources/properties/%s.properties";
	
	public Properties loadProperty(String fileName) {
		FileInputStream inputStream = null;
		try{
			Properties properties = new Properties();
			File file = new File(String.format(DEFAULT_PROPERTIES_PATH, fileName));
			inputStream = new FileInputStream(file);
			properties.load(inputStream);
			return properties;
		} catch (IOException e) {
			throw new RuntimeException(e);
		} finally {
			try{
				if(inputStream != null){
					inputStream.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}	
		}
	}

}
