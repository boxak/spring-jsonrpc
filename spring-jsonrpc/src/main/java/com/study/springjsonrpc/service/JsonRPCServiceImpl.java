package com.study.springjsonrpc.service;

import java.sql.SQLException;
import java.util.Date;

import com.study.springjsonrpc.dao.UserDao;
import com.study.springjsonrpc.domain.User;

public class JsonRPCServiceImpl implements JsonRPCService {
	
	private UserDao userDao;
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

    @Override
    public String getUserById(String id) {

        String name = "";

        try {
//        	ApplicationContext context = 
//        			new GenericXmlApplicationContext("beans.applicationContext.xml");
//        	UserDao userDao = context.getBean("userDao", UserDao.class);
            name = userDao.getUserById(id).getName();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return name;
    }
    
    @Override
    public void addUser(String id, String name, String password) {
    	try {
    		User user = new User();
    		user.setId(id);
    		user.setName(name);
    		user.setPassword(password);
    		userDao.add(user);
    	} catch(Exception e) {
    		e.printStackTrace();
    	}
    }
    
    @Override
    public String getServerTime() {
    	Date date = new Date();
    	System.out.println(date);
    	return String.valueOf(date);
    }
}
