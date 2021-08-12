package com.example.airline_reservation.Service.Implementation;

import com.example.airline_reservation.DAO.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.airline_reservation.Model.Role;
import com.example.airline_reservation.Service.RoleService;
import com.example.airline_reservation.Service.DTOs.RoleDTO;
import com.example.airline_reservation.Service.DTOs.DTOAdapters.RoleDTOAdapter;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    private final RoleRepo repo;

//    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public RoleServiceImpl(RoleRepo repo) {
        this.repo = repo;
    }

//    @Autowired
//    public RoleServiceImpl(RoleRepo repo, BCryptPasswordEncoder bCryptPasswordEncoder) {
//        this.repo = repo;
//        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
//    }

    @Override
    public RoleDTO addRole(RoleDTO roleDTO) {
//        roleDTO.setPassword(bCryptPasswordEncoder.encode(roleDTO.getPassword()));
        Role role = RoleDTOAdapter.getRole(roleDTO);
        return RoleDTOAdapter.getRoleDTO(repo.save(role));
    }

    @Override
    public RoleDTO updateRole(RoleDTO roleDTO) {
        Role role = RoleDTOAdapter.getRole(roleDTO);
        return RoleDTOAdapter.getRoleDTO(repo.save(role));
    }

    @Override
    public void deleteRole(int roleId) {
        if (!repo.existsById(roleId)) {
            throw new IllegalStateException("Role with id " + roleId + " does not exists");
        }
        repo.deleteById(roleId);
    }

    @Override
    public List<RoleDTO> getRoles() {
        List<Role> roles = repo.findAll();
        List<RoleDTO> roleDTOList = new ArrayList<>();

        for (Role role : roles) {
            roleDTOList.add(RoleDTOAdapter.getRoleDTO(role));
        }

        return roleDTOList;
    }

    @Override
    public RoleDTO getRoleById(int roleId) {
        Role role = repo.findById(roleId)
                .orElseThrow(() -> new IllegalStateException("Role with id " + roleId + " does not exists"));
        return RoleDTOAdapter.getRoleDTO(role);
    }

}
