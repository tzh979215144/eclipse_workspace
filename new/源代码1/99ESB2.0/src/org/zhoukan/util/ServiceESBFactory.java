package org.zhoukan.util;

import java.util.HashMap;

import org.zhoukan.doservice.ServiceESB;

public class ServiceESBFactory {

	
	private static HashMap<String, ServiceESB> services = new HashMap<String, ServiceESB>();
	
	public static synchronized ServiceESB createService(String className){
		if(services.containsKey(className)){
			return services.get(className);
		}
		ServiceESB service = null;
		try {
			ClassLoader loader = Thread.currentThread().getContextClassLoader();
			service = (ServiceESB)loader.loadClass(className).newInstance();
			services.put(className, service);
		} catch (Exception e) {
			e.printStackTrace();
			return service;
		}
		return service;
	}
	public static synchronized void clearService(){
		services.clear();
	}
}
