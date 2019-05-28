package com.zoomcare.candidatechallenge.service;

import com.zoomcare.candidatechallenge.model.Employee;

import java.sql.Connection;
import java.util.Collection;


public interface EmployeeService {
    public abstract void createEmployee(Employee employee);
    public abstract void updateEmployee(String id, Employee employee);
    public abstract void deleteEmployee(String id);
    public abstract Collection<Employee> getEmployees();
    public abstract Collection<Employee> getEmployees(Connection conn);
}