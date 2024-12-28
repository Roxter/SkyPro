package collections.service;

import collections.domain.Employee;
import collections.exceptions.EmployeeAlreadyAddedException;
import collections.exceptions.EmployeeStorageIsFullException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static collections.service.EmployeeServiceTestConstants.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_METHOD)
class EmployeeServiceTest {

    private final EmployeeService employeeService = new EmployeeService();
    private final Integer lastEmpNum = 10;

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
    void shouldAddEmployee_WhenToManyEmployee_ThenThrowException() {
        for (int i = 0; i < EmployeeService.maxEmployees; i++) {
            employeeService.addNewEmployee(FINDEDFIRSTNAME + "_" + (Integer)i, FINDEDLASTNAME + "_" + (Integer)i, DEPARTMENT + i, SALARY + i);
        }

        assertThatExceptionOfType(EmployeeStorageIsFullException.class).isThrownBy(() -> employeeService.addNewEmployee(FINDEDFIRSTNAME + "_" + lastEmpNum, FINDEDLASTNAME + "_" + lastEmpNum, DEPARTMENT + lastEmpNum, SALARY + lastEmpNum));
    }

    @Test
    void shouldAddEmployee_WhenEmployeeAlreadyAdded_() {
        employeeService.addNewEmployee(FINDEDFIRSTNAME, FINDEDLASTNAME, DEPARTMENT, SALARY);

        assertThatExceptionOfType(EmployeeAlreadyAddedException.class).isThrownBy(() -> employeeService.addNewEmployee(FINDEDFIRSTNAME, FINDEDLASTNAME, DEPARTMENT, SALARY));
    }

    @Test
    void shouldFindEmployee_WhenEmployeeExist_ThenReturn() {

    }

    @Test
    void shouldFindEmployee_WhenEmployeeNotExist_Then() {

    }

    @Test
    void shouldFindAllEmployees_WhenEmptyMap_ThenReturnEmpty() {

    }
}