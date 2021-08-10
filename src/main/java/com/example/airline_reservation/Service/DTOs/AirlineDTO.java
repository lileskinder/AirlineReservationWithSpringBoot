package com.example.airline_reservation.Service.DTOs;

import lombok.Data;

@Data
public class AirlineDTO {
    private String code;
    private String name;
    private String history;

    public AirlineDTO() {
    }

    public AirlineDTO(String code, String name, String history) {
        this.code = code;
        this.name = name;
        this.history = history;
    }
}
