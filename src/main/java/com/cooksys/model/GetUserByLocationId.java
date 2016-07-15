package com.cooksys.model;

import java.util.ArrayList;
import java.util.List;

public class GetUserByLocationId {

	private String location;
	private List<UserInfo> users;
	
	public GetUserByLocationId() {
		super();
	}
	public GetUserByLocationId(String location, List<UserInfo> users) {
		super();
		this.location = location;
		this.users = users;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public List<UserInfo> getUsers() {
		return users;
	}
	public void setUsers(List<UserInfo> users) {
		this.users = users;
	}
	public static GetUserByLocationId list(String location, List<User> list) {
		List<UserInfo> usersByLocation = new ArrayList<>();
		System.out.println(list.toArray());
		for (User u: list) {
			if (u.getLocation().equals(location)) {
				usersByLocation.add(new UserInfo(u.getUsername()));
			}
		}
		return new GetUserByLocationId(location, usersByLocation);
	}
	
}
