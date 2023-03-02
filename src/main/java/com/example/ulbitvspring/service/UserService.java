package com.example.ulbitvspring.service;

import com.example.ulbitvspring.entity.UserEntity;
import com.example.ulbitvspring.exception.UserAlredyExistException;
import com.example.ulbitvspring.exception.UserNotFoundException;
import com.example.ulbitvspring.model.User;
import com.example.ulbitvspring.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    public UserEntity registration(UserEntity user) throws UserAlredyExistException {
        if (userRepo.findByUsername(user.getUsername()) != null){
            throw  new UserAlredyExistException("Username already exists");
            //return ResponseEntity.badRequest().body("Username already exists");
        }

        return  userRepo.save(user); //ResponseEntity.ok("User saved successfully");
    }

    public User getOne(Long id) throws UserNotFoundException {
        UserEntity user = userRepo.findById(id).get();
        if(user == null) {
            throw new UserNotFoundException("User not found");
        }
        return User.toModel(user);
    }

    public Long deleteUser(Long id) {
        userRepo.deleteById(id);
        return id;
    }


}
