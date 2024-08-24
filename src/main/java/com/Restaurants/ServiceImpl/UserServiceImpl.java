package com.Restaurants.ServiceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.Restaurants.Exception.UserServiceException;
import com.Restaurants.Model.User;
import com.Restaurants.Repository.UserRepository;
import com.Restaurants.Service.UserService;

@Service
public class UserServiceImpl implements UserService {

	 private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	    @Autowired
	    private UserRepository userRepository;

	    @Autowired
	    private PasswordEncoder passwordEncoder;

	    @Override
	    public User saveUser(User user) throws UserServiceException {
	        try {
	            String encodedPassword = passwordEncoder.encode(user.getPassword());
	            user.setPassword(encodedPassword);

	            String encodedConfPassword = passwordEncoder.encode(user.getConfPassword());
	            user.setConfPassword(encodedConfPassword);

	            User savedUser = this.userRepository.save(user);

	            // Clear sensitive information before returning
	            savedUser.setPassword(null);
	            savedUser.setConfPassword(null);

	            logger.info("User saved successfully: {}", savedUser);

	            return savedUser;
	        } catch (Exception e) {
	            logger.error("An error occurred while saving the user.", e);
	            throw new UserServiceException("An error occurred while saving the user.", e);
	        }
	    }

//
//	@Override
//	public User getUser(String username) {
//		User findByUserName = this.userRepository.findByUserName(username);
//		return findByUserName;
//	}
}
