package ru.hogwarts.school.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.hogwarts.school.dto.StudentDTO;
import ru.hogwarts.school.mapper.StudentMapper;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.repository.FacultyRepository;

import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

@Service
public class FacultyService {

    private static final Logger logger = LoggerFactory.getLogger(FacultyService.class);

    private final FacultyRepository facultyRepository;
    private final StudentMapper studentMapper;

    public FacultyService(FacultyRepository facultyRepository, StudentMapper studentMapper) {
        this.facultyRepository = facultyRepository;
        this.studentMapper = studentMapper;
    }

    public Faculty createFaculty(Faculty faculty) {
        logger.info("Was invoked method for create faculty");
        return facultyRepository.save(faculty);
    }

    public Faculty findById(Long id) {
        logger.info("Was invoked method for find faculty by id: {}", id);
        return facultyRepository.findById(id).orElseGet(() -> {
            logger.warn("There is not faculty with id = " + id);
            return null;
        });
    }

    public Faculty updateFaculty(Faculty faculty) {
        logger.info("Was invoked method for update faculty");
        if (facultyRepository.existsById(faculty.getId())) {
            return facultyRepository.save(faculty);
        }
        logger.error("There is not faculty with id = " + faculty.getId());
        return null;
    }

    public boolean deleteById(Long id) {
        logger.info("Was invoked method for delete faculty by id: {}", id);
        if (facultyRepository.existsById(id)) {
            facultyRepository.deleteById(id);
            return true;
        }
        logger.error("There is not faculty with id = " + id);
        return false;
    }

    public Collection<Faculty> findByNameAndColor(String searchString) {
        logger.info("Was invoked method for find faculty by name or color: {}", searchString);
        return facultyRepository.findByNameIgnoreCaseOrColorIgnoreCase(searchString, searchString);
    }

    @Transactional
    public Collection<StudentDTO> findStudentsByFacultyId(Long facultyId) {
        logger.info("Was invoked method for find students by faculty id: {}", facultyId);
        return facultyRepository.findById(facultyId)
            .map(Faculty::getStudents)
            .map(students -> students.stream()
                .map(studentMapper::toDto)
                .collect(Collectors.toList()))
            .orElseGet(() -> {
                logger.warn("Faculty with id = " + facultyId + " not found");
                return Collections.emptyList();
            });
    }

    public Collection<Faculty> findAllFaculties() {
        logger.info("Was invoked method for find all faculties");
        return facultyRepository.findAll();
    }
}