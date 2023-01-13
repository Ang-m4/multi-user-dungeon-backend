package com.project.mudbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.mudbackend.data.MessageDTO;
import com.project.mudbackend.data.UserDTO;
import com.project.mudbackend.model.User;
import com.project.mudbackend.services.UserService;

@RestController
@RequestMapping("/mud-api/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/all")
    ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers(0, 10, "user_nickname"));
    }

    @GetMapping("/")
    ResponseEntity<User> getUser(@RequestParam(required = true) long id) {
        User user = userService.getById(id);
        return ResponseEntity.ok().body(user);
    }

    @PostMapping("/save")
    ResponseEntity<User> register(@RequestBody UserDTO userDTO) {
        User savedUser = userService.register(userDTO);
        return ResponseEntity.ok(savedUser);
    }

    @DeleteMapping("/")
    ResponseEntity<MessageDTO> deleteUser(@RequestParam(required = true) long id) {
        userService.deleteUser(id);
        MessageDTO message = MessageDTO
                .builder()
                .message("User with id: " + id + " deleted succesfully")
                .statusCode(200)
                .build();
        return ResponseEntity.ok().body(message);
    }

    @PutMapping("/")
    ResponseEntity<User> updateUser(@RequestBody(required = true) UserDTO userDTO) {
        User user = userService.updateUser(userDTO);
        return ResponseEntity.ok().body(user);
    }

}
