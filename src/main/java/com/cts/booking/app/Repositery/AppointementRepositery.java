package com.cts.booking.app.Repositery;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cts.booking.app.model.Appointement;

public interface AppointementRepositery extends MongoRepository<Appointement, String> {

	//List<Appointement> findAllAppointements(String id);
}
