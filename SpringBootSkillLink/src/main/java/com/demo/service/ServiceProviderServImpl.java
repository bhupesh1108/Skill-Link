package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.demo.dao.ServiceProviderDao;
import com.demo.model.ServiceProvider;

@Service
public class ServiceProviderServImpl implements ServiceProviderServ{

	@Autowired
	 private ServiceProviderDao spdao;
	
	@Override
	public List<ServiceProvider> getall() {
		List<ServiceProvider> splist=spdao.findAll();
		return splist;
	}

	@Override
	public void addServiceProvider(ServiceProvider sp) {
		spdao.save(sp);
	}

	@Override
	public ServiceProvider validate(String username, String password) {
		return spdao.validateServiceProvider(username, password);
		
	}

}
