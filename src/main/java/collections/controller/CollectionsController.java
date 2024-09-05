package collections.controller;

import collections.domain.Employee;
import collections.exceptions.EmployeeAlreadyAddedException;
import collections.exceptions.EmployeeNotFoundException;
import collections.exceptions.EmployeeStorageIsFullException;
import collections.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/employee")
public class CollectionsController {
    private final EmployeeService empBook;

    public CollectionsController(EmployeeService employeeService) {
        this.empBook = employeeService;
        /*empBook.addNewEmployee("Иван Иванович", "Иванов");
        empBook.addNewEmployee("Петр Петрович", "Петров");
        empBook.addNewEmployee("Сергей Иванович", "Крылов");
        empBook.addNewEmployee("Константин Сергеевич", "Агуреев");
        empBook.addNewEmployee("Павел Иванович", "Соткин");
        empBook.addNewEmployee("Александр Игоревич", "Игнатьев");
        empBook.addNewEmployee("Ильшат Тагирович", "Дулетов");
        empBook.addNewEmployee("Игорь Терентьевич", "Уральский");
        empBook.addNewEmployee("Игорь Терентьевич", "Кацурин");
        empBook.addNewEmployee("1", "2");
        empBook.addNewEmployee("3", "4");
        empBook.findEmployee("1", "2");
        empBook.findEmployee("1", "22");
        empBook.deleteEmployee("1", "2");
        empBook.deleteEmployee("1", "2");
        empBook.deleteEmployee("1", "22");*/
    }

    @GetMapping
    public String showGreetings() {
        return "Добро пожаловать в книгу сотрудников";
    }

    @GetMapping("find")
    public String findEmployee(@RequestParam(value = "firstName") String firstNameStr,
                               @RequestParam(value = "lastName") String lastNameStr) {
        try {
            empBook.findEmployee(firstNameStr, lastNameStr);
        } catch (EmployeeNotFoundException e) {
            return "Сотрудник " + lastNameStr + " " + firstNameStr + " не найден.";
        }
        return String.format("{ \"firstName\": \"%s\", \"lastName\": \"%s\" }", firstNameStr, lastNameStr);
    }

    @GetMapping("add")
    public String addEmployee(@RequestParam(value = "firstName") String firstNameStr,
                              @RequestParam(value = "lastName") String lastNameStr,
                              @RequestParam(value = "deptNo") Integer deptNo,
                              @RequestParam(value = "salary") Integer salary) {
        try {
            empBook.addNewEmployee(firstNameStr, lastNameStr, deptNo, salary);
        } catch (EmployeeAlreadyAddedException e1) {
            return "Сотрудник " + firstNameStr + " уже добавлен. Добавление отменено.";
        } catch (EmployeeStorageIsFullException e2) {
            return "Список сотрудников переполнен. Добавление отменено.";
        }
        return String.format("{ \"firstName\": \"%s\", \"lastName\": \"%s\" }", firstNameStr, lastNameStr);
    }

    @GetMapping("delete")
    public String delEmployee(@RequestParam(value = "firstName") String firstNameStr,
                              @RequestParam(value = "lastName") String lastNameStr) {
        try {
            empBook.deleteEmployee(firstNameStr, lastNameStr);
        } catch (EmployeeNotFoundException e) {
            return "Сотрудник " + firstNameStr + " не найден. Удаление отменено.";
        }
        return String.format("{ \"firstName\": \"%s\", \"lastName\": \"%s\" }", firstNameStr, lastNameStr);
    }

    @GetMapping("list")
    public StringBuilder listEmployees() {
        StringBuilder jsonString = new StringBuilder("[ ");
        Map<Employee, Integer> employeeStore = empBook.getListEmployees();
        for (Employee employee : employeeStore.keySet()) {
            if (employee != null) {
                String currStrEmp = String.format("{ \"firstName\": \"%s\", \"lastName\": \"%s }", employee.getFirstName(), employee.getLastName());
                jsonString.append(currStrEmp).append(", ");
            }
        }
        jsonString.append(" ]");
        return jsonString;
    }
}
