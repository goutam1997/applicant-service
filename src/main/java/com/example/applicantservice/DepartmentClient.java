package com.example.applicantservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient("DEPARTMENT-SERVICE")
public interface DepartmentClient {
    @PostMapping("/department-service/add-all")
    void addDepartments(List<Department> departments);
}
