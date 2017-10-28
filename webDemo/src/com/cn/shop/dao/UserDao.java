package com.cn.shop.dao;

import com.cn.shop.domain.User;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao{
	  @Autowired
	    private SessionFactory sessionFactory;

	    private Session getCurrentSession() {
	        return this.sessionFactory.openSession();
	    }

	    public User load(Long id) {
	        return (User)getCurrentSession().load(User.class,id);
	    }

	    public User get(Long id) {
	        return (User)getCurrentSession().get(User.class,id);
	    }

	    public List<User> findAll() {
	        return null;
	    }

	    public void persist(User entity) {
	        getCurrentSession().persist(entity);
	    }

	    public Long save(User entity) {
	        return (Long)getCurrentSession().save(entity);
	    }

	    public void saveOrUpdate(User entity) {
	        getCurrentSession().saveOrUpdate(entity);
	    }

	    public void delete(Long id) {
	    	User person = load(id);
	        getCurrentSession().delete(person);
	    }

	    public void flush() {
	        getCurrentSession().flush();
	    }

}
