package ru.hogwarts.school;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.hogwarts.school.controller.FacultyController;
import ru.hogwarts.school.controller.StudentController;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class HogwartsApplicationTest {

    @Autowired
    private FacultyController facultyController;

    @Autowired
    private StudentController studentController;

    @Test
    void contextLoads() throws Exception {
        assertThat(facultyController).isNotNull();
        assertThat(studentController).isNotNull();
    }
}
