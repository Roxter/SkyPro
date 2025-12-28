package ru.hogwarts.school.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.service.StudentService;

import java.util.Collections;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(StudentController.class)
public class StudentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StudentService studentService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void getStudentByIdTest() throws Exception {
        Long id = 1L;
        String name = "Harry Potter";
        int age = 12;

        Student student = new Student(id, name, age);

        when(studentService.findById(id)).thenReturn(student);

        mockMvc.perform(get("/student/{id}", id))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.id").value(id))
            .andExpect(jsonPath("$.name").value(name))
            .andExpect(jsonPath("$.age").value(age));
    }

    @Test
    public void getStudentNotFoundTest() throws Exception {
        when(studentService.findById(any(Long.class))).thenReturn(null);

        mockMvc.perform(get("/student/{id}", 1L))
            .andExpect(status().isNotFound());
    }

    @Test
    public void createStudentTest() throws Exception {
        Long id = 1L;
        String name = "Ron Weasley";
        int age = 12;

        Student studentRequest = new Student(0L, name, age);
        Student studentResponse = new Student(id, name, age);

        when(studentService.createStudent(any(Student.class))).thenReturn(studentResponse);

        mockMvc.perform(post("/student")
            .content(objectMapper.writeValueAsString(studentRequest))
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.id").value(id))
            .andExpect(jsonPath("$.name").value(name))
            .andExpect(jsonPath("$.age").value(age));
    }

    @Test
    public void updateStudentTest() throws Exception {
        Long id = 1L;
        String name = "Hermione Granger";
        int age = 13;

        Student studentRequest = new Student(id, name, age);

        when(studentService.updateStudent(any(Student.class))).thenReturn(studentRequest);

        mockMvc.perform(put("/student")
            .content(objectMapper.writeValueAsString(studentRequest))
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.id").value(id))
            .andExpect(jsonPath("$.name").value(name))
            .andExpect(jsonPath("$.age").value(age));
    }

    @Test
    public void deleteStudentTest() throws Exception {
        Long id = 1L;
        when(studentService.deleteById(id)).thenReturn(true);

        mockMvc.perform(delete("/student/{id}", id))
            .andExpect(status().isNoContent());
    }

    @Test
    public void deleteStudentNotFoundTest() throws Exception {
        Long id = 1L;
        when(studentService.deleteById(id)).thenReturn(false);

        mockMvc.perform(delete("/student/{id}", id))
            .andExpect(status().isNotFound());
    }

    @Test
    public void getStudentsByAgeRangeTest() throws Exception {
        int min = 10;
        int max = 15;

        Student student = new Student(1L, "Harry", 12);
        List<Student> students = Collections.singletonList(student);

        when(studentService.findByAgeBetween(min, max)).thenReturn(students);

        mockMvc.perform(get("/student")
            .param("min", String.valueOf(min))
            .param("max", String.valueOf(max)))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$[0].name").value("Harry"))
            .andExpect(jsonPath("$[0].age").value(12));
    }
}