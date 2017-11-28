package com.cn.shop.util;

import java.lang.reflect.*;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.util.Assert;

/**
 * 反射工具类
 * 提供访问私有变量，获取反省类型，提取集合众元素属性等工具函数。
 *
 */
public class ReflectionUtils {
	private ReflectionUtils() {
		
	}
	
	@SuppressWarnings("rawtypes")
	public static Class getSuperClassGenricType(Class clazz){
		return getSuperClassGenricType(clazz, 0);
	}
	
	@SuppressWarnings("rawtypes")
	public static Class getSuperClassGenricType(Class clazz, int index){
		Type genType = clazz.getGenericSuperclass();
		if(!(genType instanceof ParameterizedType)){
			return Object.class;
		}
		Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
		
		if(index >= params.length || index < 0) {
			return Object.class;
		}
		if(!(params[index] instanceof Class)) {
			return Object.class;
		}
		return (Class)params[index];
	}
}
