package com.example.egerton_spring_api.repository;

import com.example.egerton_spring_api.entity.Departments;
import com.example.egerton_spring_api.models.ResponseData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.nio.file.LinkOption;

@Repository
public interface DepartmentsRepository  extends JpaRepository<Departments, Long> {
}
