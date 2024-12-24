package collections.service;

import collections.domain.Employee;
import org.junit.jupiter.api.Test;

import static collections.service.EmployeeServiceTestConstants.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class EmployeeServiceTest {

    private final EmployeeService employeeService = new EmployeeService();

    @Test
    void findEmployee() {
        employeeService.addNewEmployee(FINDEDFIRSTNAME, FINDEDLASTNAME, DEPARTMENT, SALARY);

        Employee result = employeeService.findEmployee(FINDEDFIRSTNAME, FINDEDLASTNAME);
        assertThat(result.getFirstName()).isEqualTo(FINDEDFIRSTNAME);
        assertThat(result.getLastName()).isEqualTo(FINDEDLASTNAME);
    }

    @Test
    void addNewEmployee() {
    }

    @Test
    void deleteEmployee() {
    }

    @Test
    void getListEmployees() {
    }

    @Test
    void shouldFindEmployee_WhenEmployeeExist_ThenReturn() {

    }

    @Test
    void shouldAddEmployee_WhenCorrectParams_ThenAdd() {

    }

    @Test
    void findAll() {

    }

    @Test
    void shouldRemoveEmployee_WhenEmployeeNotExist_Then() {

    }

    @Test
    void shouldRemoveEmployee_WhenEmployeeExist_ThenErr() {

    }

    @Test
    void shouldAddEmployee_WhenToManyEmployee_Then() {

    }

    @Test
    void shouldAddEmployee_WhenEmployeeAlreadyAdded_() {

    }

    @Test
    void shouldFindEmployee_WhenEmployeeNotExist_Then() {

    }

    @Test
    void shouldFindAllEmployees_WhenEmptyMap_ThenReturnEmpty() {

    }
}