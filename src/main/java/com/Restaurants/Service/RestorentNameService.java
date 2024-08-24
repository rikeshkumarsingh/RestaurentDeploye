package com.Restaurants.Service;

import java.util.List;

import com.Restaurants.Model.RestorentName;

public interface RestorentNameService {

	void saveResto(RestorentName restorentName);

	List<String> getAllResto();

	List<RestorentName> getAllRestoByUsername(String username);

	List<RestorentName> getFoodFromRestro(String restro);

}
