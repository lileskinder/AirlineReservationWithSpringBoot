package com.example.airline_reservation.Service;

import com.example.airline_reservation.Model.Reservation;
import com.example.airline_reservation.Model.ReservationStatus;
import com.example.airline_reservation.Service.DTOs.DTOAdapters.ReservationDTOAdapter;
import com.example.airline_reservation.Service.DTOs.ReservationDTO;

import java.util.List;
import java.util.Optional;

public interface ReservationService {
    public ReservationDTO makeReservation(ReservationDTO reservationDTO);
    public ReservationDTO updateReservation(String code, ReservationDTO reservationDTO);
    public List<ReservationDTO> getReservations(Optional<Integer> page);
    public ReservationDTO getReservationByCode(String code);
    public ReservationDTO confirmReservation(String code, ReservationDTO reservationDTO);
    public ReservationDTO cancelReservation(String code, ReservationDTO reservationDTO);
}
