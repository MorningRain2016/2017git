package com.cn.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cn.shop.service.TestService;
import com.cn.shop.service.UserService;
import com.cn.shop.domain.User;

@Controller
public class MainController {
	
	@Autowired
    private TestService testService;
	@Autowired
	private UserService userService;

	@RequestMapping(value = "test", method = RequestMethod.GET)
	public String test(){
	//实际返回的是views/test.jsp ,spring-mvc.xml中配置过前后缀
		int a=1;
		return "test";
	}
	
	
	@RequestMapping(value = "springtest", method = RequestMethod.GET)
    public String springTest(){
        return testService.test();
    }
	
	
	@RequestMapping(value = "saveUser", method = RequestMethod.POST)
	@ResponseBody
    public String saveUser(){
		User user = new User();
		
		/*
		user.setName("WangEr");
		user.setPassword("111222");
		user.setCellPhone("15922438006");
		user.setEmail("12479@163.com");
		
        long result = userService.save(user);
       
       */
		
		Long id = new Long(4);
        user = userService.get(id);
        
        System.out.println(user.getName());
        
//        return "success!";
        
        return user.getName();
    }
	
	
	@RequestMapping(value = "getUser", method = RequestMethod.GET)
	@ResponseBody
    public String getUser(){
		Long id = new Long(1);
		User user = userService.get(id);
        
        System.out.println(user.getName());
        return user.getName();
    }
	
}
