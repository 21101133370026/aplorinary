package com.example.AploraryCRUDg;

import com.example.AploraryCRUDg.entity.StudentEntity;
import com.example.AploraryCRUDg.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AploraryCruDgApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(AploraryCruDgApplication.class, args);
	}

	@Autowired
	private StudentRepository studentRepository;

	@Override
	public void run(String... args) throws Exception {
		StudentEntity studentEntity = new StudentEntity();
		studentEntity.setRegNo("21101133370027");
		studentEntity.setFirstName("Apolinary");
		studentEntity.setMiddleName("Jonh");
		studentEntity.setLastName("Apolinary");
		studentEntity.setPhoneNo(0762241240);
		studentEntity.setAddress("Inyala");
		studentEntity.setCourse("Bachelor of Science in Informatin and Communication Tchnology(ICT");
		studentEntity.setDepartment("Information System and Technology(IST)");
		studentEntity.setAcademicYear("2022/2023");
		studentRepository.save(studentEntity);


	}
}
