package com.sean.service.entity;

/**
 * Bean实体
 * @author sean
 *
 */
public class BeanEntity
{
	private Class<?> cls;

	public BeanEntity(Class<?> cls)
	{
		this.cls = cls;
	}

	public Class<?> getCls()
	{
		return cls;
	}

}
