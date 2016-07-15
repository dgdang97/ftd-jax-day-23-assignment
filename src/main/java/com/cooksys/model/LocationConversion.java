package com.cooksys.model;

public class LocationConversion {
	
	private Long id;
	private String location;
	private Long conversionRate;

	public LocationConversion() {
		super();
	}

	public LocationConversion(Location location) {
		super();
		this.id = location.getLocationId();
		this.location = location.getLocationName();
		this.conversionRate = (location.getLocationViews() / location.getLocationConversions());
	}
	
	public LocationConversion(Long id, String location, Long conversionRate) {
		super();
		this.id = id;
		this.location = location;
		this.conversionRate = conversionRate;
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

	public Long getConversionRate() {
		return conversionRate;
	}

	public void setConversionRate(Long conversionRate) {
		this.conversionRate = conversionRate;
	}

}
