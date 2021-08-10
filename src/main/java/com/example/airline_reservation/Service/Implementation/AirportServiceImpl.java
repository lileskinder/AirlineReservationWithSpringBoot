package com.example.airline_reservation.Service.Implementation;

import com.example.airline_reservation.Service.AirportService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
@Service
@Transactional
public class AirportServiceImpl implements AirportService {
//    @Autowired
//    AirportRepo airportRepository;
//
//
//    public List<AirportDTO> getAllAirport(){
//        List<AirportDTO> airportDTOList = new ArrayList<>();
//
//        for(Airport airport: airportRepository.findAll()) {
//            airportDTOList.add(AirportDTOAdapter.getAirportDTO(airport));
//        }
//
//        return airportDTOList;
//    }
//
//    public AirportDTO save(AirportDTO airportDTO){
//        Airport airport = AirportDTOAdapter.getAirport(airportDTO);
//        airportRepository.save(airport);
//        return airportDTO;
//    }
//
//    @Override
//    public AirportDTO Update(AirportDTO airportDTO) {
//        return null;
//    }
//
//    public Airport getAirportById(int airportId){
//        return airportRepository.findById(airportId).get();
//    }
//
//    public AirportDTO Update(int airportId, AirportDTO airportDTO){
//        Airport airport1 = AirportDTOAdapter.getAirport(airportDTO);
//        Airport airport = airportRepository.findById(airportId).get();
//        airport.setCode(airport1.getCode());
//        airport.setName(airport1.getName());
//        airport.setAddress(airport1.getAddress());
//
//        airportRepository.save(airport);
//        return airportDTO;
//    }
//    public void deleteAirport(int airportId){
//        boolean exists=airportRepository.existsById(airportId);
//        if(!exists){
//            throw new IllegalStateException("Airport"+airportId+" doest not exists");
//        }
//        airportRepository.deleteById(airportId);
//    }
//

}
