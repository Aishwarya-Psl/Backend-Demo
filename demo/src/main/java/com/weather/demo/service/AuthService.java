package com.weather.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.weather.demo.entity.User;
import com.weather.demo.repository.UserRepository;

@Service
public class AuthService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public User signUp(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassWord()));
		return userRepository.save(user);
	}
	
	public User login(String userName,String password) {
		User user=userRepository.findByUserName(userName).orElseThrow(()->new RuntimeException("User Not Found"));
		if(!passwordEncoder.matches(password, user.getPassWord())) {
			throw new RuntimeException("Invalid Password");
		}
		return user;
	}
}
