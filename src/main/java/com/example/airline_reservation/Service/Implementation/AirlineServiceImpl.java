package com.example.airline_reservation.Service.Implementation;

import com.example.airline_reservation.DAO.AirlineRepo;
import com.example.airline_reservation.Model.Airline;
import com.example.airline_reservation.Service.AirlineService;
import com.example.airline_reservation.Service.DTOs.AirlineDTO;

import com.example.airline_reservation.Service.DTOs.DTOAdapters.AirlineDTOAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AirlineServiceImpl implements AirlineService {

    private final AirlineRepo airlineRepo;

    @Autowired
    AirlineServiceImpl(AirlineRepo airlineRepo){
        this.airlineRepo=airlineRepo;
    }

    @Override
    public Airline findById(Integer id) {
        boolean found = airlineRepo.existsById(id);
        if (!found){
            throw new IllegalStateException("Airline with this id Not Found");
        }
        return airlineRepo.findById(id).get();
    }
    @Override
    public Airline findByCode(String code){

        return airlineRepo.findByCode(code).get();
    }

    @Override
    public List<AirlineDTO> findAll(Optional<Integer> page) {
        Pageable pagination = PageRequest.of(page.orElse(0), 10);
        List<AirlineDTO> airlineDTOList = new ArrayList<>();

        for (Airline airline: airlineRepo.findAll(pagination)) {
            airlineDTOList.add(AirlineDTOAdapter.getAirlineDTO(airline));
        }

        return airlineDTOList;
    }

    @Override
    public AirlineDTO save(AirlineDTO airlineDTO) {
        Airline airline = AirlineDTOAdapter.getAirline(airlineDTO);
        Optional<Airline> airlineOptional = airlineRepo.findByCode(airlineDTO.getCode());

        if(airlineOptional.isPresent()) {
            throw new IllegalStateException("code "+airlineOptional+"is already taken please provide another one");
        }

        airlineRepo.save(airline);

        return airlineDTO;
    }

    @Override
    public AirlineDTO Update(int id, AirlineDTO airlinDTO) {
        boolean found = airlineRepo.existsById(id);
        if (!found){
            throw new IllegalStateException("Airline with this id Not Found");
        }
        Airline airport1 = AirlineDTOAdapter.getAirline(airlinDTO);
        Airline airport = airlineRepo.findById(id).get();
        airport.setCode(airport1.getCode());
        airport.setName(airport1.getName());

        airlineRepo.save(airport);
        return airlinDTO;
    }

    @Override
    public void delete(int id){
        boolean exists=airlineRepo.existsById(id);
        if(!exists){
            throw new IllegalStateException("Airline"+id+" doest not exists");
        }
        airlineRepo.deleteById(id);
        System.out.println("deleted");
    }
}
