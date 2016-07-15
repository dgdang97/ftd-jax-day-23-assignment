package com.cooksys.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "location")
public class Location {

	@Id
	@GeneratedValue
	@Column(name = "location_id")
	private Long locationId;

	@Column(name="location_name")
	private String locationName;
	
	@Column(name="location_views")
	private Long locationViews;
	
	@Column(name="location_conversions")
	private Long locationConversions;
	
	public Location() {
		super();
	}

	public Location(Long locationId, String locationName, Long locationViews, Long locationConversions) {
		super();
		this.locationId = locationId;
		this.locationName = locationName;
		this.locationViews = locationViews;
		this.locationConversions = locationConversions;
	}

	public Long getLocationId() {
		return locationId;
	}

	public void setLocationId(Long locationId) {
		this.locationId = locationId;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public Long getLocationViews() {
		return locationViews;
	}

	public void setLocationViews(Long locationViews) {
		this.locationViews = locationViews;
	}

	public Long getLocationConversions() {
		return locationConversions;
	}

	public void setLocationConversions(Long locationConversions) {
		this.locationConversions = locationConversions;
	}

}
