package com.Restaurants.Service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.Restaurants.Model.Employee_Details;

public interface Employee_DetailsService {

	Employee_Details createEmp(Employee_Details employee_Details);

	List<Employee_Details> getEmpByResto(String restoUserName);

	ResponseEntity<?> deleteEmpDetails(long id);

	ResponseEntity<?> UpdateEmpDetails(Employee_Details employee_Details);

	Employee_Details getEmpData(long id);

}
