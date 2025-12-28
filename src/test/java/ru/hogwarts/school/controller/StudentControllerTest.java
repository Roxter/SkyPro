package ru.hogwarts.school.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import ru.hogwarts.school.model.Student;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class StudentControllerTest {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testGetStudent() throws Exception {
        Student student = new Student();
        student.setName("Petrov");
        student.setAge(23);
        String url = "http://localhost:" + port + "/student";

        Student createdStudent = restTemplate.postForObject(url, student, Student.class);
        long acceptedId = createdStudent.getId();

        url = "http://localhost:" + port + "/student/" + acceptedId;
        Student actual = this.restTemplate.getForObject(url, Student.class);

        assertThat(actual.getId()).isEqualTo(acceptedId);
        assertThat(actual.getName()).isEqualTo("Petrov");
        assertThat(actual.getAge()).isEqualTo(23);
    }

    @Test
    public void testGetStudentNotFound() {
        String url = "http://localhost:" + port + "/student/-1";
        ResponseEntity<String> responseEntity = this.restTemplate.getForEntity(url, String.class);

        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    }

    @Test
    public void testUpdateStudent() {
        Student student = new Student();
        student.setName("Petrov");
        student.setAge(33);
        String url = "http://localhost:" + port + "/student";

        Student createdStudent = restTemplate.postForObject(url, student, Student.class);
        long acceptedId = createdStudent.getId();
        createdStudent.setAge(23);
        HttpEntity<Student> requestEntity = new HttpEntity<>(createdStudent);

        ResponseEntity<Student> response = restTemplate.exchange(
            url,
            HttpMethod.PUT,
            requestEntity,
            Student.class
        );

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

        Student updatedStudent = response.getBody();
        assertThat(updatedStudent.getAge()).isEqualTo(23);
        assertThat(updatedStudent.getId()).isEqualTo(acceptedId);
    }

    @Test
    public void testDeleteStudent() {
        Student student = new Student();
        student.setName("Darkula");
        student.setAge(26);
        String url = "http://localhost:" + port + "/student";

        Student createdStudent = restTemplate.postForObject(url, student, Student.class);
        long acceptedId = createdStudent.getId();

        restTemplate.delete(url + "/" + acceptedId);

        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url + "/" + acceptedId, String.class);

        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    }

    @Test
    public void testFindStudentByName() {
        Student student = new Student();
        String nameForFoundStudent = "Harry Potter";
        student.setName(nameForFoundStudent);
        student.setAge(18);
        String postUrl = "http://localhost:" + port + "/student";

        Student createdStudent = restTemplate.postForObject(postUrl, student, Student.class);
        long acceptedId = createdStudent.getId();

        int minSearchAge = 16;
        int maxSearchAge = 20;
        String searchUrl = postUrl + "?min=" + minSearchAge + "&max=" + maxSearchAge;

        Student[] searchResult = restTemplate.getForObject(searchUrl, Student[].class);

        assertThat(searchResult).isNotNull();
        assertThat(searchResult).isNotEmpty();
        assertThat(searchResult).extracting(Student::getName).contains(nameForFoundStudent);
    }
}