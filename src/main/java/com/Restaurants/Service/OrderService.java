package com.Restaurants.Service;

import java.util.List;

import com.Restaurants.Model.FoodOrders;

public interface OrderService {

	FoodOrders SaveOrders(FoodOrders foodOrders);		

	List<FoodOrders> getFoodOrder(String restoName);	

	List<FoodOrders> RestoOrderHistory(String restoName);

	List<FoodOrders> currentOrder(String username);
	
	List<FoodOrders> getFoodHistory(String username);
	
	boolean OrderSent(long orderId);


}
