package com.dailycodelearn.SpringBoot_Learn.controller;

import com.dailycodelearn.SpringBoot_Learn.entities.Department;
import com.dailycodelearn.SpringBoot_Learn.error.DepartmentNotFoundException;
import com.dailycodelearn.SpringBoot_Learn.service.DepartmentService;
import jakarta.validation.Valid;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    private final Logger logger = LoggerFactory.getLogger(DepartmentController.class);

    @PostMapping("/departments")
    public Department saveDepartment(@Valid @RequestBody Department department){
        logger.info("Departments are getting saved here");
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/departments")
    public List<Department> findDepartments(){
        logger.info("Departments are getting fetched here");
        return departmentService.findDepartments();
    }

    @GetMapping("/departments/{Id}")
    public Department findDepartmentById(@PathVariable("Id") Long departmentId) throws DepartmentNotFoundException {
        return departmentService.findDepartmentById(departmentId);
    }

    @DeleteMapping("/departments/{Id}")
    public void deleteDepartmentById(@PathVariable("Id") Long departmentId){
        departmentService.deleteDepartmentById(departmentId);
        System.out.println("Department deleted successfully");
    }

    @PutMapping("/departments/{id}")
    public Department updateDepartmentById(@PathVariable("id") Long departmentId,@RequestBody Department department){
        return departmentService.updateDepartmentById(departmentId,department);
    }

    @GetMapping("/departments/name/{name}")
    public Department findDepartmentByName(@PathVariable("name") String departmentName){
        return departmentService.findDepartmentByName(departmentName);
    }

    @PutMapping("/departments/name/{name}")
    public Department updateDepartmentByName(@PathVariable("name") String departmentName, @RequestBody Department department){
        return departmentService.updateDepartmentByName(departmentName,department);
    }
}
