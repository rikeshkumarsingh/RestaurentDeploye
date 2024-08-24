package com.Restaurants.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Restaurants.Model.FoodItem;

public interface FoodItemRepository extends JpaRepository<FoodItem, Long> {

}
