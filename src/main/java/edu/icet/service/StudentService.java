package edu.icet.service;

import edu.icet.dao.StudentEntity;
import edu.icet.dto.Student;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface StudentService {
    StudentEntity addStudent(Student student, MultipartFile file)throws IOException;

     List<Student> getStudent();

    Optional<StudentEntity> getStudentById(Long id);
}
