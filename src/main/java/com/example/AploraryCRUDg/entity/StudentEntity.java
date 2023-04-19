package com.example.AploraryCRUDg.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "student_Info")
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "RegNo")
    String RegNo;
    @Column(name = "firstName")
    String firstName;
    @Column(name = "middleName")
    String middleName;
    @Column(name = "lastName")
    String lastName;
    @Column(name = "phoneNo")
    int phoneNo;
    @Column(name = "address")
    String address;
    @Column(name = "course")
    String course;
    @Column(name = "department")
    String department;
    @Column(name = "academicYear")
    String academicYear;
}
