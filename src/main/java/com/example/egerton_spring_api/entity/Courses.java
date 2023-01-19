package com.example.egerton_spring_api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Courses {
    @Id
    private Long id;
    private String unitCode;
    private String facultyName;
    private String courseName;
}
