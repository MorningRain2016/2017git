package com.cn.shop.service;

import com.cn.shop.domain.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.shop.dao.UserDao;

@Service
public class UserService {
	@Autowired 
	UserDao userDao;
	
	public long save(User user){
		return userDao.save(user);
	}
	
	public User get(Long id){
		return userDao.get(id);
	}
}
