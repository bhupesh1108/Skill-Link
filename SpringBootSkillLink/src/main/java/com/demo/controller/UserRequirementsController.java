package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


import com.demo.model.UserRequirements;
import com.demo.service.UserRequirementsService;

@RequestMapping("/a")
@RestController
@CrossOrigin
public class UserRequirementsController {
	
	@Autowired
	private UserRequirementsService userrequirement;
	
	@PostMapping("/insert")
	public ResponseEntity<?> insertUserRequirement(@RequestBody UserRequirements u){
		
		userrequirement.addnewuserrequirement(u);
		return ResponseEntity.ok("data added successfully");
		
	}
	
	@GetMapping("/userrequirements")
	public ResponseEntity<List<UserRequirements>> getalluserrequirements(){
		List<UserRequirements> ulist=userrequirement.getAllService();
		System.out.println("ulist");
		return ResponseEntity.ok(ulist);
		
	}

}
