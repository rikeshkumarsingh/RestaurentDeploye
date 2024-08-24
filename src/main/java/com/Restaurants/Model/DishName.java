package com.Restaurants.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class DishName {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long dishId;

    private String dishName;

    private long price;

    @ManyToOne
    @JoinColumn(name = "rest_id", referencedColumnName = "rest_id")
    private RestorentName restaurant;

    
}
