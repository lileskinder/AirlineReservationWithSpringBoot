package com.example.airline_reservation.Service.Implementation;

import com.example.airline_reservation.DAO.AirportRepo;

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
    @Autowired
    AirportRepo airportRepository;


    public List<AirportDTO> getAllAirport(){
        List<AirportDTO> airportDTOList = new ArrayList<>();

        for(Airport airport: airportRepository.findAll()) {
            airportDTOList.add(AirportDTOAdapter.getAirportDTO(airport));
        }

        return airportDTOList;
    }

    public AirportDTO save(AirportDTO airportDTO){
        Airport airport = AirportDTOAdapter.getAirport(airportDTO);
        airportRepository.save(airport);
        return airportDTO;
    }

    @Override
    public AirportDTO Update(AirportDTO airportDTO) {
        return save(airportDTO);
    }

    public Airport getAirportByCode(String airportCode){
        return airportRepository.findByCode(airportCode);
    }

    @Override
    public AirportDTO Update(int airportId, AirportDTO airportDTO){
        Airport newAirport = AirportDTOAdapter.getAirport(airportDTO);
        Airport airport = airportRepository.findById(airportId).get();
        airport.setCode(newAirport.getCode());
        airport.setName(newAirport.getName());
        airport.setAddress(newAirport.getAddress());

        airportRepository.save(airport);
        return airportDTO;
    }
    public void deleteAirport(int airportId){
        boolean exists=airportRepository.existsById(airportId);
        if(!exists){
            throw new IllegalStateException("Airport"+airportId+" doest not exists");
        }
        airportRepository.deleteById(airportId);
    }


}
