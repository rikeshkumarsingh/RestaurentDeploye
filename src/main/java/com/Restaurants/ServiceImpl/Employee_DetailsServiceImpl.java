package com.Restaurants.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Restaurants.Model.Employee_Details;
import com.Restaurants.Repository.Employee_DetailsRepository;
import com.Restaurants.Service.Employee_DetailsService;

@Service
public class Employee_DetailsServiceImpl implements Employee_DetailsService {
	
	@Autowired
	Employee_DetailsRepository employee_DetailsRepository;

	@Override
	public Employee_Details createEmp(Employee_Details employee_Details) {
		Employee_Details save = this.employee_DetailsRepository.save(employee_Details);
		return save;
	}

	@Override
	public List<Employee_Details> getEmpByResto(String restoUserName) {
		List<Employee_Details> findAllByRestoUserName = this.employee_DetailsRepository.findAllByRestoUserName(restoUserName);
		return findAllByRestoUserName;
	}

	@Override
	public ResponseEntity<?> deleteEmpDetails(long id) {
	    Optional<Employee_Details> findById = this.employee_DetailsRepository.findById(id);
	    
	    if (findById.isPresent()) {
	        this.employee_DetailsRepository.deleteById(id);
	        return new ResponseEntity<>(HttpStatus.OK);
	    } else {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}

	@Override
	public ResponseEntity<?> UpdateEmpDetails(Employee_Details employee_Details) {
		Optional<Employee_Details> findById = this.employee_DetailsRepository.findById(employee_Details.getId());
		if (findById.isPresent()) {
			Employee_Details employee_Details2=new Employee_Details();
			employee_Details2.setId(employee_Details.getId());
			employee_Details2.setEmpId(employee_Details.getEmpId());
			employee_Details2.setEmpName(employee_Details.getEmpName());
			employee_Details2.setPosition(employee_Details.getPosition());
			employee_Details2.setMobile(employee_Details.getMobile());
			employee_Details2.setEmailId(employee_Details.getEmailId());
			employee_Details2.setAdddress(employee_Details.getAdddress());
			employee_Details2.setSalary(employee_Details.getSalary());
			employee_Details2.setRestoUserName(employee_Details.getRestoUserName());
			Employee_Details save = this.employee_DetailsRepository.save(employee_Details2);
			 return new ResponseEntity<>(save, HttpStatus.OK);
			
		} else {
			  return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}

	@Override
	public Employee_Details getEmpData(long id) {
		Employee_Details employee_Details = this.employee_DetailsRepository.findById(id).get();
		return employee_Details;
	}


}
