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
    private final Map<String, Employee> employeeStore = new HashMap<>();

    public Employee findEmployee(String firstName, String lastName) {
        if (firstName == null || lastName == null) {
            throw new RuntimeException("Передано неверное ФИО. Запись не добавлена");
        }
        if (employeeStore.size() == 0) {
            throw new EmployeeNotFoundException();
        }
        Employee currEmp = new Employee(firstName, lastName, 0, 0);
        for (Map.Entry<String, Employee> employee : employeeStore.entrySet()) {
            if (employee.getValue() == null) {
                break;
            }
            if (employee.getValue().hashCode() == currEmp.hashCode()) {
                return currEmp;
            }
        }
        throw new EmployeeNotFoundException();
    }

    public void addNewEmployee(String firstName, String lastName, int departmentNum, double salary) {
        if (firstName == null || lastName == null) {
            throw new RuntimeException("Передано неверное ФИО. Запись не добавлена");
        }
        Employee foundEmployee;
        Employee newEmployee = new Employee(firstName, lastName, departmentNum, salary);
        int sizeEmpStore = employeeStore.size();

        if (sizeEmpStore >= maxEmployees) {
            throw new EmployeeStorageIsFullException();
        }
        try {
            foundEmployee = findEmployee(firstName, lastName);
            if (foundEmployee != null) {
                throw new EmployeeAlreadyAddedException();
            }
        } catch (EmployeeNotFoundException e) {
            employeeStore.put(newEmployee.toString(), newEmployee);
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

    public Map<String, Employee> getListEmployees() {
        return employeeStore;
    }
}