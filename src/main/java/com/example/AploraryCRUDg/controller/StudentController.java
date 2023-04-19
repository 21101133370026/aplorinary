package com.example.AploraryCRUDg.controller;

import com.example.AploraryCRUDg.entity.StudentEntity;
import com.example.AploraryCRUDg.exception.StudentNotFoundException;
import com.example.AploraryCRUDg.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student_Info")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    //code for getting all students info
    @GetMapping
    public List<StudentEntity> getAllStudent(){
        return studentRepository.findAll();
    }

    //code for creating student
    @PostMapping
    public StudentEntity createStudent(@RequestBody StudentEntity studentEntity){
        return studentRepository.save(studentEntity);
    }
    //code for getting student by id
    @GetMapping("{id}")
    public ResponseEntity<StudentEntity> getStudentByid(@PathVariable long id){
        StudentEntity studentEntity = studentRepository.findById(id)
                .orElseThrow(()->new StudentNotFoundException("Student not found"));

        return ResponseEntity.ok(studentEntity);
    }

    //code for updating
    @PutMapping("{id}")
    public ResponseEntity<StudentEntity> updateStudent(@PathVariable long id, @RequestBody StudentEntity studentEntityDetails){
        StudentEntity updateStudent = studentRepository.findById(id)
                .orElseThrow(()->new StudentNotFoundException("Student Not found"));

        updateStudent.setRegNo(studentEntityDetails.getRegNo());
        updateStudent.setFirstName(studentEntityDetails.getFirstName());
        updateStudent.setMiddleName(studentEntityDetails.getMiddleName());
        updateStudent.setLastName(studentEntityDetails.getLastName());
        updateStudent.setPhoneNo(studentEntityDetails.getPhoneNo());
        updateStudent.setAddress(studentEntityDetails.getAddress());
        updateStudent.setCourse(studentEntityDetails.getCourse());
        updateStudent.setDepartment(studentEntityDetails.getDepartment());
        updateStudent.setAcademicYear(studentEntityDetails.getAcademicYear());
        studentRepository.save(updateStudent);

        return ResponseEntity.ok(updateStudent);
    }

    //code for deleting
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteStudent(@PathVariable long id){
        StudentEntity student = studentRepository.findById(id)
                .orElseThrow(()->new StudentNotFoundException("Studnet not found"));
        studentRepository.delete(student);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
