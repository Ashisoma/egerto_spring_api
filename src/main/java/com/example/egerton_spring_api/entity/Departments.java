package com.example.egerton_spring_api.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor

public class Departments {

    @GeneratedValue(strategy = GenerationType.AUTO,
            generator = "dept_sequence")
    @SequenceGenerator(name = "dept_sequence",
            sequenceName = "dept_sequence",
            allocationSize = 1)
    @Id
    private Long id;

    @JsonIgnore
    @OneToMany(
            mappedBy = "courses",
            cascade = CascadeType.ALL
    )
    private Set<Courses> coursesList;

    private String unitCode;
    private String facultyName;

}
