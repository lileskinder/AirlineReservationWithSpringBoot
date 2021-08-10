package com.example.airline_reservation.Service.Configs;

import com.example.airline_reservation.DAO.FlightRepo;
import com.example.airline_reservation.Model.Airline;
import com.example.airline_reservation.Model.Airport;
import com.example.airline_reservation.Model.Flight;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;

@Configuration
public class FlightConfig {

//    @Bean
//    CommandLineRunner commandLineRunner(FlightRepo flightRepo) {
//        return args -> {
//            Airline airline1 = new Airline();
//            Airline airline2 = new Airline();
//            Airport departureAirport = new Airport();
//            Airport arrivalAirport = new Airport();
//
//            Flight flight = new Flight(123, 400, airline1, departureAirport, arrivalAirport, LocalDateTime.now(), LocalDateTime.of(2021, 8, 9, 3, 00));
//            flightRepo.save(flight);
//        };
//    }
}
