package com.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bean.ResponseBean;
import com.entity.UserEntity;
import com.repository.UserRepository;

@CrossOrigin
@RestController
public class RSessionController {

	@Autowired
	UserRepository userRepo;

//	@PostMapping("/signup")
//	public ResponseEntity<UserEntity> signup(@RequestBody UserEntity user) {
//
//		Optional<UserEntity> dbUser = userRepo.findByEmail(user.getEmail());
//
//		if (dbUser.isEmpty()) {
//			userRepo.save(user);
//			return ResponseEntity.ok(user);// 200 new user
//		} else {
//			return ResponseEntity.unprocessableEntity().body(user);
//
////			return new ResponseEntity<UserEntity>(user, HttpStatus.UNPROCESSABLE_ENTITY);
//		}
//
//	}

	@PostMapping("/signup")
	public ResponseEntity<ResponseBean<UserEntity>> signup(@RequestBody UserEntity user) {

		Optional<UserEntity> dbUser = userRepo.findByEmail(user.getEmail());

		if (dbUser.isEmpty()) {
			userRepo.save(user);

			ResponseBean<UserEntity> res = new ResponseBean<>();
			res.setData(user);
			res.setMsg("signup done");

			return ResponseEntity.ok(res);// 200 new user
		} else {
			ResponseBean<UserEntity> res = new ResponseBean<>();
			res.setData(user);
			res.setMsg("Email already Taken");

			return ResponseEntity.unprocessableEntity().body(res);

//			return new ResponseEntity<UserEntity>(user, HttpStatus.UNPROCESSABLE_ENTITY);
		}

	}    
}
