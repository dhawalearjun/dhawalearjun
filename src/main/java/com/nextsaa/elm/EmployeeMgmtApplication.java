package com.nextsaa.elm;

import com.nextsaa.elm.entity.Employee;
import com.nextsaa.elm.repository.EmployeeRepository;
import com.nextsaa.elm.util.enums.EmployeeStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class EmployeeMgmtApplication implements CommandLineRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeMgmtApplication.class);

    @Value("${app.security.initial.admin-username:admin}")
    private String initialAdminUsername;

    @Value("${app.security.initial.admin-pass:admin}")
    private String initialAdminPass;

    @Autowired private PasswordEncoder passwordEncoder;
    @Autowired private EmployeeRepository employeeRepository;

    public static void main(String[] args) {
        SpringApplication.run(EmployeeMgmtApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Employee admin = employeeRepository.findByUsername(initialAdminUsername);
        if(admin == null){
            LOGGER.warn("Initial Admin-User Not Found, initializing default admin with username: ", initialAdminUsername);
            String initialAdminPassword = passwordEncoder.encode(initialAdminPass);
            Employee defaultAdmin = new Employee();
            defaultAdmin.setUsername(initialAdminUsername);
            defaultAdmin.setFirstName(initialAdminUsername);
            defaultAdmin.setLastName(initialAdminUsername);
            defaultAdmin.setPhoneNumber("000000000");
            defaultAdmin.setPassword(initialAdminPassword);
            defaultAdmin.setRole("ROLE_ADMIN");
            defaultAdmin.setStatus(EmployeeStatus.ACTIVE);
            defaultAdmin.setCreatedBy(initialAdminUsername);
            defaultAdmin.setModifiedBy(initialAdminUsername); 
            employeeRepository.save(defaultAdmin);
            LOGGER.info("Default Admin-User Initialization Successful");
        }
    }

}
