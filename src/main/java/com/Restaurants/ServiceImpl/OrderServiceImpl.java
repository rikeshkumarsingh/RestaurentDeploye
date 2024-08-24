package com.Restaurants.ServiceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Restaurants.Model.FoodOrders;
import com.Restaurants.Repository.OrderRepository;
import com.Restaurants.Service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderRepository orderRepository;

	private static final Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);

	@Override
	@Transactional
	public FoodOrders SaveOrders(FoodOrders foodOrders) {
		FoodOrders savedFoodOrders = orderRepository.save(foodOrders);
		return savedFoodOrders;
	}

	@Override
	public List<FoodOrders> getFoodOrder(String restoName) {
		List<FoodOrders> findByRestoName = this.orderRepository.findByRestoName(restoName);
		List<FoodOrders> filteredOrders = findByRestoName.stream().filter(order -> !order.isOrderStatus())
				.collect(Collectors.toList());

		return filteredOrders;
	}

	@Override
	public List<FoodOrders> RestoOrderHistory(String restoName) {
		List<FoodOrders> findByRestoName = this.orderRepository.findByRestoName(restoName);
		List<FoodOrders> filteredOrders = findByRestoName.stream().filter(order -> order.isOrderStatus())
				.collect(Collectors.toList());

		return filteredOrders;
	}

	@Override
	public List<FoodOrders> getFoodHistory(String username) {
		List<FoodOrders> findByUsername = this.orderRepository.findByUsername(username);
		List<FoodOrders> collect = findByUsername.stream().filter(order -> order.isOrderStatus())
				.collect(Collectors.toList());
		return collect;
	}

	@Override
	public List<FoodOrders> currentOrder(String username) {
		List<FoodOrders> findByUsername = this.orderRepository.findByUsername(username);
		List<FoodOrders> collect = findByUsername.stream().filter(order -> !order.isOrderStatus())
				.collect(Collectors.toList());
		return collect;
	}

	@Override
	public boolean OrderSent(long orderId) {

		try {
			FoodOrders findByOrderId = this.orderRepository.findByOrderId(orderId);
			if (findByOrderId != null) {
				findByOrderId.setOrderStatus(true);
				this.orderRepository.save(findByOrderId);
				return true;
			} else {

				return false;
			}
		} catch (Exception e) {

			logger.error("Error occurred while confirming the order", e);

			return false;
		}
	}

}
