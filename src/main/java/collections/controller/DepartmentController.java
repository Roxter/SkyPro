package collections.controller;

import collections.domain.Employee;
import collections.service.DepartmentService;
import org.springframework.web.bind.annotation.*;

@RestController
/*@RequestMapping("/departments")
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

    @GetMapping(path = "/all", params = "departmentId")
    public String getAllDepartmentsByDep(@RequestParam(value = "departmentId") Integer departmentId) {
        return "Список всех сотрудников департамента № " + departmentId + ":<br/>" + depBook.getByDepartmentId(departmentId);
    }

    @GetMapping("/all/")
    public String getAllDepartments() {
        return "Отсортированный список всех сотрудников департамента по номерам департаментов:" + ":<br/><br/>" + depBook.getByDepartments();
    }*/

@RequestMapping("/department")
public class DepartmentController {
    private final DepartmentService depBook;

    public DepartmentController(DepartmentService depBook) {
        this.depBook = depBook;
    }

    @GetMapping
    public String showGreetings() {
        return "Добро пожаловать в книгу сотрудников и департаметов";
    }

    @GetMapping("/{id}/salary/min")
    public String getMinSalary(@PathVariable Integer id) {
        Employee empMin = depBook.findMinEmplSalaryOnDep(id);
        return "Найден служащий " + empMin.toString() + " с минимальной зарплатой " + empMin.getSalary();
    }

    @GetMapping("/{id}/salary/max")
    public String getMaxSalary(@PathVariable Integer id) {
        Employee empMax = depBook.findMaxEmplSalaryOnDep(id);
        return "Найден служащий " + empMax.toString() + " с максимальной зарплатой " + empMax.getSalary();
    }

    @GetMapping("/{id}/salary/sum")
    public String getSumSalary(@PathVariable Integer id) {
        Double empSum = depBook.findSumEmplSalaryOnDep(id);
        return "Сумма зарплат всех служищих департамента " + id + " равна: " + empSum;
    }

    @GetMapping(path = "/{id}/employees")
    public String getAllDepartmentsByDep(@PathVariable Integer id) {
        return "Список всех сотрудников департамента № " + id + ":<br/>" + depBook.getByDepartmentId(id);
    }

    @GetMapping("/employees/")
    public String getAllDepartments() {
        return "Отсортированный список всех сотрудников департамента по номерам департаментов:" + ":<br/><br/>" + depBook.getByDepartments();
    }
}
