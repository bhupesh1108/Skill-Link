package com.demo.dao;

import java.util.List;
import javax.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.demo.model.ServiceProvider;

@Repository
public interface ServiceProviderDao extends JpaRepository<ServiceProvider, Integer>{

	
	@Query("SELECT u FROM ServiceProvider u WHERE u.Username = ?1 AND u.Password = ?2")
    ServiceProvider validateServiceProvider(String username, String password);

	
	
}