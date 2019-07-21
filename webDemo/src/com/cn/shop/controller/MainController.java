package com.cn.shop.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cn.shop.service.TestService;
import com.cn.shop.service.UserService;
import com.cn.shop.domain.User;

//Ö÷Ò³Èë¿Ú
@Controller
public class MainController {
	
	@Autowired
    private TestService testService;
	@Autowired
	private UserService userService;

	@RequestMapping(value = "test", method = RequestMethod.GET)
	public String test(){//http://localhost:8080/webDemo/test
	//webDemo/WebRoot.views/test.jsp ,spring-mvc.xml
		int a=1;
		return "test";
	}
	
	@RequestMapping(value="hello")  
	public ModelAndView printWelcome(HttpServletRequest request,HttpServletResponse response) {  
	    ModelAndView mav= new ModelAndView();  
	    mav.addObject("city","Shanghai");  
	    mav.setViewName("hello");  
	    
		Long id = new Long(1);
        
		User user = userService.get(id);
		
		if( user == null) {
			System.out.println("No such ID user!");
		} else {
			System.out.println(user.getName());
		}
	    
	    
	    return mav;  
	}
	
	
	@RequestMapping(value = "springtest", method = RequestMethod.GET)
    public String springTest(){
        return testService.test();
    }
	
	
	@RequestMapping(value = "saveUser", method = RequestMethod.GET)
	@ResponseBody
    public String saveUser(){
		User user = new User();
		
		
		user.setName("Zhangsan");
		user.setPassword("111222");
		user.setCellPhone("18806135087");
		user.setEmail("12479@163.com");
		
        long result = userService.save(user);
       
       
		
//		Long id = new Long(4);
        user = userService.get(result);
        
//        System.out.println(user.getName());
        
//        return "success!";
        
        return user.getName();
    }
	
	
	@RequestMapping(value = "saveUsr", method = RequestMethod.POST)
	@ResponseBody
    public String saveUsr(){
		User user = new User();
		
		
		user.setName("Zhangsan");
		user.setPassword("111222");
		user.setCellPhone("18806135087");
		user.setEmail("12479@163.com");
		
        long result = userService.save(user);
       
        user = userService.get(result);
        
        return user.getName();
    }
	
	
	@RequestMapping(value = "getUser", method = RequestMethod.GET)
	@ResponseBody
    public String getUser(Long userId){//http://localhost:8080/webDemo/getUser
		Long id = new Long(1);
//		User user = userService.get(id);
        
		User user = userService.get(id);
		
		if( user == null) {
			return "No such ID user!";
		} else {
			System.out.println(user.getName());
	        return user.getName();
		}
    }
	
}
