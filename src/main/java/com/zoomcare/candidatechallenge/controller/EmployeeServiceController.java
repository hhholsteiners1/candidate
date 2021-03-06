package com.zoomcare.candidatechallenge.controller;

import com.zoomcare.candidatechallenge.model.Employee;
import com.zoomcare.candidatechallenge.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


@RestController
public class EmployeeServiceController {
    @Autowired
    EmployeeService employeeService;
    Connection conn;

    public EmployeeServiceController(){

        try {
            Class.forName("org.h2.Driver");
            conn = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
        }

        catch(SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        }

        catch(Exception se) {
            //Handle errors for JDBC
            se.printStackTrace();
        }



    }




    @RequestMapping(value = "/employees")
    public ResponseEntity<Object> getEmployees() {
        return new ResponseEntity<>(employeeService.getEmployees(), HttpStatus.OK);
    }
    @RequestMapping(value = "/employees2")
    public ResponseEntity<Object> getEmployees2() {
        return new ResponseEntity<>(employeeService.getEmployees(conn), HttpStatus.OK);
    }
    @RequestMapping(value = "/employees/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object>
    updateEmployee(@PathVariable("id") String id, @RequestBody Employee employee) {

        employeeService.updateEmployee(id, employee);
        return new ResponseEntity<>("Employee is updated successsfully", HttpStatus.OK);
    }
    @RequestMapping(value = "/employees/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> delete(@PathVariable("id") String id) {
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>("Employee is deleted successsfully", HttpStatus.OK);
    }
    @RequestMapping(value = "/employees", method = RequestMethod.POST)
    public ResponseEntity<Object> createEmployee(@RequestBody Employee employee) {
        employeeService.createEmployee(employee);
        return new ResponseEntity<>("Employee is created successfully", HttpStatus.CREATED);
    }

    @RequestMapping(value = "/employees2/{id}", method = RequestMethod.GET)

    public ResponseEntity<Object>

    getEmployee(@PathVariable("id") String id) {

        return new ResponseEntity<>(employeeService.getEmployee(conn, id), HttpStatus.OK);





    }

}
