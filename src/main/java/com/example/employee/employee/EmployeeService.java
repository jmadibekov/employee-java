package com.example.employee.employee;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    public List<Employee> getEmployees(Boolean sortBySalary) {
        List<Employee> employees = employeeRepository.findAll();

        if (sortBySalary != null && sortBySalary) {
            employees.sort(Comparator.comparing(Employee::getSalary));
        }
        return employees;
    }

    public Employee getEmployeeWithHighestSalary() {
        List<Employee> employees = employeeRepository.findAll();
        employees.sort(Comparator.comparing(Employee::getSalary));
        return employees.getLast();
    }

    public void deleteEmployee(Integer id) {
        boolean exists = employeeRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("Employee with id " + id + " does not exist");
        }
        employeeRepository.deleteById(id);
    }

    @Transactional
    public void updateEmployee(Integer id, String name, String position, BigDecimal salary) {
        Employee employee = employeeRepository.findById(id).orElseThrow(
                () -> new IllegalStateException("Employee with id " + id + " does not exist")
        );

        if (name != null && !name.isEmpty() && !Objects.equals(employee.getName(), name)) {
            employee.setName(name);
        }

        if (position != null && !position.isEmpty() && !Objects.equals(employee.getPosition(), position)) {
            employee.setPosition(position);
        }

        if (salary != null) {
            employee.setSalary(salary);
        }
    }
}
