package org.example.bookmyshow.controllers;

import org.example.bookmyshow.dtos.ResponseStatus;
import org.example.bookmyshow.dtos.SignupRequestDTO;
import org.example.bookmyshow.dtos.SignupResponseDTO;
import org.example.bookmyshow.models.User;
import org.example.bookmyshow.services.UserService;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public SignupResponseDTO signup(SignupRequestDTO signupRequestDTO){
        SignupResponseDTO signupResponseDTO = new SignupResponseDTO();

        try{
            User user = userService.signup(signupRequestDTO.getName(),
                    signupRequestDTO.getEmail(),
                    signupRequestDTO.getPassword());
            signupResponseDTO.setUser(user);
            signupResponseDTO.setResponseStatus(ResponseStatus.SUCCESS);
        }catch(Exception e){
            signupResponseDTO.setResponseStatus(ResponseStatus.FAILED);
        }
        return signupResponseDTO;
    }
}
