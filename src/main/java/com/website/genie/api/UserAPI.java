package com.website.genie.api;

import com.website.genie.convert.ConvertUtil;
import com.website.genie.dto.ResponseObject;
import com.website.genie.dto.UserDTO;
import com.website.genie.entities.UserEntity;
import com.website.genie.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api")
public class UserAPI {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ConvertUtil converter;


    @PostMapping("/login")
    public ResponseEntity<ResponseObject> login(@RequestBody Map<String, String> loginData) {
        String username = loginData.get("email");
        String password = loginData.get("password");

        System.out.println(username);
        System.out.println(password);

        // Validate username and password (You might want to use proper authentication)
        UserEntity user = userRepository.findByUsername(username);
        if(user != null) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("ok", "Login Successfuly", converter.toDTO(user)));
            }
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ResponseObject("unauthorized", "Login Failed!", ""));
    }

    @PostMapping("/register")
    public ResponseEntity<ResponseObject> signUp(@RequestBody Map<String, String> signUpData) {
        String firstName = signUpData.get("firstName");
        String lastName = signUpData.get("lastName");
        String userName = signUpData.get("userName");
        String email = signUpData.get("email");
        String password = signUpData.get("password");
        // You may want to add validation and other necessary processing here
        UserEntity existingUser = userRepository.findByUsername(email);

        if(existingUser != null) {
            // User already exists, return user information
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseObject("ok", "user already exists", ""));
        } else {
            // Create a new user
            UserEntity newUser = new UserEntity();
            newUser.setFullname(firstName + " " + lastName);
            newUser.setUsername(userName);
            newUser.setEmail(email);
            newUser.setPassword(password);
            userRepository.save(newUser);

            // Return a success message with the created user information
            return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseObject("ok", "register success", converter.toDTO(newUser)));
        }
    }
}
