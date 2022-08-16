package com.cts.booking.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cts.booking.app.model.Appointement;

@Service
public interface AppointementService {

	public boolean saveAppointement(Appointement appointement);

	public List<Appointement> findAllAppointements();

	public Optional<Appointement> findAppointementById(String id);

	public void deleteAppointementById(String id);

	public void UpdateAppointementByID(Appointement appointement);

}
