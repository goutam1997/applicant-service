package com.example.applicantservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("/applicant-service")
@EnableFeignClients
public class ApplicantServiceApplication {
    private static final Logger logger = LoggerFactory.getLogger(ApplicantServiceApplication.class);

    @Autowired
    private DepartmentClient departmentClient;

    @GetMapping("/applicants")
    public List<String> getApplicants() {
        return Arrays.asList("Goutam","Suman","Rohit");
    }
    public static void main(String[] args) {
        SpringApplication.run(ApplicantServiceApplication.class, args);
    }

    @GetMapping("/applicantsInfo")
    public List<ApplicantInfo> getApplicantsInfo() {
        logger.info("GET call received at: {}", new Date());
        logger.info("Adding departments to department service");
        departmentClient.addDepartments(Arrays.asList(
                new Department("Goutam", "CSE"),
                new Department("Suman", "ECE")
        ));
        logger.info("Returning applicants response");
        return Arrays.asList(
                new ApplicantInfo("Goutam","gou@gmail.com",1452),
                new ApplicantInfo("Suman","su@redifmail.com",54896528)
        );
    }

}
