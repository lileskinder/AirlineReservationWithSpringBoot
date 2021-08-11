package com.example.airline_reservation.Service.Implementation;

import com.example.airline_reservation.DAO.AirlineRepo;
import com.example.airline_reservation.DAO.AirportRepo;
import com.example.airline_reservation.DAO.FlightRepo;
import com.example.airline_reservation.ExceptionHandling.MyCustomException;
import com.example.airline_reservation.Model.Flight;
import com.example.airline_reservation.Service.DTOs.DTOAdapters.FlightDTOAdapter;
import com.example.airline_reservation.Service.DTOs.FlightDTO;
import com.example.airline_reservation.Service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

    private FlightRepo flightRepo;
    private AirlineRepo airlineRepo;
    private AirportRepo airportRepo;

    @Autowired
    public FlightServiceImpl(FlightRepo flightRepo, AirlineRepo airlineRepo, AirportRepo airportRepo) {
        this.flightRepo = flightRepo;
        this.airlineRepo = airlineRepo;
        this.airportRepo = airportRepo;
    }

    public FlightServiceImpl() {
    }

    @Override
    public List<FlightDTO> findAll(Optional<Integer> page) {
        Pageable pagination = PageRequest.of(page.orElse(0), 10);
        List<FlightDTO> flightDTOList = new ArrayList<>();
        for (Flight flight : flightRepo.findAll(pagination)) {
            flightDTOList.add(FlightDTOAdapter.getFlightDTO(flight));
        }
        return flightDTOList;
    }

    @Override
    public FlightDTO addFlight(FlightDTO flightDTO) {
        Optional<Flight> flightOptional = flightRepo.findByFlightNumber(flightDTO.getNumber());

        Flight flight = FlightDTOAdapter.getFlight(flightDTO, airportRepo, airlineRepo);

        if (flightOptional.isPresent()) {
            throw new MyCustomException("Flight Number already Existed!!!");
        }

        if (
                flight.getFlightStatus().equalsIgnoreCase(String.valueOf(FlightStatus.AVAILABLE)) ||
                flight.getFlightStatus().equalsIgnoreCase(String.valueOf(FlightStatus.DELAYED)) ||
                flight.getFlightStatus().equalsIgnoreCase(String.valueOf(FlightStatus.CANCELLED))
        ) {
            flightRepo.save(flight);
        } else {
            throw new MyCustomException("Incorrect Flight Status!!!");
        }

        return flightDTO;
    }

    @Override
    public FlightDTO findByFlightId(Integer id) {
        return FlightDTOAdapter.getFlightDTO(flightRepo.getById(id));
    }

    @Override
    public FlightDTO findByFlightNumber(Integer flightNumber) {
        Optional<Flight> flightOptional = flightRepo.findByFlightNumber(flightNumber);
        FlightDTO flightDTO = FlightDTOAdapter.getFlightDTO(flightOptional.get());

        if (!flightOptional.isPresent()) {
            throw new MyCustomException("Flight Number does not exist!!!");
        } else {
            return flightDTO;
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
                throw new MyCustomException("Incorrect Flight Status!!!");
            }
        } else {
            throw new MyCustomException("Flight Number does not exist!!!");
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
                throw new MyCustomException("Incorrect Flight Status!!!");
            }
        } else {
            throw new MyCustomException("Flight Number does not exist!!!");
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
            throw new MyCustomException("There are no flights in the specified date!!!");
        }
    }

    @Override
    public List<FlightDTO> findFlightsFromAirport(Integer airportId) {
        List<FlightDTO> flightDTOList = new ArrayList<>();

        for (Flight flight : flightRepo.flightsFromAirport(airportId)) {
            flightDTOList.add(FlightDTOAdapter.getFlightDTO(flight));
        }

        if(flightDTOList.size() > 0)
            return flightDTOList;
        else {
            throw new MyCustomException("There are no flights in the specified Airport!!!");
        }
    }


    private enum FlightStatus {
        CANCELLED, DELAYED, AVAILABLE
    }
}



