package com.Restaurants.Service;

import com.Restaurants.Exception.UserServiceException;
import com.Restaurants.Model.User;

public interface UserService {

	User saveUser(User user) throws UserServiceException;

//	User getUser(String username);

}
