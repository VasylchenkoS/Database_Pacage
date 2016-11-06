package com.vasilchenko.java.dao;

import com.vasilchenko.java.model.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> getAllEmployee();

    void addNewEmployee(Employee employee);

    void deleteEmployeeById(int Id);

    void updateEmployee(Employee employee);

    List<Employee> getAllWaiters();

    Employee getEmployeeById(int id);
}
