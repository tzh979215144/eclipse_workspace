package org.zhoukan.bean;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

import org.apache.commons.beanutils.BeanUtils;

public class BackMessageBean {

	private String txt1 = null;
	private String txt2 = null;
	private String txt3 = null;
	private String txt4 = null;
	public String getTxt1() {
		return txt1;
	}
	public void setTxt1(String txt1) {
		this.txt1 = txt1;
	}
	public String getTxt2() {
		return txt2;
	}
	public void setTxt2(String txt2) {
		this.txt2 = txt2;
	}
	public String getTxt3() {
		return txt3;
	}
	public void setTxt3(String txt3) {
		this.txt3 = txt3;
	}
	public String getTxt4() {
		return txt4;
	}
	public void setTxt4(String txt4) {
		this.txt4 = txt4;
	}
	public static void main(String[] args) throws IllegalAccessException, InvocationTargetException {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("txt1", "nihao");
		map.put("txt2", "nihao1");
		map.put("txt3", "nihao4");
		map.put("txt4", "nihao2");
		BackMessageBean bean = new BackMessageBean();
		
		BeanUtils.populate(bean, map);
		System.out.println(bean.getTxt1()+bean.getTxt4());
	}
}
