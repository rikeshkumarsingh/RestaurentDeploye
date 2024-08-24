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

import com.Restaurants.Model.RestorentName;
import com.Restaurants.Service.RestorentNameService;

@RestController
@RequestMapping("/rest")
public class RestorentNameController {

	@Autowired
	RestorentNameService restorentNameService;

	@PostMapping("/save")
	ResponseEntity<?> saveResto(@RequestBody RestorentName restorentName) {
		try {
			this.restorentNameService.saveResto(restorentName);
			return new ResponseEntity<>("Created successfully", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/getAll")
	ResponseEntity<List<?>> getAllResto() {
		try {
            List<String> allResto = this.restorentNameService.getAllResto();
            return new ResponseEntity<>(allResto, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
	}
	@GetMapping("/get/{username}")
	ResponseEntity<List<RestorentName>> getRestoByUsernsme(@PathVariable String username) {
		try {
            List<RestorentName> allResto = this.restorentNameService.getAllRestoByUsername(username);
            return new ResponseEntity<>(allResto, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
	}
	
	@GetMapping("/get/food/{restro}")
	ResponseEntity<List<RestorentName>> getfood(@PathVariable String restro) {
		try {
            List<RestorentName> allResto = this.restorentNameService.getFoodFromRestro(restro);
            return new ResponseEntity<>(allResto, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
	}

}
