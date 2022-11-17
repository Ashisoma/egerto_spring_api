package com.example.egerton_spring_api.service;

import com.example.egerton_spring_api.entity.Attachment;
import com.example.egerton_spring_api.models.ResponseData;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface AttachmentService {
    Attachment saveAttachment(MultipartFile file) throws Exception;

    Attachment getAttachment(String fileId) throws Exception;

    List<ResponseData> getAllAttatchments();
}
