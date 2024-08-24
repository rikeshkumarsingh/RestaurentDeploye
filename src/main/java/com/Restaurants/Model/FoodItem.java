package com.Restaurants.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class FoodItem {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long foodId;
    private String food;
    private long price;

    @ManyToOne
    @JoinColumn(name = "order_id")
    @JsonBackReference
    private FoodOrders foodOrder;
}
