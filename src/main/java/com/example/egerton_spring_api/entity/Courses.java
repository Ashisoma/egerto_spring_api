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

    @GeneratedValue(strategy = GenerationType.AUTO,
            generator = "course_sequence")
    @SequenceGenerator(name = "course_sequence",
            sequenceName = "course_sequence",
            allocationSize = 1)
    @Id
    private Long id;
    private String unitCode;
    private String facultyName;
    private String courseName;
}
