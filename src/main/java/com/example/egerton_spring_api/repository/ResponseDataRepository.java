package com.example.egerton_spring_api.repository;

import com.example.egerton_spring_api.models.ResponseData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ResponseDataRepository extends JpaRepository<ResponseData, String> {
    @Query("select r from ResponseData r where upper(r.facultyName) = upper(?1)")
    List<ResponseData> findResponseDataByFacultyNameIgnoreCase(String facultyName);

    @Query("select r from ResponseData r where upper(r.courseName) = upper(?1)")
    List<ResponseData> findByCourseNameIgnoreCase(String courseName);

    @Query("select r from ResponseData r where upper(r.courseName) like upper(concat('%', ?1, '%'))")
    List<ResponseData> findByCourseNameContainsIgnoreCase(String courseName);

    @Query("select r from ResponseData r where upper(r.unitCode) like upper(concat('%', ?1, '%'))")
    List<ResponseData> findByUnitCodeContainsIgnoreCase(String unitCode);
}