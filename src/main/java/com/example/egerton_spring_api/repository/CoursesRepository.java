package com.example.egerton_spring_api.repository;

import com.example.egerton_spring_api.entity.Courses;
import com.example.egerton_spring_api.models.ResponseData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CoursesRepository  extends JpaRepository<Courses, Long> {
    @Query("select c from Courses c where upper(c.courseName) like upper(concat('%', ?1, '%'))")
    List<Courses> findByCourseNameContainsIgnoreCase(String courseName);

    @Query("select c from Courses c where upper(c.unitCode) like upper(concat('%', ?1, '%'))")
    List<Courses> findByUnitCodeContainsIgnoreCase(String unitCode);
}
