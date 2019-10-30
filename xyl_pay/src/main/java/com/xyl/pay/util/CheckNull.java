package com.xyl.pay.util;

import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class CheckNull {
	/**
	 * 
	 * 检查字符串是否为空 包括空字符串,去空格
	 * 
	 * @param str
	 * @return true:空 false：非空
	 */
	public static boolean isNullTrim(String str) {
		return (null == str || "".equals(str.trim()));
	}

	/**
	 * 
	 * 检查字符串是否为空 包括空字符串
	 * 
	 * @param str
	 * @return true:空 false：非空
	 */
	public static boolean isNull(String str) {
		return (null == str || "".equals(str));
	}

	/**
	 * 
	 * 检查list是否为空 包括list的size为0
	 * 
	 * @param List
	 * @return true:空 false：非空
	 */
	public static boolean isNull(List lst) {
		return null == lst || lst.isEmpty();
	}
	public static boolean isNull(Set lst) {
		return null == lst || lst.isEmpty();
	}

	/**
	 * 
	 * 检查map是否为空 包括map的size为0
	 * 
	 * @param map
	 * @return
	 */
	public static boolean isNull(Map map) {
		return null == map || 0 == map.size();
	}

	/**
	 * 
	 * 检查map是否为空 包括map的size为0
	 * 
	 * @param map
	 * @return
	 */
	public static boolean isNull(Object obj) {
		return null == obj;
	}

	/**
	 * 
	 * @Title: isNullOrZero
	 * @Description: 判断Integer为空或者0
	 * @param @param integer
	 * @param @return
	 * @return boolean
	 * @throws
	 */
	public static boolean isNullOrZero(Integer integer) {
		return null == integer || integer.intValue() == 0;
	}

	/**
	 * 
	 * @Title: isNullOrZero
	 * @Description: 判断Integer为空或者0
	 * @param @param integer
	 * @param @return
	 * @return boolean
	 * @throws
	 */
	public static boolean isNullOrZero(Double integer) {
		return null == integer || integer.intValue() == 0;
	}

	/**
	 * 
	 * <p>
	 * 判断一个字符串是否是数字
	 * </p>
	 * 
	 * @author yujian.liu
	 * @date 2016-11-16 上午11:30:59
	 * @param number
	 * @return
	 */
	public static boolean isDigitsOnly(String number) {
		if(isNull(number)){
			return false;
		}
		for (int i = 0; i < number.length(); i++) {
			if (!Character.isDigit(number.charAt(i))) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * 
	 * 检查是否是空数组
	 * 
	 * @param array
	 * @return true:空 false：非空
	 */
	public static boolean isEmpty(Object[] array) {
		return (array == null || array.length == 0);
	}
}
