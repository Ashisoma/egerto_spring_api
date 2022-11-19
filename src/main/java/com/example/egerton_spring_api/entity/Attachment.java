package com.example.egerton_spring_api.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
@NoArgsConstructor
@Data
public class Attachment {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    private String fileName;
    private String departmentName;
    private String courseName;
    private String fileType;

    @Lob
    private byte[] data;


    public Attachment(String fileName, String departmentName, String courseName, String fileType, byte[] data) {
        this.fileName = fileName;
        this.departmentName = departmentName;
        this.courseName = courseName;
        this.fileType = fileType;
        this.data = data;
    }
}
