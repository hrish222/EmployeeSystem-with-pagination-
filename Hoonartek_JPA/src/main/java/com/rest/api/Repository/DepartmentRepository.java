package com.rest.api.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rest.api.Model.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
	
}

