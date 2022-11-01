package com.example.egerton_spring_api.controller;

//import antlr.StringUtils;
import com.example.egerton_spring_api.entity.Attachment;
import com.example.egerton_spring_api.models.ResponseData;
import com.example.egerton_spring_api.service.AttachmentServiceImpl;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class AttachmentController {

    private AttachmentServiceImpl attachmentService;

    public AttachmentController(AttachmentServiceImpl attachmentService) {
        this.attachmentService = attachmentService;
    }

    @PostMapping("/upload")
    public ResponseData uploadFile(@RequestParam("file")MultipartFile file) throws Exception {
      Attachment attachment = null;
      attachment = attachmentService.saveAttachment(file);

      String downloadUrl = "";
      downloadUrl = ServletUriComponentsBuilder.fromCurrentContextPath()
              .path("/download/")
              .path(attachment.getId())
              .toUriString();

      return new ResponseData(attachment.getFileName(),downloadUrl,file.getContentType(),file.getSize());
    }

    @GetMapping("/download/{fileId}")
    public ResponseEntity<Resource> downloadFile(@RequestParam String fileId){
        Attachment attachment = null;
        attachment = attachmentService.getAttachment(fileId);

        return ResponseEntity.ok().contentType(MediaType.parseMediaType(attachment.getFileType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment:\""+attachment.getFileName()
                +"\"")
                .body(new ByteArrayResource(attachment.getData()));
    }
}
