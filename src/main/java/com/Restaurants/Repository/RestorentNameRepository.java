package com.Restaurants.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Restaurants.Model.RestorentName;

public interface RestorentNameRepository extends JpaRepository<RestorentName, Long>{

	List<RestorentName> findByRestaurentUsername(String username);

	@Query("SELECT DISTINCT r.restaurentName FROM RestorentName r")
	List<String> findDistinctRestaurentNames();

	List<RestorentName> findAllByRestaurentName(String restro);

}
