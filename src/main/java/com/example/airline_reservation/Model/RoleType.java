package com.example.airline_reservation.Model;

public enum RoleType {
	ADMIN("ADMIN"), AGENT("AGENT"), PASSENGER("PASSENGER");

	private final String roleType;

	RoleType(final String roleType) {
		this.roleType = roleType;
	}

	@Override
	public String toString() {
		return roleType;
	}
}
