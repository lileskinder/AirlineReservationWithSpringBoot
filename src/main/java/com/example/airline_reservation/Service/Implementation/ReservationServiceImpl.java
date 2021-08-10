package com.example.airline_reservation.Service.Implementation;

import com.example.airline_reservation.DAO.FlightRepo;
import com.example.airline_reservation.DAO.PersonRepo;
import com.example.airline_reservation.DAO.ReservationRepo;
import com.example.airline_reservation.Model.Person;
import com.example.airline_reservation.Model.Reservation;
import com.example.airline_reservation.Model.ReservationStatus;
import com.example.airline_reservation.Service.DTOs.DTOAdapters.ReservationDTOAdapter;
import com.example.airline_reservation.Service.DTOs.ReservationDTO;
import com.example.airline_reservation.Service.PassengerService;
import com.example.airline_reservation.Service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationServiceImpl implements ReservationService {

    private ReservationRepo reservationRepo;
    private PersonRepo personRepo;
    private PassengerServiceImpl passengerService;
    private FlightRepo flightRepo;

    @Autowired
    public ReservationServiceImpl(ReservationRepo reservationRepo,
                                  PersonRepo personRepo,
                                  PassengerServiceImpl passengerService,
                                  FlightRepo flightRepo) {

        this.reservationRepo = reservationRepo;
        this.personRepo = personRepo;
        this.passengerService = passengerService;
        this.flightRepo = flightRepo;
    }

    public ReservationDTO makeReservation(ReservationDTO reservationDTO) {
        return ReservationDTOAdapter.getReservationDTO(
                reservationRepo.save(
                        ReservationDTOAdapter.getReservation(
                                reservationDTO,
                                personRepo,
                                passengerService,
                                flightRepo
                        )
                )
        );
    }

    public ReservationDTO updateReservation(String code, ReservationDTO reservationDTO) {

        reservationDTO.setCode(code);
        return ReservationDTOAdapter.getReservationDTO(
                reservationRepo.save(
                        ReservationDTOAdapter.getReservation(
                                reservationDTO,
                                personRepo,
                                passengerService,
                                flightRepo
                        )
                )
        );
    }

    public List<ReservationDTO> getReservations() {
        List<ReservationDTO> reservationDTOList = new ArrayList<>();
        for(Reservation reservation: reservationRepo.findAll()) {
            reservationDTOList.add(ReservationDTOAdapter.getReservationDTO(reservation));
        }
        return reservationDTOList;
    }

    public ReservationDTO getReservationByCode(String code) {
        Optional<Reservation> reservationOptional = reservationRepo.findByCode(code);
        Reservation reservation = reservationOptional.get();
        ReservationDTO flightDTO = ReservationDTOAdapter.getReservationDTO(reservation);

        if (reservationOptional.isPresent()) {
            return flightDTO;
        } else {
            throw new IllegalStateException("Invalid reservation code!!!");
        }
    }

    public ReservationDTO confirmReservation(String code, ReservationDTO reservationDTO) {
        reservationDTO.setCode(code);
        reservationDTO.setStatus(ReservationStatus.PAID);

        return ReservationDTOAdapter.getReservationDTO(
                reservationRepo.save(
                        ReservationDTOAdapter.getReservation(
                                reservationDTO, personRepo,
                                passengerService,
                                flightRepo
                        )
                )
        );
    }

    public ReservationDTO cancelReservation(String code, ReservationDTO reservationDTO) {
        reservationDTO.setCode(code);
        reservationDTO.setStatus(ReservationStatus.CANCELED);

        return ReservationDTOAdapter.getReservationDTO(
                reservationRepo.save(
                        ReservationDTOAdapter.getReservation(
                                reservationDTO, personRepo,
                                passengerService,
                                flightRepo
                        )
                )
        );
    }
}
