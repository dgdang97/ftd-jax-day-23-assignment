package com.cooksys.model;

import java.util.ArrayList;
import java.util.List;

public class GetLocation {

	private Long id;
	
	private String location;
	
	public GetLocation() {
		super();
	}

	public GetLocation(Long id, String location) {
		super();
		this.id = id;
		this.location = location;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public static List<GetLocation> list(List<Location> list) {
		List<GetLocation> locations = new ArrayList<>();
		for (Location l: list) {
			locations.add(new GetLocation(l.getLocationId(), l.getLocationName()));
		}
		return locations;
	}
	
}
