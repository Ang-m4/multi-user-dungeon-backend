package com.project.mudbackend.services;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.mudbackend.data.UserDTO;
import com.project.mudbackend.database.UserRepository;
import com.project.mudbackend.model.User;

@Service
public class UserService {
    
    @Autowired 
    UserRepository userRepository;

    public List<User> getAllUsers(int offset, int limit, String sortField){
        return userRepository.findAll(offset, limit, sortField);
    }

    public User getById(Long id){
        Optional<User> user = userRepository.findById(id);
        if(user.isEmpty()){
            //TODO throw exception user not found
            return null;
        }
        return user.get();
    }

    public User register(UserDTO userDTO){
        Optional<User> user = userRepository.findByName(userDTO.getNickname());
        if(user.isPresent()){
            //TODO throw an exception if nickname unavaliable
            return null;
        }
        User newUser = User
            .builder()
            .nickname(userDTO.getNickname())
            .password(BCrypt.hashpw(userDTO.getPassword(), BCrypt.gensalt()))
            .character(null)
            .role(userDTO.getRole())
            .build();
        return userRepository.save(newUser);
    }

    public User updateUser(UserDTO userDTO){
        Optional<User> user = userRepository.findById(userDTO.getId());
        if(user.isEmpty()){
            //TODO throw an exception if user does not exist
            return null;
        }
        User uUser = User
            .builder()
            .id(userDTO.getId())
            .nickname(userDTO.getNickname())
            .password(BCrypt.hashpw(userDTO.getPassword(), BCrypt.gensalt()))
            .character(user.get().getCharacter())
            .role(userDTO.getRole())
            .build();
        return userRepository.save(uUser);
    }

    public void deleteUser(Long id){
        Optional<User> user = userRepository.findById(id);
        if(user.isEmpty()){
            //TODO throw an exception if user does not exist
        }
        userRepository.delete(user.get());
    }
}   
