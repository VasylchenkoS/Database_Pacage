package com.vasilchenko.java.dao;

import com.vasilchenko.java.model.Ordering;

import java.util.List;

public interface OrderingDAO {

    void addNewOrder(Ordering order);

    void deleteOrder(Ordering order);

    List<Ordering> getAllOrders();

    Ordering getOrderById(int id);
}