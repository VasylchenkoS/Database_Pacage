package com.vasilchenko.java.dao;

import com.vasilchenko.java.model.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@ContextConfiguration(locations = "classpath:test-hibernate-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class EmployeeDAOTest {

	@Autowired
	EmployeeDAO employeeDAO;

	@Test
	@Transactional
	@Rollback(true)
	public void testGetAllEmployee() throws Exception {

		List<Employee> employeeList = employeeDAO.getAllEmployee();
		if (employeeList != null)
			employeeList.forEach(System.out::println);
	}

	@Test
	public void testGetEmployeeBySurname() throws Exception {

	}

	@Test
	public void testAddNewEmployee() throws Exception {

	}

	@Test
	public void testDeleteEmployeeById() throws Exception {

	}

	@Test
	public void testGetAllCooks() throws Exception {

	}

	@Test
	public void testGetAllWaiters() throws Exception {

	}

	@Test
	public void testGetEmployeeById() throws Exception {

	}

	@Test
	public void testGetEmployeeByName() throws Exception {

	}

	@Test
	public void testGetEmployeeByNameAndSurname() throws Exception {

	}
}