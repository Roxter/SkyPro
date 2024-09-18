package collections.service;

import collections.domain.Employee;
import collections.exceptions.EmployeeAlreadyAddedException;
import collections.exceptions.EmployeeNotFoundException;
import collections.exceptions.EmployeeStorageIsFullException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
            throw new EmployeeNotFoundException("Сотрудник " + lastName + " " + firstName + " не найден.");
        }
        Employee currEmp = new Employee(firstName, lastName, 0, 0);
        for (Map.Entry<String, Employee> employee : employeeStore.entrySet()) {
            if (employee.getValue() == null) {
                break;
            }
            if (employee.getValue().equals(currEmp)) {
                currEmp = employee.getValue();
                return currEmp;
            }
        }
        throw new EmployeeNotFoundException("Сотрудник " + lastName + " " + firstName + " не найден.");
    }

    public Employee addNewEmployee(String firstName, String lastName, int departmentNum, double salary) {
        if (firstName == null || lastName == null) {
            throw new RuntimeException("Передано неверное ФИО. Запись не добавлена");
        }

        Employee newEmployee = new Employee(firstName, lastName, departmentNum, salary);
        int sizeEmpStore = employeeStore.size();

        if (sizeEmpStore >= maxEmployees) {
            throw new EmployeeStorageIsFullException("Список сотрудников переполнен. Добавление отменено.");
        }

        if (!employeeStore.containsKey(newEmployee.toString())) {
            employeeStore.put(newEmployee.toString(), newEmployee);
            return employeeStore.get(newEmployee.toString());
        } else {
            throw new EmployeeAlreadyAddedException("Сотрудник " + firstName + " уже добавлен. Добавление отменено.");
        }
    }

    public Employee deleteEmployee(String firstNameToDelete, String lastNameToDelete) {
        if (firstNameToDelete == null || lastNameToDelete == null) {
            throw new RuntimeException("Передано неверное ФИО. Запись не добавлена");
        }
        Employee currEmp = new Employee(firstNameToDelete, lastNameToDelete, 0, 0);
        String currHashEmp = currEmp.toString();
        if (employeeStore.containsKey(currHashEmp)) {
            employeeStore.remove(currHashEmp);
            return employeeStore.get(currHashEmp);
        } else {
            throw new EmployeeNotFoundException("Сотрудник " + firstNameToDelete + " не найден. Удаление отменено.");
        }
    }

    public List<Employee> getListEmployees() {
        return new ArrayList<>(employeeStore.values());
    }
}