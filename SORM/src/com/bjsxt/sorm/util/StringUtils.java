package com.bjsxt.sorm.util;
/**
 * 封装了字符串常用的操作
 * @author tzh
 *
 */
public class StringUtils {
	
	/**
	 * 首字母变大写
	 */
	public static String firstChar2UpperCase(String str) {
		//abcd-->Abcd
		
		//qwer------->QWER------->Q----------------->Q+wer-->Qwer
		return str.toUpperCase().substring(0, 1)+str.substring(1);
		
	}
}
