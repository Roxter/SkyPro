package collections;

import collections.domain.Employee;
import collections.service.DepartmentService;
import collections.service.EmployeeService;

public class Main {
    public static void main(String[] args) {
        DepartmentService departmentService = new DepartmentService(new EmployeeService());
        System.out.println(departmentService.getByDepartmentId(1));

        Employee empMin = departmentService.findMinEmplSalaryOnDep(1);
        System.out.println("Найден служащий " + empMin + " с минимальной зарплатой " + empMin.getSalary());

        Employee empMax = departmentService.findMaxEmplSalaryOnDep(1);
        System.out.println("Найден служащий " + empMax + " с максимальной зарплатой " + empMax.getSalary());

        System.out.println(departmentService.getByDepartments());
    }
}
