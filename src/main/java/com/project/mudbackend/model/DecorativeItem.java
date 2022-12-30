package com.project.mudbackend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "decorative_items")
public class DecorativeItem {
    
    @Id
    @GeneratedValue
    @Column(name = "decorative_item_id")
    Long id;

    @Column(name = "decorative_item_name")
    String name;

}
