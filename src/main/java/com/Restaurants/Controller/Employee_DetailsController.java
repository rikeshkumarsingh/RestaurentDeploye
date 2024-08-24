package com.Restaurants.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Restaurants.Model.Employee_Details;
import com.Restaurants.Service.Employee_DetailsService;

@RestController
@RequestMapping("/emp")
public class Employee_DetailsController {

	@Autowired
	Employee_DetailsService employee_DetailsService;

	@PostMapping("/save")
	ResponseEntity<Employee_Details> CreateEmpDetails(@RequestBody Employee_Details employee_Details) {
		try {
			Employee_Details createEmp = this.employee_DetailsService.createEmp(employee_Details);
			return new ResponseEntity<Employee_Details>(createEmp, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<Employee_Details>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get/{restoUserName}")
	ResponseEntity<List<Employee_Details>>getEmpDetails(@PathVariable String restoUserName){
		try {
			List<Employee_Details> empByResto = this.employee_DetailsService.getEmpByResto(restoUserName);
			return  ResponseEntity.ok(empByResto);

		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/delete/{id}")
	ResponseEntity<?>deleteEmpDetails(@PathVariable long id){
		try {
			ResponseEntity<?> deleteEmpDetails = this.employee_DetailsService.deleteEmpDetails(id);
			return new ResponseEntity<>(deleteEmpDetails,HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/update")
	ResponseEntity<?>UpdateEmpDetails(@RequestBody Employee_Details employee_Details){
		try {
			ResponseEntity<?> updateEmpDetails = this.employee_DetailsService.UpdateEmpDetails(employee_Details);
			return new ResponseEntity<>(updateEmpDetails,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/getdata/{id}")
	ResponseEntity<Employee_Details>getEmpData(@PathVariable long id){
		
		try {
			Employee_Details empData = this.employee_DetailsService.getEmpData(id);
			return new ResponseEntity<Employee_Details>(empData,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Employee_Details>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
