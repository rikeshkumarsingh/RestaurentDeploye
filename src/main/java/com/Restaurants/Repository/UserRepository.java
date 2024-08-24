package com.Restaurants.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Restaurants.Model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	

	User findByUserName(String username);

}
