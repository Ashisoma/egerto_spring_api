package com.example.egerton_spring_api.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ResponseData {

    @Id
    private String fileId;
    private String fileName;
    private String departmentName;
    private String courseName;
    private String downloadUrl;
    private String fileType;
    private long fileSize;

}
