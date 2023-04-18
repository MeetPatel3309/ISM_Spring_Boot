package com.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.UserBean;

@Repository
public class userDAO {
	
	@Autowired
	JdbcTemplate stmt ;
	
	public void addUser(UserBean bean) {

		String insertUser = "Insert into users(firstName,lastName,email,password) VALUES (?,?,?,?)";
		
		stmt.update(insertUser, bean.getFirstName(),bean.getLastName(),bean.getEmail(),bean.getPassword());
		
		
	}

}
