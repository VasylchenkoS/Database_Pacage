package com.vasilchenko.java.dao.hibernate;

import com.vasilchenko.java.dao.MenuDAO;
import com.vasilchenko.java.model.Menu;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class HMenuDAO implements MenuDAO {

    SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Menu> getAllMenu() {
        return sessionFactory.getCurrentSession().createQuery("select m from Menu m").list();
    }

    @Override
    public Menu getMenuById(int id) {
        return sessionFactory.getCurrentSession().get(Menu.class, id);
    }

    @Override
    public void addNewMenu(Menu menu) {
        sessionFactory.getCurrentSession().save(menu);
    }

    @Override
    public void deleteMenuById(int menuId) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(session.load(Menu.class, menuId));
        session.flush() ;
    }

    @Override
    public void updateMenu(Menu menu) {
        sessionFactory.getCurrentSession().update(menu);
    }

}
