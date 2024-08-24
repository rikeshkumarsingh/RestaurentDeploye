package com.Restaurants.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Restaurants.Model.Employee_Details;

public interface Employee_DetailsRepository extends JpaRepository<Employee_Details, Long> {

	List<Employee_Details> findAllByRestoUserName(String restoUserName);

}
