package com.controller;

import java.lang.reflect.Method;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bean.UserBean;
import com.dao.UserDao;


public class SessionController {
	
	@Autowired
	UserDao dao;

 //	public String signup()
	public UserBean signup(@RequestBody UserBean bean)
	{
		
//		return "SignUp Done";
		
		dao.addUser(bean);
		return bean;
	}
	
	
	
	
}
