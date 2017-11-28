package com.cn.shop.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.*;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.metadata.ClassMetadata;
import org.hibernate.transform.ResultTransformer;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import com.cn.shop.util.ReflectionUtils;
import org.springframework.util.Assert;

@SuppressWarnings("unchecked")
public abstract class BaseDao <T,PK extends Serializable>{
	protected Class<T> entityClass;
	@Autowired
	protected
	HibernateTemplate hibernateTemplate;
	
	public BaseDao() {
		this.entityClass = ReflectionUtils.getSuperClassGenricType(getClass());
	}
	
	protected Session getSession(){
		return hibernateTemplate.getSessionFactory().getCurrentSession();
	}
	
	public void save(final T entity){
		Assert.notNull(entity);
		
		hibernateTemplate.save(entity);
	}
	
	public void modify(final T entity) {
		hibernateTemplate.saveOrUpdate(entity);
	}
	
	/**
	 * 删除对象
	 * @param entify 对象必须是session中的对象或汗id属性的transient对象
	 */
	public void delete(final T entify){
		if(entify == null){
			return;
		}
		hibernateTemplate.delete(entify);
	}
	
	public void delete(final PK id){
		if (id == null) {
			return;
		}
		delete(get(id));
	}
	
	public T get(final PK id){
		Assert.notNull(id);
		return (T)hibernateTemplate.get(entityClass, id);
	}
	
	public List<T> getAll(){
		return findByCriteria();
	}
	public List<T> findByProperty(final String propertyName, final Object value){
		Criterion criterion = Restrictions.eq(propertyName, value);
		return findByCriteria(criterion);
	}
	
	public List<T> findByCriteria(final Criterion...criterions ){
		return createCriteria(criterions).list();
	}
	
	public T findUnique(final Criterion...criterions ){
		return (T)createCriteria(criterions).uniqueResult();
	}
	
	public Criteria createCriteria(final Criterion...criterions){
		Criteria criteria = getSession().createCriteria(entityClass);
		for(Criterion c:criterions){
			criteria.add(c);
		}
		
		return criteria;
	}
}
