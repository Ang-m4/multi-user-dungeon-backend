package com.project.mudbackend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.mudbackend.data.ItemDTO;
import com.project.mudbackend.database.ItemRepository;
import com.project.mudbackend.model.Item;

@Service
public class ItemService {
    
    @Autowired
    ItemRepository itemRepository;

    public List<Item> getAllItems(int offset, int limit){
        return (List<Item>) itemRepository.findAll(offset, limit);
    }

    public Item getById(Long Id){
        Optional<Item> item = itemRepository.findById(Id);
        if(item.isEmpty()){
            //TODO throw exception if item does not exist
        }
        return item.get();
    }

    public Item createItem(ItemDTO itemDTO){
        Optional<Item> item = itemRepository.findByName(itemDTO.getName());
        if(item.isPresent()){
            //TODO throw exception item already exist
        }
        Item newItem = Item
            .builder()
            .name(itemDTO.getName())
            .lastUpdated(itemDTO.getLastUpdated())
            .cost(itemDTO.getCost())
            .weight(itemDTO.getWeight())
            .examine(itemDTO.getExamine())
            .url(itemDTO.getUrl())
            .build();
        return itemRepository.save(newItem);
    }

    public Item updateItem(ItemDTO itemDTO){
        Optional<Item> item = itemRepository.findById(itemDTO.getId());
        if(item.isEmpty()){
            //TODO throw exception if item does not exist
        }
        Item uItem = Item
            .builder()
            .name(itemDTO.getName())
            .lastUpdated(itemDTO.getLastUpdated())
            .cost(itemDTO.getCost())
            .weight(itemDTO.getWeight())
            .examine(itemDTO.getExamine())
            .url(itemDTO.getUrl())
            .build();
        return itemRepository.save(uItem);
    }

    public void deleteById(Long id){
        Optional<Item> item = itemRepository.findById(id);
        if(item.isEmpty()){
            //TODO throw exception item does not exist
        }
        itemRepository.delete(item.get());
    }

}
