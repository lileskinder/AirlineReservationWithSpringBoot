package com.example.airline_reservation.Service.DTOs;

import lombok.Data;

@Data
public class AirlineDTO {
    private String code;
    private String name;
    private String history;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHistory() {
		return history;
	}
	public void setHistory(String history) {
		this.history = history;
	}

}
