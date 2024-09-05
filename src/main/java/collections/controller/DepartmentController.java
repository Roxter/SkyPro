package collections.controller;

import collections.domain.Employee;
import collections.service.DepartmentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    private final DepartmentService depBook;

    public DepartmentController(DepartmentService depBook) {
        this.depBook = depBook;
    }

    @GetMapping
    public String showGreetings() {
        return "Добро пожаловать в книгу сотрудников и департаметов";
    }

    @GetMapping("/min-salary")
    public String getMinSalary(@RequestParam(value = "departmentId") Integer departmentId) {
        Employee empMin = depBook.findMinEmplSalaryOnDep(departmentId);
        return "Найден служащий " + empMin.toString() + " с минимальной зарплатой " + empMin.getSalary();
    }

    @GetMapping("/max-salary")
    public String getMaxSalary(@RequestParam(value = "departmentId") Integer departmentId) {
        Employee empMax = depBook.findMaxEmplSalaryOnDep(departmentId);
        return "Найден служащий " + empMax.toString() + " с максимальной зарплатой " + empMax.getSalary();
    }

    @GetMapping("/all")
    public String getAllDepartmentsByDep(@RequestParam(value = "departmentId") Integer departmentId) {
        return "Список всех сотрудников департамента № " + departmentId + ":<br/>" + depBook.getByDepartmentId(departmentId);
    }

    @GetMapping("/all/")
    public String getAllDepartments() {
        return "Отсортированный список всех сотрудников департамента по номерам департаментов:" + ":<br/><br/>" + depBook.getByDepartments();
    }
}
