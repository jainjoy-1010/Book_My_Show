package org.example.bookmyshow.services;

import org.example.bookmyshow.models.User;
import org.example.bookmyshow.repositories.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public User signup(String username, String email, String Password){
        Optional<User> optionalUser = userRepository.findByEmail(email);
        User savedUser = null;
        if(optionalUser.isPresent()){
            //login
        }else{
            User user = new User();
            user.setName(username);
            user.setEmail(email);
            user.setPassword(bCryptPasswordEncoder.encode(Password));
            savedUser = userRepository.save(user);

        }
        return savedUser;

    }
}
