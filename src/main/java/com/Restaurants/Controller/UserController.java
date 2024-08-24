package com.Restaurants.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.GetExchange;

import com.Restaurants.Exception.UserServiceException;
import com.Restaurants.Model.User;
import com.Restaurants.Service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;

	@PostMapping("/register")
	public ResponseEntity<User> register(@RequestBody User user) {
		try {
			User savedUser = this.userService.saveUser(user);
			return new ResponseEntity<User>(savedUser, HttpStatus.CREATED);
		} catch (UserServiceException e) {

			return new ResponseEntity<User>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/users/register")
	public ResponseEntity<User> UserRegister(@RequestBody User user) {
		try {
			user.setRole("user");
			User savedUser = this.userService.saveUser(user);
			return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
		} catch (UserServiceException e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

//	@GetMapping("/getuser/{username}")
//	ResponseEntity<User> GetUserData(@PathVariable String username) {
//		User user = this.userService.getUser(username);
//		return new ResponseEntity<User>(user, HttpStatus.CREATED);
//	}
}
