package com.example.egerton_spring_api.repository;

import com.example.egerton_spring_api.entity.Attachment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface AttachmentRepository extends JpaRepository<Attachment, String> {
    @Query("select a from Attachment a where upper(a.id) = upper(?1)")
    Attachment findByIdIgnoreCase(String id);

    @Query("select a from Attachment a where upper(a.courseName) = upper(?1)")
    List<Attachment> findByCourseNameIgnoreCase(String courseName);

    @Query("select a from Attachment a where upper(a.facultyName) = upper(?1)")
    List<Attachment> findByFacultyNameContainingIgnoreCase(String facultyName);

    @Query("select a from Attachment a where upper(a.courseName) like upper(concat('%', ?1, '%'))")
    List<Attachment> findByCourseNameContainsIgnoreCase(String courseName);


}