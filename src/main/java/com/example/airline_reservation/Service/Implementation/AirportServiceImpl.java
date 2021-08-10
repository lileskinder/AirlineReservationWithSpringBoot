package com.example.airline_reservation.Service.Implementation;

import com.example.airline_reservation.DAO.AirportRepo;
import com.example.airline_reservation.Model.Address;
import com.example.airline_reservation.Model.Airport;
import com.example.airline_reservation.Service.AirportService;
import com.example.airline_reservation.Service.DTOs.AirportDTO;
import com.example.airline_reservation.Service.DTOs.DTOAdapters.AirportDTOAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class AirportServiceImpl implements AirportService {
    private final AirportRepo airportRepository;

    @Autowired
    public AirportServiceImpl(AirportRepo airportRepository) {
        this.airportRepository = airportRepository;
    }

    @Override
    public List<AirportDTO> getAllAirport(){
        List<AirportDTO> airportDTOList = new ArrayList<>();
        //        String street, String city, String state, String zip

        for(Airport airport: airportRepository.findAll()) {
            Address address = new Address();
            airportDTOList.add(AirportDTOAdapter.getAirportDTO(airport));
        }

        return airportDTOList;
    }

    @Override
    public AirportDTO save(AirportDTO airportDTO){
        Airport airport = AirportDTOAdapter.getAirport(airportDTO);

        Address address = new Address(airport.getAddress().getState(), airport.getAddress().getCity(), airport.getAddress().getState(), airport.getAddress().getZip());
        airport.setAddress(address);
        airportRepository.save(airport);
        return airportDTO;
    }


    @Override
    public Airport getAirportById(int airportId){
        return airportRepository.findById(airportId).get();
    }

    @Override
    public AirportDTO Update(int airportId, AirportDTO airportDTO){
        Airport airport1 = AirportDTOAdapter.getAirport(airportDTO);
        Airport airport = airportRepository.findById(airportId).get();
        airport.setCode(airport1.getCode());
        airport.setName(airport1.getName());
        airport.setAddress(airport1.getAddress());

        airportRepository.save(airport);
        return airportDTO;
    }

    @Override
    public void deleteAirport(int airportId){
        boolean exists=airportRepository.existsById(airportId);
        if(!exists){
            throw new IllegalStateException("Airport"+airportId+" doest not exists");
        }
        airportRepository.deleteById(airportId);
    }


}
