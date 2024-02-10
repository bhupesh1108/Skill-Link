package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.Product;
import com.demo.model.ServiceProvider;
import com.demo.service.ServiceProviderServ;

@RequestMapping("/serviceprovider")
@RestController
@CrossOrigin
public class ServiceProviderController {
	@Autowired
	private ServiceProviderServ ServiceProviderObj;
	
	@GetMapping("/getall")
	public ResponseEntity<List<ServiceProvider>> getallproducts(){
		List<ServiceProvider> splist=ServiceProviderObj.getall();
		return ResponseEntity.ok(splist);	
	}
	@PostMapping("/register")
	public ResponseEntity<String> insertProduct(@RequestBody ServiceProvider sp){
		System.out.println(sp);
		ServiceProviderObj.addServiceProvider(sp);
		return ResponseEntity.ok("data added successfully");
		
	}	
	@PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody ServiceProvider user) {
       ServiceProvider sp= ServiceProviderObj.validate(user.getUsername(),user.getPassword());
       if (sp != null) {
           return ResponseEntity.ok("Login successful!");
       } else {
   
    	   return ResponseEntity.ok("Login failed!");
       }
    }
}
