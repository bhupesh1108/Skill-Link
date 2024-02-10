package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.service.UserService;

@RequestMapping("/")
@RestController
public class UserController {
	
	@Autowired
	UserService uservice;
	
	@GetMapping("/")
	public String Login(){
		return "Login";
	}
	
}
