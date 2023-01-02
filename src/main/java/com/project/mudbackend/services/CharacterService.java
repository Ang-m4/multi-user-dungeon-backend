package com.project.mudbackend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.mudbackend.data.CharacterDTO;
import com.project.mudbackend.database.CharacterRepository;
import com.project.mudbackend.database.UserRepository;
import com.project.mudbackend.model.Character;
import com.project.mudbackend.model.User;

@Service
public class CharacterService {
    
    @Autowired
    CharacterRepository characterRepository;

    @Autowired
    UserRepository userRepository;

    public List<Character> getAllCharacters(){
        return (List<Character>) characterRepository.findAll();
    }

    public Character getByUserId(Long userId){
        Optional<Character> character = characterRepository.getByUserId(userId);
        if(character.isEmpty()){
            //TODO throw exception if character does not exist
            return null;
        }
        return character.get();
    }

    public Character getById(Long id){
        Optional<Character> character = characterRepository.findById(id);
        if(character.isEmpty()){
            //TODO throw exception if character does not exist
            return null;
        }
        return character.get();
    }

    public Character createCharacter(Long userId, CharacterDTO characterDTO){
        Optional<User> user = userRepository.findById(userId);
        if(user.isEmpty()){
            //TODO throw exception if user does not exist
        }
        Character newCharacter = Character
            .builder()
            .name(characterDTO.getName())
            .lastUpdate(characterDTO.getLastUpdate())
            .attackLevel(characterDTO.getAttackLevel())
            .defenceSlash(characterDTO.getDefenceSlash())
            .size(characterDTO.getSize())
            .hitpoints(characterDTO.getHitpoints())
            .category(characterDTO.getCategory())
            .examine(characterDTO.getExamine())
            .weight(characterDTO.getWeight())
            .build();
        user.get().setCharacter(newCharacter);
        userRepository.save(user.get());
        return newCharacter;
    }

    public Character updateCharacter(CharacterDTO characterDTO){
        Optional<Character> uCharacter = characterRepository.findById(characterDTO.getId());
        if(uCharacter.isEmpty()){
            //TODO throw exception if character does not exist
        }
        Character newCharacter = Character
            .builder()
            .id(characterDTO.getId())
            .name(characterDTO.getName())
            .lastUpdate(characterDTO.getLastUpdate())
            .attackLevel(characterDTO.getAttackLevel())
            .defenceSlash(characterDTO.getDefenceSlash())
            .size(characterDTO.getSize())
            .hitpoints(characterDTO.getHitpoints())
            .category(characterDTO.getCategory())
            .examine(characterDTO.getExamine())
            .weight(characterDTO.getWeight())
            .build();  
        return characterRepository.save(newCharacter);
    }

    public void deleteById(Long id){
        Optional<Character> character = characterRepository.findById(id);
        if(character.isEmpty()){
            //TODO throw exception if character does not exist
        }
        characterRepository.delete(character.get());
    }

}
