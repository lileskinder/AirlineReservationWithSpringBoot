package com.example.airline_reservation.security;

import com.example.airline_reservation.DAO.PersonRepo;
import com.example.airline_reservation.DAO.RoleRepo;
import com.example.airline_reservation.ExceptionHandling.ResourceNotFoundException;
import com.example.airline_reservation.Model.Person;
import com.example.airline_reservation.Model.Role;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

@Service
@Slf4j
public class ApplicationUserDetailsService implements UserDetailsService {

    private final RoleRepo roleRepository;
    private final PersonRepo personRepository;

    @Autowired
    public ApplicationUserDetailsService(RoleRepo roleRepository, PersonRepo personRepository) {
        this.roleRepository = roleRepository;
        this.personRepository = personRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Person person = personRepository.getPersonByUserName(username)
                .orElseThrow(() -> new ResourceNotFoundException("Person not Found"));

        List<Role> roles = roleRepository.getRoleByPersonId(person.getId());
                //  .orElseThrow(() -> new ResourceNotFoundException("Role not Found"));
        Role role;// = new Role();
        if(roles.size() > 0)
            role = roles.get(0);
        else
            throw  new ResourceNotFoundException("Role not Found");

        log.info("Person: {}", person);
        log.info("role: {}", role);

        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getRole().toUpperCase()));

        log.info("Authorities {}", authorities);

        return new ApplicationUserDetails(
                person.getUserName(),
                role.getPassword(),
                authorities,
                true,
                true,
                true,
                true
        );
    }
}
