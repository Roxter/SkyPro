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

import java.util.List;

@RestController
@RequestMapping("/employee")
public class CollectionsController {
    private final EmployeeService empBook;

    public CollectionsController(EmployeeService employeeService) {
        this.empBook = employeeService;
    }

    @GetMapping
    public String showGreetings() {
        return "Добро пожаловать в книгу сотрудников";
    }

    @GetMapping("find")
    public Employee findEmployee(@RequestParam(value = "firstName") String firstNameStr,
                               @RequestParam(value = "lastName") String lastNameStr) {
        return empBook.findEmployee(firstNameStr, lastNameStr);
    }

    @GetMapping("add")
    public Employee addEmployee(@RequestParam(value = "firstName") String firstNameStr,
                              @RequestParam(value = "lastName") String lastNameStr,
                              @RequestParam(value = "deptNo") Integer deptNo,
                              @RequestParam(value = "salary") Integer salary) {
        return empBook.addNewEmployee(firstNameStr, lastNameStr, deptNo, salary);
    }

    @GetMapping("delete")
    public Employee delEmployee(@RequestParam(value = "firstName") String firstNameStr,
                              @RequestParam(value = "lastName") String lastNameStr) {
        return empBook.deleteEmployee(firstNameStr, lastNameStr);
    }

    @GetMapping("list")
    public StringBuilder listEmployees() {
        StringBuilder jsonString = new StringBuilder("[ ");
        List<Employee> employeeStore = empBook.getListEmployees();
        for (Employee employee : employeeStore) {
            if (employee != null) {
                String currStrEmp = String.format("{ \"firstName\": \"%s\", \"lastName\": \"%s }", employee.getFirstName(), employee.getLastName());
                jsonString.append(currStrEmp).append(", ");
            }
        }
        jsonString.append(" ]");
        return jsonString;
    }
}
