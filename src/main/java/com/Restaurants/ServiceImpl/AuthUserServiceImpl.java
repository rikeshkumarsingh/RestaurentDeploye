package com.Restaurants.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.Restaurants.Model.User;
import com.Restaurants.Repository.UserRepository;

@Service
public class AuthUserServiceImpl implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = this.userRepository.findByUserName(username);
		
//		if (user == null || !user.isEnabled()) {
//			throw new UsernameNotFoundException("User Not Found");
//		}
//		return user;
		 if (user == null) {
	            throw new UsernameNotFoundException("User not found with username: " + username);
	        }

	        return (UserDetails) user; 
	}
}
