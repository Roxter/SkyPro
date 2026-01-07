package ru.hogwarts.school.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.hogwarts.school.dto.FacultyDTO;
import ru.hogwarts.school.mapper.FacultyMapper;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repository.StudentRepository;

import java.util.Collection;

@Service
public class StudentService {

    private static final Logger logger = LoggerFactory.getLogger(StudentService.class);

    private final StudentRepository studentRepository;
    private final FacultyMapper facultyMapper;

    public StudentService(StudentRepository studentRepository, FacultyMapper facultyMapper) {
        this.studentRepository = studentRepository;
        this.facultyMapper = facultyMapper;
    }

    public Student createStudent(Student student) {
        logger.info("Was invoked method for create student");
        return studentRepository.save(student);
    }

    public Student findById(Long id) {
        logger.info("Was invoked method for find student by id: {}", id);
        return studentRepository.findById(id).orElseGet(() -> {
            logger.warn("There is not student with id = " + id);
            return null;
        });
    }

    public Student updateStudent(Student student) {
        logger.info("Was invoked method for update student");
        if (studentRepository.existsById(student.getId())) {
            return studentRepository.save(student);
        }
        logger.error("There is not student with id = " + student.getId());
        return null;
    }

    public boolean deleteById(Long id) {
        logger.info("Was invoked method for delete student by id: {}", id);
        if (studentRepository.existsById(id)) {
            studentRepository.deleteById(id);
            return true;
        }
        logger.error("There is not student with id = " + id);
        return false;
    }

    public Collection<Student> findByAgeBetween(Integer min, Integer max) {
        logger.info("Was invoked method for find students by age between {} and {}", min, max);
        return studentRepository.findStudentsByAgeBetween(min, max);
    }

    @Transactional
    public FacultyDTO findFacultyByStudentId(Long studentId) {
        logger.info("Was invoked method for find faculty by student id: {}", studentId);
        return studentRepository.findById(studentId)
            .map(Student::getFaculty)
            .map(facultyMapper::toDto)
            .orElseGet(() -> {
                logger.warn("Student with id = " + studentId + " not found");
                return null;
            });
    }

    public Integer getStudentCount() {
        logger.info("Was invoked method for get student count");
        return studentRepository.getCountOfStudents();
    }

    public Double getAverageAge() {
        logger.info("Was invoked method for get average age");
        Double avg = studentRepository.getAverageAgeOfStudents();
        return avg != null ? avg : 0.0;
    }

    public Collection<Student> getLastFiveStudents() {
        logger.info("Was invoked method for get last five students");
        return studentRepository.getLastFiveStudents();
    }
}