package com.cts.booking.app.Repositery;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cts.booking.app.model.User;

public interface UserRepository extends MongoRepository<User, String> {
	boolean findByEmail(String email);

	List<User> findByEmailAndPassword(String email, String password);
}
