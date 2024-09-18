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
        initListEmployees();
    }

    private void initListEmployees() {
        empBook.addNewEmployee("Иван Иванович", "Иванов", 5, 35000);
        empBook.addNewEmployee("Петр Петрович", "Петров", 2, 60000);
        empBook.addNewEmployee("Сергей Иванович", "Крылов", 1, 50000);
        empBook.addNewEmployee("Константин Сергеевич", "Агуреев", 1, 30000);
        empBook.addNewEmployee("Павел Иванович", "Соткин", 5, 25000);
        empBook.addNewEmployee("Александр Игоревич", "Игнатьев", 5, 45000);
        empBook.addNewEmployee("Ильшат Тагирович", "Дулетов", 2, 70000);
        empBook.addNewEmployee("Игорь Терентьевич", "Уральский", 1, 20000);
        empBook.addNewEmployee("Игорь Терентьевич", "Кацурин", 2, 15000);
        empBook.addNewEmployee("1", "2", 2, 2);
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