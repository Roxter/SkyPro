package collections.service;

import collections.domain.Employee;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class DepartmentService {
    private final EmployeeService empBook;

    public DepartmentService() {
        this.empBook = new EmployeeService();
    }

    // Метод из Map<index, Employee> сделал List<Employee>
    public String getByDepartmentId(Integer depNum) {
        return empBook.getListEmployees()
                .stream().filter(k -> k.getDepartmentNum() == depNum)
                .collect(Collectors.toList()).toString();
    }

    public Employee findMinEmplSalaryOnDep(Integer depNum) {
        final Optional<Employee> minEmplSalary = empBook.getListEmployees()
                .stream().filter(k -> k.getDepartmentNum() == depNum)
                .min(Comparator.comparingDouble((Employee::getSalary)));
        return minEmplSalary.orElseThrow(() -> new RuntimeException("Employee not found"));
    }

    public Employee findMaxEmplSalaryOnDep(Integer depNum) {
        final Optional<Employee> maxEmplSalary = empBook.getListEmployees()
                .stream().filter(k -> k.getDepartmentNum() == depNum)
                .max(Comparator.comparingDouble((Employee::getSalary)));
        return maxEmplSalary.orElseThrow(() -> new RuntimeException("Employee not found"));
    }

    public String getByDepartments() {
        return empBook.getListEmployees()
                .stream().collect(Collectors.groupingBy(Employee::getDepartmentNum))
                .toString();
    }
}