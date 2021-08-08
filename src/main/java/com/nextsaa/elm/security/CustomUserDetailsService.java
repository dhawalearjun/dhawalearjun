package com.nextsaa.elm.security;

import com.nextsaa.elm.util.enums.EmployeeStatus;
import com.nextsaa.elm.EmployeeMgmtApplication;
import com.nextsaa.elm.entity.Employee;
import com.nextsaa.elm.repository.EmployeeRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service("userService")
public class CustomUserDetailsService implements UserDetailsService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CustomUserDetailsService.class);

    @Autowired
    private EmployeeRepository employeeRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	LOGGER.info("User name is :" +username ); 
    	
        Employee employee = employeeRepository.findByUsernameAndStatus(username, EmployeeStatus.ACTIVE);
        if (employee == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        Collection<GrantedAuthority> grantedAuthorities = AuthorityUtils
                .commaSeparatedStringToAuthorityList(employee.getRole());

        return new JwtUserDetails(employee.getUsername(), employee.getPassword(), employee.getEmployeeId(), grantedAuthorities);
    }

}