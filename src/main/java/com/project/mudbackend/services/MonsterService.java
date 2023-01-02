package com.project.mudbackend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.mudbackend.data.MonsterDTO;
import com.project.mudbackend.database.MonsterRepository;
import com.project.mudbackend.model.Monster;

@Service
public class MonsterService {
    
    @Autowired
    MonsterRepository monsterRepository;

    public List<Monster> getAllMonsters(int offset, int limit){
        return (List<Monster>) monsterRepository.findAll(offset, limit);
    }

    public Monster getById(Long id){
        Optional<Monster> monster = monsterRepository.findById(id);
        if(monster.isEmpty()){
            //TODO throw exception if monster does not exist
            return null;
        }
        return monster.get();  
    }

    public Monster createMonster(MonsterDTO monsterDTO){
        Optional<Monster> monster = monsterRepository.findByName(monsterDTO.getName());
        if(monster.isPresent()){
            //TODO throw and exception if mosnster already exist
            return null;
        }
        Monster newMonster = Monster
            .builder()
            .name(monsterDTO.getName())
            .lastUpdate(monsterDTO.getLastUpdate())
            .attackLevel(monsterDTO.getAttackLevel())
            .defenceSlash(monsterDTO.getDefenceSlash())
            .size(monsterDTO.getSize())
            .hitpoints(monsterDTO.getHitpoints())
            .category(monsterDTO.getCategory())
            .examine(monsterDTO.getExamine())
            .wikiURL(monsterDTO.getWikiURL())
            .build();
        return monsterRepository.saveAndFlush(newMonster);
    }

    public Monster updateMonster(MonsterDTO monsterDTO){
        Optional<Monster> monster = monsterRepository.findByName(monsterDTO.getName());
        if(monster.isPresent()){
            //TODO throw and exception if mosnster already exist
            return null;
        }
        Monster newMonster = Monster
            .builder()
            .id(monsterDTO.getId())
            .name(monsterDTO.getName())
            .lastUpdate(monsterDTO.getLastUpdate())
            .attackLevel(monsterDTO.getAttackLevel())
            .defenceSlash(monsterDTO.getDefenceSlash())
            .size(monsterDTO.getSize())
            .hitpoints(monsterDTO.getHitpoints())
            .category(monsterDTO.getCategory())
            .examine(monsterDTO.getExamine())
            .wikiURL(monsterDTO.getWikiURL())
            .build();
        return monsterRepository.saveAndFlush(newMonster);
    }

    public void deleteMonster(Long id){
        Optional<Monster> monster = monsterRepository.findById(id);
        if(monster.isEmpty()){
            //TODO throw an exception if monster does not exist
        }
        monsterRepository.delete(monster.get());
    }

}
