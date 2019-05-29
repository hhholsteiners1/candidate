package com.zoomcare.candidatechallenge.service;

import com.zoomcare.candidatechallenge.model.Employee;
import com.zoomcare.candidatechallenge.model.Product;
import com.zoomcare.candidatechallenge.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


@Service
public class EmployeeServiceImpl implements EmployeeService {
    private static Map<String, Employee> employeeRepo = new HashMap<>();


    @Override
    public void createEmployee(Employee employee) {
        employeeRepo.put(employee.getId(), employee);
    }

    @Override
    public void updateEmployee(String id, Employee employee) {
        employeeRepo.remove(id);
        employee.setId(id);
        employeeRepo.put(id, employee);
    }

    @Override
    public void deleteEmployee(String id) {
        employeeRepo.remove(id);
    }

    @Override
    public Collection<Employee> getEmployees(Connection conn) {
        employeeRepo.clear();
        try {

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("Select * from EMPLOYEE");
            while (rs.next()) {
                String id = rs.getString("ID");
                String name = rs.getString("SUPERVISOR_ID");
                Employee employee = new Employee();
                employee.setId(id);
                employee.setName(name);
                employeeRepo.put(employee.getId(), employee);

        catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        }

        return employeeRepo.values();
    }

    @Override
    public Collection<Employee> getEmployees() {
        return employeeRepo.values();
    }

    @Override

    public Collection<Employee> getEmployee(Connection conn, String id) {

        employeeRepo.clear();

        try {


            Statement st = conn.createStatement();

            ResultSet rs = st.executeQuery("Select * from EMPLOYEE where ID =" + id);

            while (rs.next()) {

                String Id = rs.getString("ID");

                String name = rs.getString("SUPERVISOR_ID");

                Employee employee = new Employee();

                employee.setId(Id);

                employee.setName(name);

                employeeRepo.put(employee.getId(), employee);


            }


        } catch (SQLException se) {

//Handle errors for JDBC

            se.printStackTrace();

        }

    }
}