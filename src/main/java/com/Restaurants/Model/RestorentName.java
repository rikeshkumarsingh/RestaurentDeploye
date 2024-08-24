package com.Restaurants.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;


@Entity
@Data
public class RestorentName {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long rest_id;
    private String restaurentUsername;  
    private String restaurentName;
    private String dishName;   
    private long price;

    
}
