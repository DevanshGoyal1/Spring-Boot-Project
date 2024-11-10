package com.dailycodelearn.SpringBoot_Learn.service;
import com.dailycodelearn.SpringBoot_Learn.entities.Department;
import com.dailycodelearn.SpringBoot_Learn.error.DepartmentNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface DepartmentService {
    public Department saveDepartment(Department department);
    public List<Department> findDepartments();

    public Department findDepartmentById(Long departmentId) throws DepartmentNotFoundException;

    public void deleteDepartmentById(Long departmentId);

    public Department updateDepartmentById(Long departmentId, Department department);

    public Department updateDepartmentByName(String departmentName, Department department);


    public Department findDepartmentByName(String departmentName);
}
