package edu.icet.service;

import edu.icet.dao.StudentEntity;
import edu.icet.dto.Student;
import edu.icet.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;
    private  final String Folder_PATH="D:/icm103/projects/Front End/images/";


    public StudentEntity addStudent(Student student, MultipartFile file)throws IOException {
        String filePath = Folder_PATH + file.getOriginalFilename();
        StudentEntity model = new StudentEntity();
        model.setFirstName(student.getFirstName());
        model.setLastName(student.getLastName());
        model.setNic(student.getNic());
        model.setEmailAddress(student.getEmailAddress());
        model.setContactNo(student.getContactNo());
        model.setCity(student.getCity());
        model.setBirthday(student.getBirthday());
        model.setCourse(student.getCourse());
        model.setGender(student.getGender());
        model.setImageName(file.getOriginalFilename());
        model.setImagePath(filePath);
        StudentEntity entity = studentRepository.save(model);
        file.transferTo(new File(filePath));
        return entity;
    }
    public List<Student> getStudent(){
        Iterable<StudentEntity> informationList = studentRepository.findAll();
        Iterator<StudentEntity> iterator = informationList.iterator();
        List<Student> studentModels = new ArrayList<>();

        while (iterator.hasNext()){
            StudentEntity entity = iterator.next();

            studentModels.add(Student.builder()
                    .id(entity.getId())
                    .firstName(entity.getFirstName())
                    .lastName(entity.getLastName())
                    .nic(entity.getNic())
                    .emailAddress(entity.getEmailAddress())
                    .contactNo(entity.getContactNo())
                    .city(entity.getCity())
                    .birthday(entity.getBirthday())
                    .course(entity.getCourse())
                    .gender(entity.getGender())
                    .imageName(entity.getImageName())
                    .imagePath(entity.getImagePath())
                    .build());
        }
        return studentModels;
    }

    public Optional<StudentEntity> getStudentById(Long id){
        return studentRepository.findById(id);
    }

}