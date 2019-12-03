package com.example.DAO;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.model.Employee;
@Repository
public interface EmployeeDAO {
	
	List<Employee>getAllEmployee();

	Long deleteAdmin(Long empId);

	Employee get(Long id);
	


}
