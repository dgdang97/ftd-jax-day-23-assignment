package com.cooksys.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cooksys.model.GetLocation;
import com.cooksys.model.GetUserByLocationId;
import com.cooksys.model.Location;
import com.cooksys.model.LocationConversion;
import com.cooksys.model.LocationView;
import com.cooksys.model.RNGMessages;
import com.cooksys.model.User;
import com.cooksys.repository.LocationRepository;
import com.cooksys.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	LocationRepository lr;

	@Autowired
	UserRepository ur;

	private Boolean verifyUser(User user) {
		if (user.getUsername() != null) {
			if (user.getPassword() != null) {
				return true;
			}
		}
		return false;
	}

	public String newLocation(Location location) {
		if (location.getLocationName() != null) {
			Location check = lr.findByLocationName(location.getLocationName());
			if (check == null) {
				location.setLocationViews((long) 0);
				location.setLocationConversions((long) 0);
				lr.save(location);
				return "New location created!";
			} else {
				return "Location already registered!";
			}
		} else {
			return "The location name is missing! Please put a location name before trying again!";
		}
	}

	public String newUser(User user) {
		if (verifyUser(user)) {
			User check = ur.findByUsername(user.getUsername());
			if (check == null) {
				Location recordRegistration = lr.findByLocationName(user.getLocation());
				if (recordRegistration != null) {
					recordRegistration.setLocationConversions(recordRegistration.getLocationConversions() + 1);
					ur.save(user);
					return "User " + user.getUsername() + " registered!";
				} else {
					return "Registration failed. Location missing from input or database.";
				}
			} else {
				return "User " + user.getUsername() + " already registered!";
			}
		}
		return "Registration failed. Please review provided information before attempting again";
	}

	public String login(User user) {
		if (verifyUser(user)) {
			User check = ur.findByUsername(user.getUsername());
			Location recordLogin;
			if (check != null) {
				if (user.getPassword().equals(user.getPassword())) {
					if (user.getLocation() == null) {
						recordLogin = lr.findByLocationName(check.getLocation());
					} else {
						recordLogin = lr.findByLocationName(user.getLocation());
					}
					recordLogin.setLocationViews(recordLogin.getLocationViews() - 1);
					return "login Successful! Welcome back!";
				}
			}
		}
		return "login failed!";
	}

	public String viewLocation(Location location) {
		Location check = lr.findByLocationName(location.getLocationName());
		if (check != null) {
			RNGMessages rng = new RNGMessages();
			check.setLocationViews(check.getLocationViews() + 1);
			lr.save(check);
			return "Location viewed! " + rng.getMessage();
		} else {
			return "Location not found in the database! Did you misspell it?";
		}
	}

	public GetUserByLocationId getUserByLocation(Long locationId) {
		Location location = lr.findByLocationId(locationId);
		return GetUserByLocationId.list(location.getLocationName(), ur.findAll());
	}

	public List<GetLocation> getLocations() {
		return GetLocation.list(lr.findAll());
	}

	public LocationView getLocationViews(Long locationId) {
		Location location = lr.findByLocationId(locationId);
		return new LocationView(location);
	}

	public LocationConversion getLocationConversion(Long locationId) {
		return new LocationConversion(lr.findByLocationId(locationId));
	}

}
