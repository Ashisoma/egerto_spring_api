package com.example.egerton_spring_api.repository;

import com.example.egerton_spring_api.entity.Attachment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AttachmentRepository extends JpaRepository<Attachment, String> {
    @Query("select a from Attachment a where upper(a.id) = upper(?1)")
    Attachment findByIdIgnoreCase(String id);
}