package com.example.egerton_spring_api.service;

import com.example.egerton_spring_api.entity.Courses;
import com.example.egerton_spring_api.entity.Departments;
import com.example.egerton_spring_api.repository.CoursesRepository;
import com.example.egerton_spring_api.repository.DepartmentsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class CoursesService {
    
    @Autowired
    private final CoursesRepository coursesRepository;
    
    @Autowired
    private final DepartmentsRepository departmentsRepository;
    
    
//    private String saveData(Departments department){
//        String returnVal = "";
//        Set<Courses> courseList = null;
//        Departments dept = new Departments();
//        Courses courses = new Courses();
//        courseList.add(courses);
//        dept.setCoursesList(courseList);
//
//        return returnVal;
//    }


    public List<Courses> searchUnitIgnoreCase(String unitCode) {
        return coursesRepository.findByUnitCodeContainsIgnoreCase(unitCode);
    }

    public List<Courses> searchCourseIgnoreCase(String courseName) {
        return coursesRepository.findByCourseNameContainsIgnoreCase(courseName);
    }

    public Courses saveCourse(Courses course) {
        return coursesRepository.save(course);
    }
}
