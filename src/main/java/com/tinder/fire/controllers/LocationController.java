package com.tinder.fire.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tinder.fire.models.Location;
import com.tinder.fire.repository.LocationRepository;

@RestController()
@RequestMapping("/api/maps")
public class LocationController {
	
	@Autowired()
	private LocationRepository locationRepository;

	@PostMapping()
	public Location newLocation(@RequestBody() Location local) {
		locationRepository.save(local);
		return local;
	}
	
	@GetMapping(path = "/locations")
	public Iterable<Location> getLocations() {
		return locationRepository.findAll();
	}
}
