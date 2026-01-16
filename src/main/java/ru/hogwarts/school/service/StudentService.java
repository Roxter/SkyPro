package ru.hogwarts.school.service;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.dto.FacultyDTO;
import ru.hogwarts.school.dto.StudentDTO;
import ru.hogwarts.school.mapper.FacultyMapper;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repository.StudentRepository;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.*;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final FacultyMapper facultyMapper;

    public StudentService(StudentRepository studentRepository, FacultyMapper facultyMapper) {
        this.studentRepository = studentRepository;
        this.facultyMapper = facultyMapper;
    }

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student findById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    public Student updateStudent(Student student) {
        if (studentRepository.existsById(student.getId())) {
            return studentRepository.save(student);
        }
        return null;
    }

    public boolean deleteById(Long id) {
        if (studentRepository.existsById(id)) {
            studentRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Collection<Student> findByAgeBetween(Integer min, Integer max) {
        return studentRepository.findStudentsByAgeBetween(min, max);
    }


    @Transactional
    public FacultyDTO findFacultyByStudentId(Long studentId) {
        return studentRepository.findById(studentId)
            .map(Student::getFaculty)
            .map(facultyMapper::toDto)
            .orElse(null);
    }

    public Integer getStudentCount() {
        return studentRepository.getCountOfStudents();
    }

    public Double getAverageAge() {
        Double avg = studentRepository.getAverageAgeOfStudents();
        return avg != null ? avg : 0.0;
    }

    public Collection<Student> getLastFiveStudents() {
        return studentRepository.getLastFiveStudents();
    }

    public Collection<String> getAllStudentsByNamesStartingWithA() {
        return studentRepository.findAll().stream()
            .map(Student::getName)
            .map(String::toUpperCase)
            .filter(name -> name.startsWith("A"))
            .sorted()
            .collect(Collectors.toList());
    }

    public Double getAverageAgeByStream() {
        return studentRepository.findAll().stream()
            .mapToInt(Student::getAge)
            .average()
            .orElse(0.0);
    }

    public Collection<Student> findAll() {
        return studentRepository.findAll();
    }
}