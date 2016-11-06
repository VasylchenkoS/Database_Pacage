package com.vasilchenko.java.dao;

import com.vasilchenko.java.model.Menu;

import java.util.List;

public interface MenuDAO {

    List<Menu> getAllMenu();

    Menu getMenuById(int id);

    void addNewMenu(Menu menu);

    void deleteMenuById(int id);

    void updateMenu(Menu menu);

}
