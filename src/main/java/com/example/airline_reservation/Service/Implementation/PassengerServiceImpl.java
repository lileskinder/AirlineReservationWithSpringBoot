package com.example.airline_reservation.Service.Implementation;

import com.example.airline_reservation.DAO.PassengerRepo;
import com.example.airline_reservation.Model.Address;
import com.example.airline_reservation.Model.Passenger;
import com.example.airline_reservation.Model.Person;
import com.example.airline_reservation.Service.DTOs.DTOAdapters.PassengerDTOAdapter;
import com.example.airline_reservation.Service.DTOs.PassengerDTO;
import com.example.airline_reservation.Service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
@Transactional
public class PassengerServiceImpl implements PassengerService {

    @Autowired
    PassengerRepo passengerRepo;

    public PassengerDTO addPassenger(PassengerDTO passengerDTO) {
        Passenger passenger = PassengerDTOAdapter.getPassenger(passengerDTO);
        return PassengerDTOAdapter.getPassengerDTO(passengerRepo.save(passenger));
    }

    public PassengerDTO getPassengerById(int id) {
        return PassengerDTOAdapter.getPassengerDTO(passengerRepo.getById(id));
    }
}
