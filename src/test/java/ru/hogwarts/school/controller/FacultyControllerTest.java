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
import ru.hogwarts.school.model.Faculty;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class FacultyControllerTest {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testGetFaculty() throws Exception {
        Faculty faculty = new Faculty();
        faculty.setName("Ravenclaw");
        faculty.setColor("Blue");
        String url = "http://localhost:" + port + "/faculty";

        Faculty createdFaculty = restTemplate.postForObject(url, faculty, Faculty.class);
        long acceptedId = createdFaculty.getId();

        url = "http://localhost:" + port + "/faculty/" + acceptedId;
        Faculty actual = this.restTemplate.getForObject(url, Faculty.class);

        assertThat(actual.getId())
            .isEqualTo(acceptedId);
        assertThat(actual.getName())
            .isEqualTo("Ravenclaw");
        assertThat(actual.getColor())
            .isEqualTo("Blue");
    }

    @Test
    public void testGetFacultyNotFound() {
        String url = "http://localhost:" + port + "/faculty/-1";
        ResponseEntity<String> responseEntity = this.restTemplate.getForEntity(url, String.class);

        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    }

    @Test
    public void testUpdateFaculty() {
        Faculty faculty = new Faculty();
        faculty.setName("HufflePuff");
        faculty.setColor("Yellow");
        String url = "http://localhost:" + port + "/faculty";

        Faculty createdFaculty = restTemplate.postForObject(url, faculty, Faculty.class);
        long acceptedId = createdFaculty.getId();
        createdFaculty.setColor("BlackAndYellow");
        HttpEntity<Faculty> requestEntity = new HttpEntity<>(createdFaculty);

        ResponseEntity<Faculty> response = restTemplate.exchange(
            url,
            HttpMethod.PUT,
            requestEntity,
            Faculty.class
        );

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

        Faculty updatedFaculty = response.getBody();
        assertThat(updatedFaculty.getColor()).isEqualTo("BlackAndYellow");
        assertThat(updatedFaculty.getId()).isEqualTo(acceptedId);
    }

    @Test
    public void testDeleteFaculty() {
        Faculty faculty = new Faculty();
        faculty.setName("DarkArts");
        faculty.setColor("Black");
        String url = "http://localhost:" + port + "/faculty";

        Faculty createdFaculty = restTemplate.postForObject(url, faculty, Faculty.class);
        long acceptedId = createdFaculty.getId();

        restTemplate.delete(url + "/" + acceptedId);

        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url + "/" + acceptedId, String.class);

        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    }

    @Test
    public void testFindFacultyByName() {
        Faculty faculty = new Faculty();
        String nameForFoundFaculty = "FoundedFaculty";
        faculty.setName(nameForFoundFaculty);
        faculty.setColor("Gold");
        String postUrl = "http://localhost:" + port + "/faculty";

        Faculty createdFaculty = restTemplate.postForObject(postUrl, faculty, Faculty.class);
        long acceptedId = createdFaculty.getId();

        String searchUrl = postUrl + "?search=" + nameForFoundFaculty;

        Faculty[] searchResult = restTemplate.getForObject(searchUrl, Faculty[].class);

        assertThat(searchResult).isNotNull();
        assertThat(searchResult).isNotEmpty();
        assertThat(searchResult[0].getName()).isEqualTo(nameForFoundFaculty);
    }

    @Test
    public void testGetAllFaculties() throws Exception {
        Faculty faculty = new Faculty();
        faculty.setName("TestFaculty");
        faculty.setColor("TestColor");

        String url = "http://localhost:" + port + "/faculty";
        Faculty createdFaculty = restTemplate.postForObject(url, faculty, Faculty.class);
        long acceptedId = createdFaculty.getId();

        String getAllUrl = "http://localhost:" + port + "/faculty";
        String response = restTemplate.getForObject(getAllUrl, String.class);

        assertThat(response).isNotNull();
        assertThat(response).contains("TestFaculty");
        restTemplate.delete(url + "/" + acceptedId);
    }

    @Test
    public void testFacultyModel() throws Exception {
        Faculty faculty = new Faculty();
        faculty.setName("Slytherin");
        faculty.setColor("Green");

        assertThat(this.restTemplate.postForObject("http://localhost:" + port + "/faculty", faculty, String.class))
            .isNotNull();
    }
}