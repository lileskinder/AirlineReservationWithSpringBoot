package com.example.airline_reservation.Model;

public enum RoleType {
    ADMIN("Admin"), AGENT("Agent"), PASSENGER("Passenger");

    private final String roleType;

    RoleType(final String roleType) {
        this.roleType = roleType;
    }

    @Override
    public String toString() {
        return roleType;
    }
}
