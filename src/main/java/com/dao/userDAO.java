package com.dao;

import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.UserBean;

@Repository
public class UserDao {

	@Autowired
	JdbcTemplate stmt;

	public void addUser(UserBean bean) {

		String insertUser = "Insert into users(firstName,lastName,email,password) VALUES (?,?,?,?)";

		stmt.update(insertUser, bean.getFirstName(), bean.getLastName(), bean.getEmail(), bean.getPassword());

	}

}
