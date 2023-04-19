package com.example.AploraryCRUDg.repository;

import com.example.AploraryCRUDg.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<StudentEntity, Long> {
    //All CRUD METHODS for databases
}
