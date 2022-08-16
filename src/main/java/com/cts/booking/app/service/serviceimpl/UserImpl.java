package com.cts.booking.app.service.serviceimpl;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.booking.app.Repositery.UserRepository;
import com.cts.booking.app.model.Appointement;
import com.cts.booking.app.model.User;
import com.cts.booking.app.model.UserLogin;
import com.cts.booking.app.service.*;

@Service
public class UserImpl implements UserService {

	@Autowired
	private UserRepository userRepositery;

	@Override
	public void saveUser(@Valid User user) {

		userRepositery.save(user);
	}

	@Override
	public List<User> findAllUser() {

		return userRepositery.findAll();
	}

	@Override
	public Optional<User> findUserById(String id) {

		return userRepositery.findById(id);
	}

	@Override
	public void deleteUserById(String id) {
		userRepositery.deleteById(id);
	}

	@Override
	public void UpdateUserByID(User user) {
		// TODO Auto-generated method stub
		userRepositery.save(user);
	}

	@Override
	public void loginUser(@Valid User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean validateUser(@Valid UserLogin user) {
		List<User> userDetails = userRepositery.findByEmailAndPassword(user.getEmail(), user.getPassword());
		return !userDetails.isEmpty();
	}

//	@Override
//	public Status loginUser(@Valid @RequestBody User user) {
//		List<User> users = userRepositery.findAll();
//		for (User other : users) {
//			if (other.equals(user)) {
//				user.setLoggedIn(true);
//				userRepositery.save(user);
//				return Status.SUCCESS;
//			}
//		}
//		return Status.FAILURE;
//	}

}
