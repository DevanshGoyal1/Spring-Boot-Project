package com.dailycodelearn.SpringBoot_Learn.repository;

import com.dailycodelearn.SpringBoot_Learn.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {
    public Department findByDepartmentNameIgnoreCase(String departmentName);
}
