package org.zhoukan.util;

import java.util.HashMap;

import org.zhoukan.service.ServiceSYMBOLS;

public class ServiceSYMBOLSFactory {

	
	private static HashMap<String, ServiceSYMBOLS> services = new HashMap<String, ServiceSYMBOLS>();
	
	public static synchronized ServiceSYMBOLS createService(String className){
		if(services.containsKey(className)){
			return services.get(className);
		}
		ServiceSYMBOLS service = null;
		try {
			ClassLoader loader = Thread.currentThread().getContextClassLoader();
			service = (ServiceSYMBOLS)loader.loadClass(className).newInstance();
			services.put(className, service);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return service;
		} 
		return service;
	}
	
	public static synchronized void clearService(){
		services.clear();
	}
}
