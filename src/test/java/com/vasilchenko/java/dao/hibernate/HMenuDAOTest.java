package com.vasilchenko.java.dao.hibernate;

import com.vasilchenko.java.dao.DishDAO;
import com.vasilchenko.java.dao.MenuDAO;
import com.vasilchenko.java.model.Dish;
import com.vasilchenko.java.model.Menu;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@ContextConfiguration(locations = "classpath:test-hibernate-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@Rollback(true)
public class HMenuDAOTest {

	@Autowired MenuDAO menuDAO;
	@Autowired DishDAO dishDAO;

	@Test
	public void testGetAllMenu() throws Exception {
		Assert.assertNotNull(menuDAO.getAllMenu());
	}

	@Test
	public void testGetMenuById() throws Exception {
		Menu menu = new Menu();
		String testName = "testName";
		menu.setMenuName(testName);
		menuDAO.addNewMenu(menu);
		Menu result = menuDAO.getAllMenu().stream()
				.filter(menu1 -> Objects.equals(menu1.getMenuName(), testName))
				.findAny()
				.orElse(null);
		Assert.assertEquals(menu, menuDAO.getMenuById(result.getId()));
	}

	@Test
	public void testAddNewMenu() throws Exception {
		Menu menu = new Menu();
		String testName = "testName";
		menu.setMenuName(testName);
		menuDAO.addNewMenu(menu);
		Menu result = menuDAO.getAllMenu().stream()
				.filter(menu1 -> Objects.equals(menu1.getMenuName(), testName))
				.findAny()
				.orElse(null);
		Assert.assertEquals(result.getMenuName(), testName);
	}

	@Test
	public void testDeleteMenuById() throws Exception {
		Menu menu = new Menu();
		String testName = "testName";
		menu.setMenuName(testName);
		menuDAO.addNewMenu(menu);
		Menu result = menuDAO.getAllMenu().stream()
				.filter(menu1 -> Objects.equals(menu1.getMenuName(), testName))
				.findAny()
				.orElse(null);
		menuDAO.deleteMenuById(result.getId());
		Assert.assertNull(menuDAO.getMenuById(result.getId()));
	}

	@Test
	public void testUpdateMenu() throws Exception {
		Menu menu = new Menu();
		String testName = "testName";
		menu.setMenuName(testName);
		menuDAO.addNewMenu(menu);
		Menu result = menuDAO.getAllMenu().stream()
				.filter(menu1 -> Objects.equals(menu1.getMenuName(), testName))
				.findAny()
				.orElse(null);
		Set<Dish> dish = new HashSet<>();
		dish.add(dishDAO.findByName("Soup"));
		result.setDishSet(dish);
		menuDAO.updateMenu(result);
		Assert.assertNotNull(menuDAO.getMenuById(result.getId()).getDishSet());
	}
}