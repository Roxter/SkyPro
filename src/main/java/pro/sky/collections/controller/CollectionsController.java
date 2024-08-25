package pro.sky.collections.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.collections.domain.Employee;
import pro.sky.collections.service.EmployeeService;
import pro.sky.exceptions.EmployeeAlreadyAddedException;
import pro.sky.exceptions.EmployeeNotFoundException;
import pro.sky.exceptions.EmployeeStorageIsFullException;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class CollectionsController {
    private final EmployeeService empbook;

    public CollectionsController(EmployeeService employeeService) {
        this.empbook = employeeService;
        empbook.addNewEmployee("Иван Иванович", "Иванов");
        empbook.addNewEmployee("Петр Петрович", "Петров");
        /*empbook.addNewEmployee("Сергей Иванович", "Крылов");
        empbook.addNewEmployee("Константин Сергеевич", "Агуреев");
        empbook.addNewEmployee("Павел Иванович", "Соткин");
        empbook.addNewEmployee("Александр Игоревич", "Игнатьев");
        empbook.addNewEmployee("Ильшат Тагирович", "Дулетов");
        empbook.addNewEmployee("Игорь Терентьевич", "Уральский");
        empbook.addNewEmployee("Игорь Терентьевич", "Кацурин");
        empbook.addNewEmployee("1", "2");
        empbook.addNewEmployee("3", "4");
        empbook.findEmployee("1", "2");
        empbook.findEmployee("1", "22");
        empbook.deleteEmployee("1", "2");
        empbook.deleteEmployee("1", "2");
        empbook.deleteEmployee("1", "22");*/
    }

    @GetMapping
    public String showGreetings() {
        return "Добро пожаловать в книгу сотрудников";
    }

    @GetMapping("find")
    public String findEmployee(@RequestParam(value = "firstName") String firstNameStr,
                               @RequestParam(value = "lastName") String lastNameStr) {
        try {
            empbook.findEmployee(firstNameStr, lastNameStr);
        } catch (EmployeeNotFoundException e) {
            return "Сотрудник " + lastNameStr + " " + firstNameStr + " не найден.";
        }
        return String.format("{ \"firstName\": \"%s\", \"lastName\": \"%s\" }", firstNameStr, lastNameStr);
    }

    @GetMapping("add")
    public String addEmployee(@RequestParam(value = "firstName") String firstNameStr,
                              @RequestParam(value = "lastName") String lastNameStr) {
        try {
            empbook.addNewEmployee(firstNameStr, lastNameStr);
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
            empbook.deleteEmployee(firstNameStr, lastNameStr);
        } catch (EmployeeNotFoundException e) {
            return "Сотрудник " + firstNameStr + " не найден. Удаление отменено.";
        }
        return String.format("{ \"firstName\": \"%s\", \"lastName\": \"%s\" }", firstNameStr, lastNameStr);
    }

    @GetMapping("list")
    public StringBuilder listEmployees() {
        StringBuilder jsonString = new StringBuilder("[ ");
        List<Employee> employeeStore = empbook.getListEmployees();
        for (Employee employee : employeeStore) {
            String currStrEmpl = String.format("{ \"firstName\": \"%s\", \"lastName\": \"%s }", employee.getFirstName(), employee.getLastName());
            jsonString.append(currStrEmpl).append(", ");
        }
        jsonString.append(" ]");
        return jsonString;
    }
}
