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

import com.cts.booking.app.model.Appointement;
import com.cts.booking.app.service.AppointementService;
import com.cts.booking.app.urls.*;

@CrossOrigin(origins = "http://localhost:7676")
@RestController
public class AppointementController {

	@Autowired
	private AppointementService appointementService;

	@GetMapping(Constants.VIEW_ALL_APPOINTEMENTS)
	public List<Appointement> getAppointement() {
		return appointementService.findAllAppointements();
	}

	@PostMapping(Constants.NEW_APPOINTEMENT)
	public ResponseEntity<?> bookAppointement(@RequestBody @Valid Appointement appointement, BindingResult result) {
		if (result.hasErrors()) {
			return new ResponseEntity(result.getAllErrors(), HttpStatus.BAD_REQUEST);
		}
		System.out.println(appointement.toString());
		appointementService.saveAppointement(appointement);
		return ResponseEntity.ok("Appointement Booked successfully");
	}

	@PutMapping(Constants.UPDATE_APPOINTEMENT)
	public String update(@RequestBody Appointement appointement) {
		appointementService.UpdateAppointementByID(appointement);
		return "Update Sucessfull";
	}

	@GetMapping(Constants.SPECIFIC_APPOINTEMENT)
	public Optional<Appointement> getAppointement(@PathVariable String id) {
		return appointementService.findAppointementById(id);
	}

	@DeleteMapping(Constants.DELETE_APPOINTEMENT)
	public String deleteAppointement(@PathVariable String id) {
		appointementService.deleteAppointementById(id);
		return "Appointement deleted";
	}
}
