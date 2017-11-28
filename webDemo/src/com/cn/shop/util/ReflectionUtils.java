package com.cn.shop.util;

import java.lang.reflect.*;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.util.Assert;

/**
 * ���乤����
 * �ṩ����˽�б�������ȡ��ʡ���ͣ���ȡ������Ԫ�����Եȹ��ߺ�����
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
