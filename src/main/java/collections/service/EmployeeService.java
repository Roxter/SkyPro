package collections.service;

import collections.domain.Employee;
import collections.exceptions.EmployeeAlreadyAddedException;
import collections.exceptions.EmployeeNotFoundException;
import collections.exceptions.EmployeeNotValidDataException;
import collections.exceptions.EmployeeStorageIsFullException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeService {
    private final int maxEmployees = 10;
    private final Map<String, Employee> employeeStore = new HashMap<>();
    private final String symbMask = "абвгдезжийклмнопрстуфхцчшщъыьэюя ";
    private final String upperCaseMask = "АБВГДЕЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";

    public Employee findEmployee(String firstName, String lastName) {
        checkFio(firstName, lastName);
        if (!validUpperCaseUserEntry(firstName)) {
            firstName = StringUtils.capitalize(firstName);
        }
        if (!validUpperCaseUserEntry(lastName)) {
            lastName = StringUtils.capitalize(lastName);
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
        checkFio(firstName, lastName);
        if (!validUpperCaseUserEntry(firstName)) {
            firstName = StringUtils.capitalize(firstName);
        }
        if (!validUpperCaseUserEntry(lastName)) {
            lastName = StringUtils.capitalize(lastName);
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
        checkFio(firstNameToDelete, lastNameToDelete);
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

    private boolean validUserEntry(String str) {
        return StringUtils.containsOnly(str.toLowerCase(Locale.ROOT), symbMask);
    }

    private boolean validUpperCaseUserEntry(String str) {
        return StringUtils.containsAny(StringUtils.trim(str), upperCaseMask);
    }
    private void checkFio(String firstName, String lastName) {
        if (firstName == null || lastName == null) {
            throw new RuntimeException("Передано неверное ФИО. Запись не добавлена");
        }
        if (!validUserEntry(firstName) || !validUserEntry(lastName)) {
            throw new EmployeeNotValidDataException("Введены неверные данные. Запись не добавлена");
        }
    }
}