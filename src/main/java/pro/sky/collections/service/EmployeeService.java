package pro.sky.collections.service;

import org.springframework.stereotype.Service;
import pro.sky.collections.domain.Employee;
import pro.sky.exceptions.EmployeeAlreadyAddedException;
import pro.sky.exceptions.EmployeeNotFoundException;
import pro.sky.exceptions.EmployeeStorageIsFullException;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    private final int maxEmployees = 10;
    private List<Employee> employeeStore = new ArrayList<>();

    public Employee findEmployee(String firstName, String lastName) {
        if (firstName == null || lastName == null) {
            throw new RuntimeException("Передано неверное ФИО. Запись не добавлена");
        }
        Employee foundEmployee = null;
        for (Employee emp : employeeStore) {
            if (emp.getFirstName().equals(firstName) && emp.getLastName().equals(lastName)) {
                foundEmployee = emp;
                break;
            }
        }
        if (foundEmployee != null) {
            return foundEmployee;
        } else {
            throw new EmployeeNotFoundException();
        }
    }

    public void addNewEmployee(String firstName, String lastName) {
        if (firstName == null || lastName == null) {
            throw new RuntimeException("Передано неверное ФИО. Запись не добавлена");
        }
        if (employeeStore.size() >= maxEmployees) {
            throw new EmployeeStorageIsFullException();
        }
        try {
            Employee foundEmployee = findEmployee(firstName, lastName);
            if (foundEmployee != null) {
                throw new EmployeeAlreadyAddedException();
            }
        } catch (EmployeeNotFoundException e) {
            employeeStore.add(new Employee(firstName, lastName));
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

    public List<Employee> getListEmployees() {
        return employeeStore;
    }
}
