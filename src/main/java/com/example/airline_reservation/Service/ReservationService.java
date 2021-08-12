package com.example.airline_reservation.Service;

import com.example.airline_reservation.Service.DTOs.ReservationDTO;
import com.example.airline_reservation.Service.DTOs.TicketDTO;

import java.util.List;
import java.util.Optional;

public interface ReservationService {
    public List<TicketDTO> getReservationTicketsAvailability(ReservationDTO reservationDTO);
    public List<TicketDTO> getReservationTickets(ReservationDTO reservationDTO);
    public ReservationDTO makeReservation(ReservationDTO reservationDTO);
    public ReservationDTO updateReservation(String code, ReservationDTO reservationDTO);
    public List<ReservationDTO> getReservations(Optional<Integer> page);
    public ReservationDTO getReservationByCode(String code);
    public List<ReservationDTO> getPersonReservations(Optional<Integer> page, String username);
    public ReservationDTO confirmReservation(String code, ReservationDTO reservationDTO);
    public ReservationDTO cancelReservation(String code, ReservationDTO reservationDTO);
}
