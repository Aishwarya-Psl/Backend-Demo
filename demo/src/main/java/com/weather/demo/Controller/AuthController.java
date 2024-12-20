package com.weather.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.weather.demo.entity.User;
import com.weather.demo.service.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {
	
	@Autowired
	private AuthService authService;
	
	@PostMapping("/signup")
	public User signUp(@RequestBody User user) {
		return authService.signUp(user);
	}
	
	@PostMapping("/login")
	public User login(@RequestParam String userName,@RequestParam String password) {
		return authService.login(userName, password);
	}
}
