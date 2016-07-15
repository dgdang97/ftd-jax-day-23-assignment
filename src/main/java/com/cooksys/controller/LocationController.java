package com.cooksys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.model.GetLocation;
import com.cooksys.model.GetUserByLocationId;
import com.cooksys.model.Location;
import com.cooksys.model.LocationConversion;
import com.cooksys.model.LocationView;
import com.cooksys.model.User;
import com.cooksys.service.UserService;

@RestController
public class LocationController {

	@Autowired
	UserService userService;
	
	@RequestMapping(value = "newLocation", method = RequestMethod.POST)
	public String newLocation(@RequestBody Location location) {
		return userService.newLocation(location);
	}
	
	@RequestMapping(value = "newUser", method = RequestMethod.POST)
	public String newLocation(@RequestBody User user) {
		return userService.newUser(user);
	}

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(@RequestBody User user) {
		return userService.login(user);
	}

	@RequestMapping(value = "viewLocation", method = RequestMethod.POST)
	public String viewLocation(@RequestBody Location location) {
		return userService.viewLocation(location);
	}

	@RequestMapping(value = "users/{locationId}", method = RequestMethod.GET)
	public GetUserByLocationId getUserByLocation(@PathVariable Long locationId) {
		return userService.getUserByLocation(locationId);
	}

	@RequestMapping(value = "location", method = RequestMethod.GET)
	public List<GetLocation> getLocations() {
		return userService.getLocations();
	}

	@RequestMapping(value = "{locationId}", method = RequestMethod.GET)
	public LocationView getLocationViews(@PathVariable Long locationId) {
		return userService.getLocationViews(locationId);
	}

	@RequestMapping(value = "rate/{locationId}", method = RequestMethod.GET)
	public LocationConversion getLocationConversion(@PathVariable Long locationId) {
		return userService.getLocationConversion(locationId);
	}
}
