package com.Restaurants.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Restaurants.Model.FoodOrders;

public interface OrderRepository extends JpaRepository<FoodOrders, Long> {

	List<FoodOrders> findByUsername(String username);

	List<FoodOrders> findByRestoName(String restoName);

	FoodOrders findByOrderId(long orderId);

}
