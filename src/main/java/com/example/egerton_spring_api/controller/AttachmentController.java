package com.example.egerton_spring_api.controller;

//import antlr.StringUtils;
import com.example.egerton_spring_api.entity.Attachment;
import com.example.egerton_spring_api.entity.Courses;
import com.example.egerton_spring_api.models.ResponseData;
import com.example.egerton_spring_api.service.AttachmentServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping
@Slf4j
public class AttachmentController {

    private final AttachmentServiceImpl attachmentService;

    public AttachmentController(AttachmentServiceImpl attachmentService) {
        this.attachmentService = attachmentService;
    }

    @GetMapping
    public String rootPath(){
        return "Project running successfully";
    }
    @PostMapping("/upload")
    public ResponseData uploadFile(@RequestParam("file") MultipartFile file,
                                   @RequestParam("facultyName")  String facultyName,
                                   @RequestParam("courseName") String courseName,
                                   @RequestParam("unitCode") String unitCode
    ) throws Exception {
      Attachment attachment = null;
      String downloadUrl = "";
        attachment = attachmentService.saveAttachment(file,facultyName,courseName);

        downloadUrl = ServletUriComponentsBuilder.fromCurrentContextPath()
              .path("/download/")
              .path(attachment.getId())
              .toUriString();
        log.info("Attachment {}", attachment.getFileName());

      ResponseData data = new ResponseData(attachment.getId(),attachment.getFileName(), facultyName,unitCode,courseName,
              downloadUrl, attachment.getFileType(), file.getSize() );
        log.info("Data {}", data);

        attachmentService.saveData(data);
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

    @GetMapping("/get")
    public List<ResponseData> getAll(){
        return attachmentService.getAllAttatchments();
    }

    @GetMapping("/department/{facultyName}")
    public List<ResponseData> getCoursesInFacultyName(@PathVariable("facultyName") String facultyName){
        return attachmentService.getByFacultyNameIgnoreCase(facultyName);
    }

    @GetMapping("/course/{courseName}")
    public List<ResponseData> getByCourseName(@PathVariable("courseName") String courseName){
        return attachmentService.getByCourseNameIgnoreCase(courseName);
    }


    @GetMapping("/search/{courseName}")
    public List<ResponseData> searchByCourseName(@PathVariable("courseName") String courseName){
        return attachmentService.searchCourseIgnoreCase(courseName);
    }

    @GetMapping("/searchUnit/{unitCode}")
    public List<ResponseData> searchByUnitCode(@PathVariable("unitCode") String unitCode){
        return attachmentService.searchUnitIgnoreCase(unitCode);
    }



    @DeleteMapping("/delete/{fileId}")
    public String delete(@PathVariable("fileId") String fileId){
        return attachmentService.deleteDoc(fileId);
    }
}
