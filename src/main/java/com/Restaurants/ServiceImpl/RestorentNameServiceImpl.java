package com.Restaurants.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Restaurants.Model.RestorentName;
import com.Restaurants.Repository.RestorentNameRepository;
import com.Restaurants.Service.RestorentNameService;

@Service
public class RestorentNameServiceImpl implements RestorentNameService{
	
	@Autowired
	RestorentNameRepository restorentNameRepository;

	@Override
	public void saveResto(RestorentName restorentName) {
		this.restorentNameRepository.save(restorentName);
		
	}

	@Override
	public List<String> getAllResto() {
		 List<String> uniqueRestoNames = this.restorentNameRepository.findDistinctRestaurentNames();
		    return uniqueRestoNames;
	}

	@Override
	public List<RestorentName> getAllRestoByUsername(String username) {
		List<RestorentName> findByRestaurentUsername = this.restorentNameRepository.findByRestaurentUsername(username);
		return findByRestaurentUsername;
	}

	@Override
	public List<RestorentName> getFoodFromRestro(String restro) {
		List<RestorentName> findAllByRestaurentName = this.restorentNameRepository.findAllByRestaurentName(restro);
		return findAllByRestaurentName;
	}

}
