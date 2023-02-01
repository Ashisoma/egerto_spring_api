package com.example.egerton_spring_api.service;

import com.example.egerton_spring_api.entity.Attachment;
import com.example.egerton_spring_api.models.ResponseData;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

public interface AttachmentService {
    Attachment saveAttachment(MultipartFile file, String departmentName, String courseName) throws Exception;

    Attachment getAttachment(String fileId) throws Exception;

    List<ResponseData> getAllAttatchments();

    List<ResponseData> getByCourseNameIgnoreCase(String courseName);

    List<ResponseData> getByFacultyNameIgnoreCase(String departmentName);

    List<ResponseData> searchCourseIgnoreCase(String courseName);

    String deleteDoc(String fileId);


    List<ResponseData> searchUnitIgnoreCase(String courseName);

    Optional<Attachment> getById(String fileId);
}
