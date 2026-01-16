package ru.hogwarts.school.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.dto.FacultyDTO;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.service.StudentService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("{id}")
    public ResponseEntity<Student> getStudentInfo(@PathVariable Long id) {
        Student student = studentService.findById(id);
        if (student == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(student);
    }

    @GetMapping
    public ResponseEntity<Collection<Student>> getStudentsByAgeRange(@RequestParam int min, @RequestParam int max) {
        if (min > max || min < 0) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(studentService.findByAgeBetween(min, max));
    }

    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
    }

    @PutMapping()
    public ResponseEntity<Student> updateFaculty(@RequestBody Student student) {
        Student foundStudent = studentService.updateStudent(student);
        if (foundStudent == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(foundStudent);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        if (studentService.deleteById(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}/faculty")
    public ResponseEntity<FacultyDTO> getFacultyByStudent(@PathVariable Long id) {
        FacultyDTO facultyDto = studentService.findFacultyByStudentId(id);
        if (facultyDto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(facultyDto);
    }

    @GetMapping("/count")
    public Integer getStudentCount() {
        return studentService.getStudentCount();
    }

    @GetMapping("/average-age")
    public Double getAverageAge() {
        return studentService.getAverageAge();
    }

    @GetMapping("/last-five")
    public Collection<Student> getLastFiveStudents() {
        return studentService.getLastFiveStudents();
    }

    @GetMapping("/filter-by-name")
    public ResponseEntity<Collection<String>> getAllStudentsByNamesStartingWithA() {
        return ResponseEntity.ok(studentService.getAllStudentsByNamesStartingWithA());
    }

    @GetMapping("/avg-age-stream")
    public Double getAverageAgeByStream() {
        return studentService.getAverageAgeByStream();
    }

    @GetMapping("/print-parallel")
    public void printParallel() {
        List<Student> students = new ArrayList<>(studentService.findAll());

        if (students.size() < 6) {
            System.out.println("В базе мало студентов! Нужно минимум 6.");
            return;
        }

        System.out.println("Main Thread: " + students.get(0).getName());
        System.out.println("Main Thread: " + students.get(1).getName());

        new Thread(() -> {
            System.out.println("Thread-1: " + students.get(2).getName());
            System.out.println("Thread-1: " + students.get(3).getName());
        }).start();

        new Thread(() -> {
            System.out.println("Thread-2: " + students.get(4).getName());
            System.out.println("Thread-2: " + students.get(5).getName());
        }).start();
    }

    @GetMapping("/print-synchronized")
    public void printSynchronized() {
        List<Student> students = new ArrayList<>(studentService.findAll());

        if (students.size() < 6) {
            System.out.println("В базе мало студентов! Нужно минимум 6.");
            return;
        }

        printNameSynchronized(students.get(0).getName());
        printNameSynchronized(students.get(1).getName());

        new Thread(() -> {
            printNameSynchronized(students.get(2).getName());
            printNameSynchronized(students.get(3).getName());
        }).start();

        new Thread(() -> {
            printNameSynchronized(students.get(4).getName());
            printNameSynchronized(students.get(5).getName());
        }).start();
    }

    private synchronized void printNameSynchronized(String name) {
        System.out.println(name);
    }
}