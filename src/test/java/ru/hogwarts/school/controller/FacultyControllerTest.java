package ru.hogwarts.school.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.service.FacultyService;

import java.util.Collections;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(FacultyController.class)
public class FacultyControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FacultyService facultyService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void getFacultyByIdTest() throws Exception {
        Long id = 1L;
        String name = "Gryffindor";
        String color = "Red";

        Faculty faculty = new Faculty(id, name, color);

        when(facultyService.findById(id)).thenReturn(faculty);

        mockMvc.perform(get("/faculty/{id}", id))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.id").value(id))
            .andExpect(jsonPath("$.name").value(name))
            .andExpect(jsonPath("$.color").value(color));
    }

    @Test
    public void getFacultyNotFoundTest() throws Exception {
        when(facultyService.findById(any(Long.class))).thenReturn(null);

        mockMvc.perform(get("/faculty/{id}", 1L))
            .andExpect(status().isNotFound());
    }

    @Test
    public void createFacultyTest() throws Exception {
        Long id = 1L;
        String name = "Slytherin";
        String color = "Green";

        Faculty facultyRequest = new Faculty(0, name, color);
        Faculty facultyResponse = new Faculty(id, name, color);

        when(facultyService.createFaculty(any(Faculty.class))).thenReturn(facultyResponse);

        mockMvc.perform(post("/faculty")
            .content(objectMapper.writeValueAsString(facultyRequest))
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.id").value(id))
            .andExpect(jsonPath("$.name").value(name))
            .andExpect(jsonPath("$.color").value(color));
    }

    @Test
    public void updateFacultyTest() throws Exception {
        Long id = 1L;
        String name = "Ravenclaw";
        String color = "Blue";

        Faculty faculty = new Faculty(id, name, color);

        when(facultyService.updateFaculty(any(Faculty.class))).thenReturn(faculty);

        mockMvc.perform(put("/faculty")
            .content(objectMapper.writeValueAsString(faculty))
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.id").value(id))
            .andExpect(jsonPath("$.name").value(name))
            .andExpect(jsonPath("$.color").value(color));
    }

    @Test
    public void deleteFacultyTest() throws Exception {
        Long id = 1L;
        when(facultyService.deleteById(id)).thenReturn(true);

        mockMvc.perform(delete("/faculty/{id}", id))
            .andExpect(status().isNoContent());
    }

    @Test
    public void findFacultiesByColorOrNameTest() throws Exception {
        String search = "Red";
        Faculty faculty = new Faculty(1L, "Gryffindor", "Red");
        List<Faculty> faculties = Collections.singletonList(faculty);

        when(facultyService.findByNameAndColor(search)).thenReturn(faculties);

        mockMvc.perform(get("/faculty")
            .param("search", search))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$[0].name").value("Gryffindor"))
            .andExpect(jsonPath("$[0].color").value("Red"));
    }
}