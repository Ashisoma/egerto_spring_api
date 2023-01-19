package com.example.egerton_spring_api.controller;

import com.example.egerton_spring_api.entity.Courses;
import com.example.egerton_spring_api.repository.CoursesRepository;
import com.example.egerton_spring_api.service.CoursesService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/notes")
@Slf4j
@RequiredArgsConstructor
public class CourseController {
    private final CoursesRepository coursesRepository;
    private final CoursesService coursesService;

    @GetMapping("/unit/{unitCode}")
    public List<Courses> getUnitsByCourses(@PathVariable("unitCode") String unitCode){
        return coursesService.searchUnitIgnoreCase(unitCode);
    }

    @GetMapping("/course/{courseName}")
    public List<Courses> getCoursesByUnits(@PathVariable("courseName") String courseName){
        return coursesService.searchCourseIgnoreCase(courseName);
    }

    @PostMapping
    public Courses addACourse(@RequestBody Courses course){
        return coursesService.saveCourse(course);
    }


}
