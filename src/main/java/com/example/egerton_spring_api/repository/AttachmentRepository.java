package com.example.egerton_spring_api.repository;

import com.example.egerton_spring_api.entity.Attachment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttachmentRepository extends JpaRepository<Attachment, String> {
}