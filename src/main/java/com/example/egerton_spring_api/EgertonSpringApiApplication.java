package com.example.egerton_spring_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication

@EnableWebMvc
//@RestController
@RequestMapping
public class EgertonSpringApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(EgertonSpringApiApplication.class, args);



    }

//    @GetMapping
//    public String rootPath(){
//        return "Project running successfully";
//    }

}
