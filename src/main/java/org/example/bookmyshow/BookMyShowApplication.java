package org.example.bookmyshow;

import org.example.bookmyshow.controllers.UserController;
import org.example.bookmyshow.dtos.SignupRequestDTO;
import org.example.bookmyshow.dtos.SignupResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing  // automatic date and time created in base model also
public class BookMyShowApplication implements CommandLineRunner {   // to run cmdline

    @Autowired
    private UserController userController;

    public static void main(String[] args) {
        SpringApplication.run(BookMyShowApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        SignupRequestDTO signupRequestDTO = new SignupRequestDTO();
        signupRequestDTO.setName("jain");
        signupRequestDTO.setEmail("jain@123");
        signupRequestDTO.setPassword("jainpassword");

        SignupResponseDTO signupResponseDTO =  userController.signup(signupRequestDTO);

    }
}

