package com.example.airline_reservation.DAO;

import java.util.List;

import com.example.airline_reservation.Model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepo extends JpaRepository<Role, Integer> {

    @Query("select r from Role r where r.userName = :userName and r.role = :roleName")
    Role findByRoleUserName(@Param("userName") String userName, @Param("roleName") String roleName);

    @Query("select r from Role r where r.userName = :userName")
    List<Role> findByUserName(@Param("userName") String userName);

}
