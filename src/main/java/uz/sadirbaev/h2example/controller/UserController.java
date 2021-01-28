package uz.sadirbaev.h2example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import uz.sadirbaev.h2example.entity.UserEntity;
import uz.sadirbaev.h2example.model.JwtRequest;
import uz.sadirbaev.h2example.model.JwtResponse;
import uz.sadirbaev.h2example.repository.UserRepository;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ResponseEntity<?> getAllUsers() throws Exception {

        List<UserEntity> userEntityList = userRepository.findAll();
        return ResponseEntity.ok(userEntityList);
    }
}
