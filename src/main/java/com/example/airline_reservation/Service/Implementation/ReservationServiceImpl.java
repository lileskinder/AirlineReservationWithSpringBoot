package com.example.airline_reservation.Service.Implementation;

import com.example.airline_reservation.DAO.FlightRepo;
import com.example.airline_reservation.DAO.PersonRepo;
import com.example.airline_reservation.DAO.ReservationRepo;
import com.example.airline_reservation.ExceptionHandling.ResourceNotFoundException;
import com.example.airline_reservation.Model.Reservation;
import com.example.airline_reservation.Model.ReservationStatus;
import com.example.airline_reservation.Service.DTOs.DTOAdapters.ReservationDTOAdapter;
import com.example.airline_reservation.Service.DTOs.ReservationDTO;
import com.example.airline_reservation.Service.PassengerService;
import com.example.airline_reservation.Service.ReservationService;
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
public class ReservationServiceImpl implements ReservationService {

    private ReservationRepo reservationRepo;
    private PersonRepo personRepo;
    private PassengerService passengerService;
    private FlightRepo flightRepo;

    @Autowired
    public ReservationServiceImpl(ReservationRepo reservationRepo,
                                  PersonRepo personRepo,
                                  PassengerService passengerService,
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

    public List<ReservationDTO> getReservations(Optional<Integer> page) {
        Pageable pagination = PageRequest.of(page.orElse(0), 10);

        List<ReservationDTO> reservationDTOList = new ArrayList<>();

        for (Reservation reservation : reservationRepo.findAll(pagination)) {
            reservationDTOList.add(ReservationDTOAdapter.getReservationDTO(reservation));
        }

        return reservationDTOList;
    }

//    @Override
//    public ReservationDTO getReservationByCode(String code, String username) {
//        Reservation reservation = reservationRepo.findOwnReservation(code, username)
//                .orElseThrow(() -> new ResourceNotFoundException("Reservation not Found with code " + code));
//        return ReservationDTOAdapter.getReservationDTO(reservation);
//    }

    @Override
    public List<ReservationDTO> getPersonReservations(Optional<Integer> page, String username) {
        List<ReservationDTO> reservationDTOList = new ArrayList<>();

        for (Reservation reservation : reservationRepo.findOwnReservation(username)) {
            reservationDTOList.add(ReservationDTOAdapter.getReservationDTO(reservation));
        }

        return reservationDTOList;
    }

    @Override
    public ReservationDTO getReservationByCode(String code) {
        Reservation reservation = reservationRepo.findByCode(code)
                .orElseThrow(() -> new ResourceNotFoundException("Reservation not Found with code " + code));
        return ReservationDTOAdapter.getReservationDTO(reservation);
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
