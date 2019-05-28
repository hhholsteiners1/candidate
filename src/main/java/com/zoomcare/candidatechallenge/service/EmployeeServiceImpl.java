package com.zoomcare.candidatechallenge.service;

import com.zoomcare.candidatechallenge.model.Employee;
import com.zoomcare.candidatechallenge.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


@Service
public class EmployeeServiceImpl implements EmployeeService {
    private static Map<String, Employee> employeeRepo = new HashMap<>();

    static {
        Employee honey = new Employee();
        honey.setId("1");
        honey.setName("Honey");
        employeeRepo.put(honey.getId(), honey);

        Employee almond = new Employee();
        almond.setId("2");
        almond.setName("Almond");
        employeeRepo.put(almond.getId(), almond);
    }

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
    public Collection<Employee> getEmployees() {
        return employeeRepo.values();
    }

}
