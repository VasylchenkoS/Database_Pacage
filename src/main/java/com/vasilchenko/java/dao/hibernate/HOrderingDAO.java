package com.vasilchenko.java.dao.hibernate;

import com.vasilchenko.java.components.OrderState;
import com.vasilchenko.java.dao.OrderingDAO;
import com.vasilchenko.java.model.Ordering;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class HOrderingDAO implements OrderingDAO {

    SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addNewOrder(Ordering order) {
        sessionFactory.getCurrentSession().save(order);
    }

    @Override
    public void deleteOrder(Ordering order) throws ObjectNotFoundException {
        if (order.getOrderState() == null || order.getOrderState().equals(OrderState.OPEN)) {
            sessionFactory.getCurrentSession().delete(order);
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Ordering> getAllOrders() {
        return sessionFactory.getCurrentSession().createQuery(
                "select o from Ordering o").list();
    }

    @Override
    public Ordering getOrderById(int id) {
        return sessionFactory.getCurrentSession().load(Ordering.class, id);
    }
}