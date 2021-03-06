package com.tzh.pro1;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public  class useIterator {
/**
 * HashMap 的简单使用：迭代器，keyset(), entryset(), remove(),
 * @author tzh
 *
 */
	
	private static class Team{
		private String name;                                                    
		private String age;                                                                                     
	    /**                                                                     
	     * connection使用                                                         
	     */                                                                     
	    private Map<String,String> stu = new HashMap<String, String>();
	    
	    
		public Team(String name, String age, Map<String, String> stu) {
			super();
			this.name = name;
			this.age = age;
			this.stu = stu;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getAge() {
			return age;
		}
		public void setAge(String age) {
			this.age = age;
		}
		public Map<String, String> getStu() {
			return stu;
		}
		public void setStu(Map<String, String> stu) {
			this.stu = stu;
		}         
	                                                                            
	}
	
	public static void main(String[] args) {
		/**
		 * 球队
		 */
		Map SNNU = new HashMap();
		SNNU.put("谭智恒","大三");
		SNNU.put("李康博","大二");
		SNNU.put("黎晓静","大一");
		SNNU.put("李正勇","大二");
		SNNU.put("曹雅萌", "大四");
		
		Team myTeam = new Team("师大羽毛球队","羽毛球",SNNU);
		//SNNU.remove("曹雅萌");
		System.out.println(myTeam.getName()+myTeam.getAge()+"队员如下：");
		Iterator<String> it = SNNU.keySet().iterator();
		while(it.hasNext()) {
			String idname = it.next();
			System.out.println(idname+"  的年级是:     "+SNNU.get(idname));
		}
		System.out.println("=======下面使用entrySet遍历======");

		
		Iterator<Map.Entry<String, String>> it2 = SNNU.entrySet().iterator(); 	
		while(it2.hasNext()) {
			//通过Map.Entry<String,String> 取关系对象
			Map.Entry<String,String> me = it2.next();
			String idname = me.getKey();
			String idage = me.getValue();
			System.out.println(idname+"  的年级是:     "+idage);
		}
		System.out.println("队员人数为："+ SNNU.size() + "人");
	}
	

}
