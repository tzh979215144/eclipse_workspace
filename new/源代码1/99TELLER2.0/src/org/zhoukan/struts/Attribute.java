package org.zhoukan.struts;

import java.io.IOException;
import java.util.Properties;

public class Attribute {
	
	private String filePath = null;
	private Properties cache = new Properties();
	
	public Attribute(String filePath) {
		// TODO Auto-generated constructor stub
		this.filePath = filePath;
		try {
			this.cache.load(getClass().getResourceAsStream(this.filePath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String getValue(String key){
		if(this.cache.containsKey(key)){
			return this.cache.getProperty(key);
		}
		return null;
	}
	
}
