package com.cts.booking.app.service.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.booking.app.Repositery.AppointementRepositery;
import com.cts.booking.app.model.Appointement;
import com.cts.booking.app.service.AppointementService;

@Service
public class AppointementImpl implements AppointementService {

	@Autowired
	private AppointementRepositery appointementRepositery;

	@Override
	public boolean saveAppointement(Appointement appointement) {
		appointementRepositery.save(appointement);
		return true;
	}

	@Override
	public List<Appointement> findAllAppointements() {
		return appointementRepositery.findAll();
	}

	@Override
	public Optional<Appointement> findAppointementById(String id) {
		return appointementRepositery.findById(id);
	}

	@Override
	public void deleteAppointementById(String id) {
		appointementRepositery.deleteById(id);
	}

	@Override
	public void UpdateAppointementByID(Appointement appointement) {
		appointementRepositery.save(appointement);

	}
}
