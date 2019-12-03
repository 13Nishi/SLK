package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.example.DAO.EmployeeDAO;
import com.example.DAO.EmployeeDAOImpl;
import com.example.model.Employee;


@RestController
@Repository
public class EmployeeRestController {
	@Autowired
private EmployeeDAOImpl employeeDAOimpl;

	
	@GetMapping("/employee")
		public List getEmployee() {
		
		return employeeDAOimpl.getAllEmployee();
	}
	
	
	@GetMapping("/employee/{id}")
	public ResponseEntity getCustomer(@PathVariable("id") Long id) {

		Employee employee = employeeDAOimpl.get(id);
		if (employee == null) {
			return new ResponseEntity("No Customer found for ID " + id, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity(employee, HttpStatus.OK);
	}

	
	@DeleteMapping("/delete/employee/{id}")
	public ResponseEntity deleteCustomer(@PathVariable Long id) {

		if (null == employeeDAOimpl.deleteAdmin(id)) {
			return new ResponseEntity("No Customer found for ID " + id, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity(id, HttpStatus.OK);

	}


}
