package com.example.airline_reservation.DAO;

import com.example.airline_reservation.Model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepo extends JpaRepository<Admin, Integer> {
}
