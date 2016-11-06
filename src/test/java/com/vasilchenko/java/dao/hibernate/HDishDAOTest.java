package com.vasilchenko.java.dao.hibernate;

import com.vasilchenko.java.components.DishCategory;
import com.vasilchenko.java.dao.DishDAO;
import com.vasilchenko.java.model.Dish;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@ContextConfiguration(locations = "classpath:test-hibernate-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@Rollback(true)
public class HDishDAOTest {

	@Autowired
	DishDAO dishDAO;

	@Test
	public void testGetAllDish() throws Exception {
		Assert.assertNotNull(dishDAO.getAllDish());
	}

	@Test
	public void testFindByName() throws Exception {
		Dish dish = new Dish();
		String testName = "testName";
		dish.setName(testName);
		dishDAO.addNewDish(dish);
		Assert.assertEquals(dish, dishDAO.findByName(testName));

	}

	@Test
	public void testFindById() throws Exception {
		Dish dish = new Dish();
		String testName = "testName";
		dish.setName(testName);
		dishDAO.addNewDish(dish);
		Dish result = dishDAO.getAllDish().stream()
				.filter(dish1 -> Objects.equals(dish1.getName(), testName))
				.findAny()
				.orElse(null);
		Assert.assertEquals(dish, dishDAO.findById(result.getId()));
	}

	@Test
	public void testUpdateDish() throws Exception {
		Dish dish = new Dish();
		String testName = "testName";
		dish.setName(testName);
		dishDAO.addNewDish(dish);
		Dish result = dishDAO.getAllDish().stream()
				.filter(dish1 -> Objects.equals(dish1.getName(), testName))
				.findAny()
				.orElse(null);
		Assert.assertNotEquals(result.getCategory(), DishCategory.ALCOHOL);
		result.setCategory(DishCategory.ALCOHOL);
		dishDAO.updateDish(result);
		Assert.assertEquals(result.getCategory(), DishCategory.ALCOHOL);
	}

	@Test
	public void testAddNewDish() throws Exception {
		Dish dish = new Dish();
		String testName = "testName";
		dish.setName(testName);
		dishDAO.addNewDish(dish);
		Dish result = dishDAO.getAllDish().stream()
				.filter(dish1 -> Objects.equals(dish1.getName(), testName))
				.findAny()
				.orElse(null);
		Assert.assertEquals(result.getName(), testName);
	}

	@Test
	public void testDeleteDishById() throws Exception {
		Dish dish = new Dish();
		String testName = "testName";
		dish.setName(testName);
		dishDAO.addNewDish(dish);
		Dish result = dishDAO.getAllDish().stream()
				.filter(dish1 -> Objects.equals(dish1.getName(), testName))
				.findAny()
				.orElse(null);
		dishDAO.deleteDishById(result.getId());
		Assert.assertNull(dishDAO.findById(result.getId()));
	}
}