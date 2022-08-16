package com.cts.booking.app.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.cts.booking.app.model.Appointement;
import com.cts.booking.app.model.User;
import com.cts.booking.app.model.UserLogin;

@Service
public interface UserService {

	void saveUser(@Valid User user);

	List<User> findAllUser();

	Optional<User> findUserById(String id);

	void deleteUserById(String id);

	void loginUser(@Valid User user);

	void UpdateUserByID(User user);

	boolean validateUser(@Valid UserLogin user);

}
