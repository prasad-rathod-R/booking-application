package com.cts.booking.app.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cts.booking.app.Repositery.UserRepository;
import com.cts.booking.app.model.Appointement;
import com.cts.booking.app.model.User;
import com.cts.booking.app.model.UserLogin;
import com.cts.booking.app.service.Status;
import com.cts.booking.app.service.UserService;

import lombok.extern.slf4j.Slf4j;
import com.cts.booking.app.urls.*;

@CrossOrigin(origins = "http://localhost:7676")
@RestController
@Slf4j
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping(Constants.NEW_USER)
	public ResponseEntity<?> addUser(@RequestBody @Valid User user, BindingResult result) {
		if (result.hasErrors()) {
			return (ResponseEntity<?>) ResponseEntity.badRequest();

			// return new ResponseEntity(result.getAllErrors(), HttpStatus.BAD_REQUEST);
		}
		userService.saveUser(user);
		return ResponseEntity.ok("User added successfully");
	}

	@GetMapping(Constants.ALL_USER)
	public List<User> getUser() {
		return userService.findAllUser();
	}

	@GetMapping(Constants.SPECIFIC_USER)
	public Optional<User> getUser(@PathVariable String id) {
		return userService.findUserById(id);
	}

	@DeleteMapping(Constants.DELETE_USER)
	public String deleteUser(@PathVariable String id) {
		userService.deleteUserById(id);
		return "user deleted";
	}

	@PostMapping(Constants.SIGNIN_USER)
	public ResponseEntity<?> signIn(@RequestBody @Valid User user, BindingResult result) {
		userService.loginUser(user);
		return ResponseEntity.ok("signin successfull");
	}

	@PutMapping("/updateUser")
	public String update(@RequestBody User user) {
		userService.UpdateUserByID(user);
		return "Update Sucessfull";
	}

	@PostMapping("/users/login")
	public Status loginUser(@Valid @RequestBody UserLogin user) {
		boolean isUserValid = userService.validateUser(user);
		if (isUserValid) {
			return Status.SUCCESS;
		}
		
		return Status.FAILURE;
	}

}
