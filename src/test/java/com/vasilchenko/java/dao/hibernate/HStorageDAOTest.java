package com.vasilchenko.java.dao.hibernate;

import com.vasilchenko.java.dao.StorageDAO;
import com.vasilchenko.java.model.Storage;
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
public class HStorageDAOTest {

	@Autowired StorageDAO storageDAO;

	@Test
	public void testGetAllIngredient() throws Exception {
		Assert.assertNotNull(storageDAO.getAllIngredient());
	}

	@Test
	public void testAddNewIngredient() throws Exception {
		String name = "testName";
		long q = (long) 153.1;
		Storage storage = new Storage(name,q);
		storageDAO.addNewIngredient(storage);
		Assert.assertEquals(storageDAO.getIngredientByName(name).getIngredientName(), name);
	}

	@Test
	public void testDeleteIngredientById() throws Exception {
		String name = "testName";
		long q = (long) 153.1;
		Storage storage = new Storage(name,q);
		storageDAO.addNewIngredient(storage);
		Storage result = storageDAO.getAllIngredient().stream()
				.filter(ingr -> Objects.equals(ingr.getIngredientName(), name) & Objects.equals(ingr.getQuantity(), q))
				.findAny()
				.orElse(null);
		storageDAO.deleteIngredientById(result.getId());
		Assert.assertNull(storageDAO.getIngredientById(result.getId()));
	}

	@Test
	public void testUpdateIngredient() throws Exception {
		String name = "testName";
		long q = (long) 153.1;
		Storage storage = new Storage(name,q);
		storageDAO.addNewIngredient(storage);
		Storage result = storageDAO.getAllIngredient().stream()
				.filter(ingr -> Objects.equals(ingr.getIngredientName(), name) & Objects.equals(ingr.getQuantity(), q))
				.findAny()
				.orElse(null);
		result.setQuantity(80);
		storageDAO.updateIngredient(result);
		Assert.assertEquals(storageDAO.getIngredientById(result.getId()).getQuantity(), result.getQuantity());
	}

	@Test
	public void testGetIngredientByName() throws Exception {
		String name = "testName";
		long q = (long) 153.1;
		Storage storage = new Storage(name,q);
		storageDAO.addNewIngredient(storage);
		Storage result = storageDAO.getAllIngredient().stream()
				.filter(ingr -> Objects.equals(ingr.getIngredientName(), name) & Objects.equals(ingr.getQuantity(), q))
				.findAny()
				.orElse(null);
		Assert.assertEquals(storageDAO.getIngredientById(result.getId()), result);
	}

	@Test
	public void testGetIngredientById() throws Exception {
		String name = "testName";
		long q = (long) 153.1;
		Storage storage = new Storage(name,q);
		storageDAO.addNewIngredient(storage);
		Storage result = storageDAO.getAllIngredient().stream()
				.filter(ingr -> Objects.equals(ingr.getIngredientName(), name) & Objects.equals(ingr.getQuantity(), q))
				.findAny()
				.orElse(null);
		Assert.assertEquals(storageDAO.getIngredientByName(result.getIngredientName()), result);

	}
}