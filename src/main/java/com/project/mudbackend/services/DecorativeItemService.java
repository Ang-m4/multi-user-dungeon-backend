package com.project.mudbackend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.mudbackend.data.DecorativeItemDTO;
import com.project.mudbackend.database.DecorativeItemRepository;
import com.project.mudbackend.model.DecorativeItem;

@Service
public class DecorativeItemService {
    
    @Autowired
    DecorativeItemRepository decorativeItemRepository;

    public List<DecorativeItem> getAllItems(int offset,int limit){
        return (List<DecorativeItem>) decorativeItemRepository.findAll(offset,limit);
    }

    public DecorativeItem findById(Long id){
        Optional<DecorativeItem> decorativeItem = decorativeItemRepository.findById(id);
        if(decorativeItem.isEmpty()){
            //TODO throw exception if item does not exist
            return null;
        }
        return decorativeItem.get();
    }
    
    public DecorativeItem updateDecorativeItem(DecorativeItemDTO decorativeItemDTO){
        Optional<DecorativeItem> decoItem = decorativeItemRepository.findById(decorativeItemDTO.getId());
        if(decoItem.isEmpty()){
            //TODO throw exception if item does not exist
            return null;
        }
        DecorativeItem newDecorativeItem = DecorativeItem
            .builder()
            .id(decorativeItemDTO.getId())
            .name(decorativeItemDTO.getName())
            .build();
        decorativeItemRepository.save(newDecorativeItem);
        return decoItem.get();
    }

    public DecorativeItem createDecorativeItem(DecorativeItemDTO decorativeItemDTO){
        Optional<DecorativeItem> decorative = decorativeItemRepository.findByName(decorativeItemDTO.getName());
        if(decorative.isPresent()){
            //TODO throw and exception if the item already exist
        }
        DecorativeItem newDecorativeItem = DecorativeItem
            .builder()
            .name(decorativeItemDTO.getName())
            .build();
        decorativeItemRepository.save(newDecorativeItem);
        return newDecorativeItem;
    }

    public void deleteById(Long id){
        Optional<DecorativeItem> decorative = decorativeItemRepository.findById(id);
        if(decorative.isEmpty()){
            //TODO throw exception if decorative does not exist
        }
        decorativeItemRepository.delete(decorative.get());
    }
    
}
