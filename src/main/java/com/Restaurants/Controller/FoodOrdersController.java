package com.Restaurants.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Restaurants.Model.FoodOrders;
import com.Restaurants.Service.OrderService;

@RestController
@RequestMapping("/order")
public class FoodOrdersController {

	@Autowired
	OrderService orderService;

	@PostMapping("/save")
	ResponseEntity<FoodOrders> saveOrders(@RequestBody FoodOrders foodOrders) {
		try {
			FoodOrders saveOrders = this.orderService.SaveOrders(foodOrders);
			return new ResponseEntity<>(saveOrders, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get/resto/{restoName}")
	ResponseEntity<List<FoodOrders>> RestoOrderHistory(@PathVariable String restoName) {

		try {
			List<FoodOrders> food = this.orderService.RestoOrderHistory(restoName);
			return new ResponseEntity<>(food, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/rest/order/{restoName}")
	ResponseEntity<List<FoodOrders>> getFoodOrder(@PathVariable String restoName) {
		try {
			List<FoodOrders> food = this.orderService.getFoodOrder(restoName);
			return new ResponseEntity<>(food, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@GetMapping("/getby/{username}")
	ResponseEntity<List<FoodOrders>> getFoodHistory(@PathVariable String username) {
		try {
			List<FoodOrders> food = this.orderService.getFoodHistory(username);
			return new ResponseEntity<>(food, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@GetMapping("/current/{username}")
	ResponseEntity<List<FoodOrders>> currentOrder(@PathVariable String username) {
		try {
			List<FoodOrders> food = this.orderService.currentOrder(username);
			return new ResponseEntity<>(food, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@GetMapping("/orderSent/{orderid}")
	public ResponseEntity<Boolean> OrderSent(@PathVariable long orderid) {
		try {
			boolean confirmed = this.orderService.OrderSent(orderid);
			if (confirmed) {
				return ResponseEntity.ok(true);
			} else {

				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(false);
			}
		} catch (Exception e) {

			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(false);
		}
	}

}
