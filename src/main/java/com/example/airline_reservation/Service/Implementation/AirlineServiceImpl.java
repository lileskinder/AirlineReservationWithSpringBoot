package com.example.airline_reservation.Service.Implementation;

import com.example.airline_reservation.DAO.AirlineRepo;
import com.example.airline_reservation.Model.Airline;
import com.example.airline_reservation.Service.AirlineService;
import com.example.airline_reservation.Service.DTOs.AirlineDTO;
import com.example.airline_reservation.Service.DTOs.DTOAdapters.AirlineDTOAdapter;
import org.springframework.beans.factory.annotation.Autowired;
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
    public AirlineServiceImpl(AirlineRepo airlineRepo) {
        this.airlineRepo = airlineRepo;
    }

    @Override
    public List<AirlineDTO> findAll() {
        List<AirlineDTO> airlineDTOList = new ArrayList<>();

        for (Airline airline: airlineRepo.findAll()) {
            airlineDTOList.add(AirlineDTOAdapter.getAirlineDTO(airline));
        }

        return airlineDTOList;
    }

    @Override
    public AirlineDTO findById(Integer id) {

        Optional<Airline> optionalAirlineDTO = airlineRepo.findById(id);
       if(optionalAirlineDTO.isPresent()){
            return AirlineDTOAdapter.getAirlineDTO(optionalAirlineDTO.get());
       }else{
           throw new IllegalStateException("Airline with id " + id + " does not exists");
       }
    }

    @Override
    public AirlineDTO save(AirlineDTO airlineDTO) {
        Airline airline = AirlineDTOAdapter.getAirline(airlineDTO);
        airlineRepo.save(airline);

        return airlineDTO;
    }
}
