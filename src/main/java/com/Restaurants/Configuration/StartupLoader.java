package com.Restaurants.Configuration;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.Restaurants.Model.User;
import com.Restaurants.Repository.UserRepository;
import com.Restaurants.Service.UserService;

import jakarta.transaction.Transactional;

@Component
public class StartupLoader implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	UserRepository userRepository;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		createAdminRoleIfNotFound();
	}

	@Transactional
	void createAdminRoleIfNotFound() {

		// Create or fetch the user
		List<User> findAll = this.userRepository.findAll();

		if (findAll.isEmpty()) {
			User adminUser = new User();
			adminUser.setId(1);
			adminUser.setUserName("Admin101");
			adminUser.setName("Rikesh Kumar");
			adminUser.setPassword("Admin@123");
			adminUser.setConfPassword("Admin@123");
			adminUser.setEmailId("rikeshkumar@gmail.com");
			adminUser.setRole("admin");
			adminUser.setMobileNo("900000000");
			adminUser.setAddress("Motihari");

			this.userRepository.save(adminUser);
		}
	}

}
