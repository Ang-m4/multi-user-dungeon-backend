package com.project.mudbackend.model;

import java.time.LocalDate;

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
@Entity(name = "items")
public class Item {

    @Id
    @GeneratedValue
    @Column(name = "item_id")
    Long id;

    @Column(name = "item_name")
    String name;

    @Column(name = "item_last_updated")
    LocalDate lastUpdated;

    @Column(name = "item_cost")
    Integer cost;

    @Column(name = "item_weight")
    Float weight;

    @Column(name = "item_examine")
    String examine;

    @Column(name = "item_url")
    String url;

}
