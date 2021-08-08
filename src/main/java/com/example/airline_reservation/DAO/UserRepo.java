package com.example.airline_reservation.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.airline_reservation.Model.User;

public interface UserRepo extends JpaRepository<User, Integer> {
}
