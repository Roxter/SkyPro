package ru.hogwarts.school.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import ru.hogwarts.school.mapper.FacultyMapper;
import ru.hogwarts.school.mapper.StudentMapper;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repository.StudentRepository;
import ru.hogwarts.school.service.StudentService;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

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
    private StudentRepository studentRepository;

    @SpyBean
    private StudentService studentService;

    @SpyBean
    private StudentMapper studentMapper;

    @Autowired
    private ObjectMapper objectMapper;

    @SpyBean
    private FacultyMapper facultyMapper;

    @Test
    public void getStudentByIdTest() throws Exception {
        Long id = 1L;
        String name = "Harry Potter";
        int age = 12;

        Student student = new Student(id, name, age);

        when(studentRepository.findById(id)).thenReturn(Optional.of(student));

        mockMvc.perform(get("/student/{id}", id))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.id").value(id))
            .andExpect(jsonPath("$.name").value(name))
            .andExpect(jsonPath("$.age").value(age));
    }

    @Test
    public void getStudentNotFoundTest() throws Exception {
        Long id = 1L;

        when(studentRepository.findById(id)).thenReturn(Optional.empty());

        mockMvc.perform(get("/student/{id}", 1L))
            .andExpect(status().isNotFound());
    }

    @Test
    public void createStudentTest() throws Exception {
        Long id = 1L;
        String name = "Ron Weasley";
        int age = 12;

        Student studentRequest = new Student(0L, name, age);
        Student studentSavedInDb = new Student(id, name, age);

        when(studentRepository.save(any(Student.class))).thenReturn(studentSavedInDb);

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

        when(studentRepository.existsById(id)).thenReturn(true);
        when(studentRepository.save(any(Student.class))).thenReturn(studentRequest);

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
        when(studentRepository.existsById(id)).thenReturn(true);

        mockMvc.perform(delete("/student/{id}", id))
            .andExpect(status().isNoContent());
    }

    @Test
    public void deleteStudentNotFoundTest() throws Exception {
        Long id = 1L;
        when(studentRepository.existsById(id)).thenReturn(false);

        mockMvc.perform(delete("/student/{id}", id))
            .andExpect(status().isNotFound());
    }

    @Test
    public void getStudentsByAgeRangeTest() throws Exception {
        int min = 10;
        int max = 15;

        Student student = new Student(1L, "Harry", 12);
        List<Student> students = Collections.singletonList(student);

        when(studentRepository.findStudentsByAgeBetween(min, max)).thenReturn(students);

        mockMvc.perform(get("/student")
            .param("min", String.valueOf(min))
            .param("max", String.valueOf(max)))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$[0].name").value("Harry"))
            .andExpect(jsonPath("$[0].age").value(12));
    }
}