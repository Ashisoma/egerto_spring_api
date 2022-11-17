package com.example.egerton_spring_api.controller;

//import antlr.StringUtils;
import com.example.egerton_spring_api.entity.Attachment;
import com.example.egerton_spring_api.models.ResponseData;
import com.example.egerton_spring_api.models.ResponseDataRepository;
import com.example.egerton_spring_api.service.AttachmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping
public class AttachmentController {

    private AttachmentServiceImpl attachmentService;
    @Autowired
    private ResponseDataRepository repository;

    public AttachmentController(AttachmentServiceImpl attachmentService) {
        this.attachmentService = attachmentService;
    }

    @PostMapping("/upload")
    public ResponseData uploadFile(@RequestParam("file") MultipartFile file) throws Exception {
      Attachment attachment = null;
      String downloadUrl = "";
        attachment = attachmentService.saveAttachment(file);

        downloadUrl = ServletUriComponentsBuilder.fromCurrentContextPath()
              .path("/download/")
              .path(attachment.getId())
              .toUriString();

      ResponseData data = new ResponseData(attachment.getId(), attachment.getFileName(),downloadUrl,file.getContentType(),file.getSize());
      repository.save(data);
      return data;
    }

    @GetMapping("/download/{fileId}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileId) throws Exception {
        Attachment attachment = null;
        attachment = attachmentService.getAttachment(fileId);

        return ResponseEntity.ok().contentType(MediaType.parseMediaType(attachment.getFileType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; fileName\""+attachment.getFileName()
                +"\"")
                .body(new ByteArrayResource(attachment.getData()));
    }

    @GetMapping
    public List<ResponseData> getAll(){
        return attachmentService.getAllAttatchments();
    }
}
