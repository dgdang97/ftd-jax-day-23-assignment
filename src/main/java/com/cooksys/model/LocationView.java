package com.cooksys.model;

public class LocationView {

	private Long id;
	private String location;
	private Long views;

	public LocationView() {
		super();
	}

	public LocationView(Location location) {
		super();
		this.id = location.getLocationId();
		this.location = location.getLocationName();
		this.views = location.getLocationViews();
	}
	
	public LocationView(Long id, String location, Long views) {
		super();
		this.id = id;
		this.location = location;
		this.views = views;
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

	public Long getViews() {
		return views;
	}

	public void setViews(Long views) {
		this.views = views;
	}

}
