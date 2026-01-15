package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.hogwarts.school.dto.StudentDTO;
import ru.hogwarts.school.mapper.StudentMapper;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.repository.FacultyRepository;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;

@Service
public class FacultyService {

    private final FacultyRepository facultyRepository;
    private final StudentMapper studentMapper;

    public FacultyService(FacultyRepository facultyRepository, StudentMapper studentMapper) {
        this.facultyRepository = facultyRepository;
        this.studentMapper = studentMapper;
    }

    public Faculty createFaculty(Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    public Faculty findById(Long id) {
        return facultyRepository.findById(id).orElse(null);
    }

    public Faculty updateFaculty(Faculty faculty) {
        if (facultyRepository.existsById(faculty.getId())) {
            return facultyRepository.save(faculty);
        }
        return null;
    }

    public boolean deleteById(Long id) {
        if (facultyRepository.existsById(id)) {
            facultyRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Collection<Faculty> findByNameAndColor(String searchstring) {
        return facultyRepository.findByNameIgnoreCaseOrColorIgnoreCase(searchstring, searchstring);
    }

    @Transactional
    public Collection<StudentDTO> findStudentsByFacultyId(Long facultyId) {
        return facultyRepository.findById(facultyId)
            .map(Faculty::getStudents)
            .map(students -> students.stream()
                .map(studentMapper::toDto)
                .collect(Collectors.toList()))
            .orElse(Collections.emptyList());
    }

    public Collection<Faculty> findAllFaculties() {
        return facultyRepository.findAll();
    }

    public String getLongestFacultyName() {
        return facultyRepository.findAll().stream()
            .map(Faculty::getName)
            .max(Comparator.comparingInt(String::length))
            .orElse(null);
    }
}