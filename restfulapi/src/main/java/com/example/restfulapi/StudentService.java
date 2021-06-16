package com.example.restfulapi;

import com.sun.tools.javac.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private String yyyy;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
        return (List<Student>) studentRepository.findAll();

    }
     public void addStudent(Student student) {
        Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());
        if(studentOptional.isPresent()) {
            throw new IllegalStateException("Email already in use");
        }
        studentRepository.save(student);

    }
         public void deleteStudent(Long studentId) {
            boolean exists = studentRepository.existsById(studentId);
            if(!exists) {
                throw new IllegalStateException("Student with id not found");
            }
            studentRepository.deleteById(studentId);
        }

    @Transactional
    public <Studnet> void updateStudent(Long studentId,String name,String email,LocalDate dob) {
        Student studentToUpdate = studentRepository.findById(studentId).orElseThrow(() -> new IllegalStateException("Student not found"));
        if(name != null && name.length() > 0 && !Objects.equals(studentToUpdate.getName(), name) ) {
            studentToUpdate.setName(name);
            System.out.println("Name did update");
        }
        if (email != null && !Objects.equals(studentToUpdate.getEmail(), email)) {
            Optional<Studnet> studentOptional = (Optional<Studnet>) studentRepository.findStudentByEmail(email);
            if (studentOptional.isPresent()) {
                throw new IllegalStateException("Email in use");
            }
            studentToUpdate.setEmail(email);
        }

    }

   /*
    public void updateStudent(@PathVariable("studentId") Long studentId,
                             @RequestParam(required = false) String name,
                             @RequestParam(required = false) String email,
                             @RequestParam(required = false) @DateTimeFormat
                                     (pattern = yyyy-MM-dd) LocalDate dob) {

    }*/


}
