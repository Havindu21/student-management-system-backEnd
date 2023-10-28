package edu.icet.controller;

import edu.icet.dao.StudentEntity;
import edu.icet.dto.Student;
import edu.icet.service.StudentService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@Slf4j
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService service;

    @PostMapping
    public ResponseEntity<StudentEntity> addStudent(@Valid @ModelAttribute Student student, @RequestPart("file") MultipartFile file) throws IOException {
        return new ResponseEntity<>(service.addStudent(student, file), HttpStatus.CREATED);
    }

    @GetMapping
    public List<Student> getStudent() {
        return service.getStudent();
    }

    @GetMapping("/{id}")
    public Optional<StudentEntity> getStudentById(@PathVariable Long id) {
        return service.getStudentById(id);
    }
}
