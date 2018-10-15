package org.zhoukan.struts;

import java.util.HashMap;

/**
 * 这是为了加载一个类放进map里
 * @author tanpang
 *
 */
public class ActionFactory {

	protected static HashMap<String, Action> actions = new HashMap<String, Action>();
	
	private ActionFactory(){};
	
	public static synchronized Action createAction(String className){
		if(actions.containsKey(className)){
			return actions.get(className);
		}
		Action action = null;
		try {
			ClassLoader loader = Thread.currentThread().getContextClassLoader();
			action = (Action)loader.loadClass(className).newInstance();
			actions.put(className, action);
		} catch (InstantiationException e) {
			e.printStackTrace();
			return action;
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			return action;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return action;
		}
		return action;
	}
}
