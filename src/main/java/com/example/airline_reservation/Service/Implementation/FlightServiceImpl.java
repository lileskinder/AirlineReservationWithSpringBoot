package com.example.airline_reservation.Service.Implementation;

import com.example.airline_reservation.DAO.AirlineRepo;
import com.example.airline_reservation.DAO.AirportRepo;
import com.example.airline_reservation.DAO.FlightRepo;
import com.example.airline_reservation.Model.Flight;
import com.example.airline_reservation.Service.DTOs.DTOAdapters.FlightDTOAdapter;
import com.example.airline_reservation.Service.DTOs.FlightDTO;
import com.example.airline_reservation.Service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
public class FlightServiceImpl implements FlightService {

    private final FlightRepo flightRepo;
    private final AirlineRepo airlineRepo;
    private final AirportRepo airportRepo;

    @Autowired
    public FlightServiceImpl(FlightRepo flightRepo, AirlineRepo airlineRepo, AirportRepo airportRepo) {
        this.flightRepo = flightRepo;
        this.airlineRepo = airlineRepo;
        this.airportRepo = airportRepo;
    }

    @Override
    public List<FlightDTO> findAll() {
        List<FlightDTO> flightDTOList = new ArrayList<>();
        for (Flight flight : flightRepo.findAll()) {
            flightDTOList.add(FlightDTOAdapter.getFlightDTO(flight));
        }
        return flightDTOList;
    }

    @Override
    public FlightDTO addFlight(FlightDTO flightDTO) {
        Optional<Flight> flightOptional = flightRepo.findByFlightNumber(flightDTO.getNumber());

        Flight flight = FlightDTOAdapter.getFlight(flightDTO, airportRepo, airlineRepo);

        if (flightOptional.isPresent()) {
            throw new IllegalStateException("Flight Number already Existed!!!");
        }

        if (
                flight.getFlightStatus().equalsIgnoreCase(String.valueOf(FlightStatus.AVAILABLE)) ||
                flight.getFlightStatus().equalsIgnoreCase(String.valueOf(FlightStatus.DELAYED)) ||
                flight.getFlightStatus().equalsIgnoreCase(String.valueOf(FlightStatus.CANCELLED))
        ) {
            flightRepo.save(flight);
        } else {
            throw new IllegalStateException("Incorrect Flight Status!!!");
        }

        return flightDTO;
    }

    @Override
    public FlightDTO findByFlightNumber(Integer flightNumber) {
        Optional<Flight> flightOptional = flightRepo.findByFlightNumber(flightNumber);
        Flight flight = flightOptional.get();
        FlightDTO flightDTO = FlightDTOAdapter.getFlightDTO(flight);

        if (flightOptional.isPresent()) {
            return flightDTO;
        } else {
            throw new IllegalStateException("Flight Number does not exist!!!");
        }


    }

    @Override
    @Transactional
    public FlightDTO updateFlight(Integer flightNumber,
                                  int capacity,
                                  int airlineId,
                                  int departureAirportId,
                                  int arrivalAirportId,
                                  LocalDateTime departureTime,
                                  LocalDateTime arrivalTime,
                                  String flightStatus) {


        Optional<Flight> flightOptional = flightRepo.findByFlightNumber(flightNumber);

        Flight flight = flightOptional.get();
        FlightDTO flightDTO = FlightDTOAdapter.getFlightDTO(flight);


        if (flightOptional.isPresent()) {
            if (capacity > 0 && !Objects.equals(flightDTO.getCapacity(), capacity)) {
                flight.setCapacity(capacity);
            }

            if (airlineId > 0 && !Objects.equals(flightDTO.getAirlineId(), airlineId)) {
                flight.setAirline(airlineRepo.getById(airlineId));
            }

            if (departureAirportId > 0 && !Objects.equals(flightDTO.getDepartureAirportId(), departureAirportId)) {
                flight.setDepartureAirport(airportRepo.getById(departureAirportId));
            }

            if (arrivalAirportId > 0 && !Objects.equals(flightDTO.getArrivalAirportId(), arrivalAirportId)) {
                flight.setArrivalAirport(airportRepo.getById(arrivalAirportId));
            }

            if (departureTime != null && !Objects.equals(flightDTO.getDepartureTime(), departureTime)) {
                flight.setDepartureTime(departureTime);
            }

            if (arrivalTime != null && !Objects.equals(flightDTO.getArrivalTime(), arrivalTime)) {
                flight.setArrivalTime(arrivalTime);
            }

            if (flightStatus != null &&
                    (
                            flightStatus.equalsIgnoreCase(String.valueOf(FlightStatus.AVAILABLE)) ||
                                    flightStatus.equalsIgnoreCase(String.valueOf(FlightStatus.DELAYED)) ||
                                    flightStatus.equalsIgnoreCase(String.valueOf(FlightStatus.CANCELLED))
                    )
            ) {
                flight.setFlightStatus(flightStatus);
            } else {
                throw new IllegalStateException("Incorrect Flight Status!!!");
            }
        } else {
            throw new IllegalStateException("Flight Number does not exist!!!");
        }

        FlightDTO flightDTO2 = FlightDTOAdapter.getFlightDTO(flight);

        flightRepo.save(flight);
        return flightDTO2;
    }

    @Override
    public FlightDTO cancelFlight(Integer flightNumber, String flightStatus) {
        Optional<Flight> flightOptional = flightRepo.findByFlightNumber(flightNumber);

        Flight flight = flightOptional.get();

        if (flightOptional.isPresent()) {
            if (flightStatus != null &&
                    flightStatus.equalsIgnoreCase(String.valueOf(FlightStatus.CANCELLED))) {
                flight.setFlightStatus(flightStatus);
            } else {
                throw new IllegalStateException("Incorrect Flight Status!!!");
            }
        } else {
            throw new IllegalStateException("Flight Number does not exist!!!");
        }

        FlightDTO flightDTO = FlightDTOAdapter.getFlightDTO(flight);

        flightRepo.save(flight);
        return flightDTO;
    }

    @Override
    public List<FlightDTO> flightsInSpecificDate(LocalDate departureDate) {
        List<FlightDTO> flightDTOList = new ArrayList<>();

        LocalDateTime localDateTime = departureDate.atStartOfDay();
        LocalDateTime localDateTimePlus = departureDate.plusDays(1).atStartOfDay();

        for (Flight flight : flightRepo.findByDate(localDateTime, localDateTimePlus)) {
            flightDTOList.add(FlightDTOAdapter.getFlightDTO(flight));
        }

        if(flightDTOList.size() > 0)
            return flightDTOList;
        else {
            throw new IllegalStateException("There are no flights in the specific date!!!");
        }
    }


    private enum FlightStatus {
        CANCELLED, DELAYED, AVAILABLE
    }
}



