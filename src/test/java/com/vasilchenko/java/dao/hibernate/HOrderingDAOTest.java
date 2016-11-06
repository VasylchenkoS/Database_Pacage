package com.vasilchenko.java.dao.hibernate;

import com.vasilchenko.java.dao.EmployeeDAO;
import com.vasilchenko.java.dao.OrderingDAO;
import com.vasilchenko.java.model.Employee;
import com.vasilchenko.java.model.Ordering;
import org.hibernate.ObjectNotFoundException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.Objects;

@ContextConfiguration(locations = "classpath:test-hibernate-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@Rollback(true)
public class HOrderingDAOTest {

	@Autowired OrderingDAO orderingDAO;
	@Autowired EmployeeDAO employeeDAO;

	@Test
	public void testAddNewOrder() throws Exception {
		Ordering order = new Ordering();
		Employee employee = employeeDAO.getAllWaiters().get(0);
		order.setEmployee(employee);
		Date date = new Date(1985, 2, 12);
		order.setDate(date);
		orderingDAO.addNewOrder(order);
		Ordering result = orderingDAO.getAllOrders().stream()
				.filter(order1 -> Objects.equals(order1.getEmployee(), employee) & Objects.equals(order1.getDate(), date))
				.findAny()
				.orElse(null);
		Assert.assertEquals(result.getEmployee(), order.getEmployee());
		Assert.assertEquals(result.getDate(), order.getDate());
	}

	@Test(expected = ObjectNotFoundException.class)
	public void testDeleteOrder() throws Exception {
		Ordering order = new Ordering();
		Employee employee = employeeDAO.getAllWaiters().get(0);
		order.setEmployee(employee);
		Date date = new Date(1985, 2, 12);
		order.setDate(date);
		orderingDAO.addNewOrder(order);
		Ordering result = orderingDAO.getAllOrders().stream()
				.filter(order1 -> Objects.equals(order1.getEmployee(), employee) & Objects.equals(order1.getDate(), date))
				.findAny()
				.orElse(null);
		Assert.assertEquals(result.getEmployee(), order.getEmployee());
		Assert.assertEquals(result.getDate(), order.getDate());
		orderingDAO.deleteOrder(result);
		Assert.assertNull(orderingDAO.getOrderById(result.getId()));
	}

	@Test
	public void testGetAllOrders() throws Exception {
		Assert.assertNotNull(orderingDAO.getAllOrders());
	}

	@Test
	public void testGetOrderById() throws Exception {
		Ordering order = new Ordering();
		Employee employee = employeeDAO.getAllWaiters().get(0);
		order.setEmployee(employee);
		Date date = new Date(1985, 2, 12);
		order.setDate(date);
		orderingDAO.addNewOrder(order);
		Ordering result = orderingDAO.getAllOrders().stream()
				.filter(order1 -> Objects.equals(order1.getEmployee(), employee) & Objects.equals(order1.getDate(), date))
				.findAny()
				.orElse(null);
		Assert.assertEquals(orderingDAO.getOrderById(result.getId()), order);
	}
}