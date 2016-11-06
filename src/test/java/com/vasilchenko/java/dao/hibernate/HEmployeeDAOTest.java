package com.vasilchenko.java.dao.hibernate;

import com.vasilchenko.java.components.Position;
import com.vasilchenko.java.dao.EmployeeDAO;
import com.vasilchenko.java.model.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.junit.Assert;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@ContextConfiguration(locations = "classpath:test-hibernate-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@Rollback(true)
public class HEmployeeDAOTest {

	@Autowired EmployeeDAO employeeDAO;

	@Test
	public void testGetAllEmployee() throws Exception {
		Assert.assertNotNull(employeeDAO.getAllEmployee());
	}

	@Test
	public void testAddNewEmployee() throws Exception {
		Employee employee = new Employee();
		String testName = "testName";
		employee.setName(testName);
		String testSurname = "testSurname";
		employee.setSurname(testSurname);
		employeeDAO.addNewEmployee(employee);
		Employee findEmployee = employeeDAO.getAllEmployee().stream()
				.filter(employee1 ->
						Objects.equals(employee1.getName(), testName) &
								Objects.equals(employee1.getSurname(), testSurname))
				.findAny()
				.orElse(null);
		Assert.assertEquals(employee.getName(), findEmployee.getName());
		Assert.assertEquals(employee.getSurname(), findEmployee.getSurname());
	}

	@Test
	public void testDeleteEmployeeById() throws Exception {
		Employee employee = new Employee();
		String testName = "testName";
		employee.setName(testName);
		String testSurname = "testSurname";
		employee.setSurname(testSurname);
		employeeDAO.addNewEmployee(employee);
		Employee findEmployee = employeeDAO.getAllEmployee().stream()
				.filter(employee1 ->
						Objects.equals(employee1.getName(), testName) &
								Objects.equals(employee1.getSurname(), testSurname))
				.findAny()
				.orElse(null);
		employeeDAO.deleteEmployeeById(findEmployee.getId());
		Assert.assertNull(employeeDAO.getEmployeeById(findEmployee.getId()));
	}

	@Test
	public void testGetAllWaiters() throws Exception {
		List<Employee> allWaiters = employeeDAO.getAllWaiters();
		List<Employee> result = employeeDAO.getAllEmployee().stream()
				.filter(employee -> employee.getPosition() == Position.WAITER)
				.collect(Collectors.toList());
		Assert.assertEquals(result, allWaiters);
	}

	@Test
	public void testGetEmployeeById() throws Exception {
		Employee employee = new Employee();
		String testName = "testName";
		employee.setName(testName);
		String testSurname = "testSurname";
		employee.setSurname(testSurname);
		employeeDAO.addNewEmployee(employee);
		Employee findEmployee = employeeDAO.getAllEmployee().stream()
				.filter(employee1 ->
						Objects.equals(employee1.getName(), testName) &
								Objects.equals(employee1.getSurname(), testSurname))
				.findAny()
				.orElse(null);
		Employee actual = employeeDAO.getEmployeeById(findEmployee.getId());
		Assert.assertEquals(findEmployee.getId(), actual.getId());
	}

	@Test
	public void testUpdateEmployee() throws Exception {
		Employee employee = new Employee();
		String testName = "testName";
		employee.setName(testName);
		String testSurname = "testSurname";
		employee.setSurname(testSurname);
		employeeDAO.addNewEmployee(employee);
		Employee findEmployee = employeeDAO.getAllEmployee().stream()
				.filter(employee1 ->
						Objects.equals(employee1.getName(), testName) &
								Objects.equals(employee1.getSurname(), testSurname))
				.findAny()
				.orElse(null);
		Assert.assertNotEquals(findEmployee.getPosition(), Position.DIRECTOR);
		findEmployee.setPosition(Position.DIRECTOR);
		employeeDAO.updateEmployee(findEmployee);
		Assert.assertEquals(findEmployee.getPosition(), Position.DIRECTOR);
	}

	@Test(expected = ClassCastException.class)
	public void testValidEmployee() {
		Employee employee = new Employee();
		String testName = "testName";
		employee.setName(testName);
		String testSurname = "testSurname";
		employee.setSurname(testSurname);
		Date date = new Date();
		employee.setBirth((java.sql.Date) date);
		employeeDAO.addNewEmployee(employee);
	}
}