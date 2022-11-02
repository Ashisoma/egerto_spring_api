package com.example.egerton_spring_api.service;

import com.example.egerton_spring_api.entity.Attachment;
import com.example.egerton_spring_api.repository.AttachmentRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.el.ELException;
import java.util.Objects;

@Service
public class AttachmentServiceImpl implements AttachmentService{

    private AttachmentRepository repository;

    public AttachmentServiceImpl(AttachmentRepository repository) {
        this.repository = repository;
    }

    @Override
    public Attachment saveAttachment(MultipartFile file) throws Exception {
        String fileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));

        try {
            if (fileName.contains("...")){
                throw new Exception("File name contains invalid path sequence" + fileName);

            }
            Attachment attachment = new Attachment(
                    fileName,
                    file.getContentType(),
                    file.getBytes()
            );

           return repository.save(attachment);
        }catch (Exception e){
            throw new Exception("Could not save file "+ fileName);
        }

    }

    @Override
    public Attachment getAttachment(String fileId) {
        return repository.findById(fileId).orElseThrow(()-> new ELException("File not found with id :" +fileId));
    }
}
