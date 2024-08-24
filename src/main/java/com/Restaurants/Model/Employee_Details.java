package com.Restaurants.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Employee_Details {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String empId;
	private String empName;
	private String position;
	private String mobile;
	private String emailId;
	private String adddress;
	private long salary;
	private String restoUserName;
	

}
