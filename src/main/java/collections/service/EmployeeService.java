package collections.service;

import collections.domain.Employee;
import collections.exceptions.EmployeeAlreadyAddedException;
import collections.exceptions.EmployeeNotFoundException;
import collections.exceptions.EmployeeStorageIsFullException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeService {
    private final int maxEmployees = 10;
    private final Map<Employee, Integer> employeeStore = new HashMap<>();

    public Employee findEmployee(String firstName, String lastName) {
        if (firstName == null || lastName == null) {
            throw new RuntimeException("Передано неверное ФИО. Запись не добавлена");
        }
        if (employeeStore.size() == 0) {
            throw new EmployeeNotFoundException();
        }
        Employee currEmp = new Employee(firstName, lastName);
        for (Map.Entry<Employee, Integer> employee : employeeStore.entrySet()) {
            if (employee.getKey() == null) {
                break;
            }
            if (employee.getKey().hashCode() == currEmp.hashCode()) {
                return currEmp;
            }
        }
        throw new EmployeeNotFoundException();
    }

    public void addNewEmployee(String firstName, String lastName) {
        if (firstName == null || lastName == null) {
            throw new RuntimeException("Передано неверное ФИО. Запись не добавлена");
        }
        Employee foundEmployee;
        Employee newEmployee = new Employee(firstName, lastName);
        Integer sizeEmpStore = employeeStore.size();

        if (sizeEmpStore >= maxEmployees) {
            throw new EmployeeStorageIsFullException();
        }
        try {
            foundEmployee = findEmployee(firstName, lastName);
            if (foundEmployee != null) {
                throw new EmployeeAlreadyAddedException();
            }
        } catch (EmployeeNotFoundException e) {
            employeeStore.put(newEmployee, sizeEmpStore);
        }
    }

    public void deleteEmployee(String firstNameToDelete, String lastNameToDelete) {
        if (firstNameToDelete == null || lastNameToDelete == null) {
            throw new RuntimeException("Передано неверное ФИО. Запись не добавлена");
        }
        try {
            Employee foundEmployee = findEmployee(firstNameToDelete, lastNameToDelete);
            if (foundEmployee != null) {
                employeeStore.remove(foundEmployee);
            }
        } catch (EmployeeNotFoundException e) {
            throw new EmployeeNotFoundException();
        }
    }

    public Map<Employee, Integer> getListEmployees() {
        return employeeStore;
    }
}