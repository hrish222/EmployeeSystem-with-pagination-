package com.rest.api.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.api.Model.Department;
import com.rest.api.Repository.*;


@Service
public class DepartmentService {
	 @Autowired
	    private DepartmentRepository departmentRepository;

	    //get all departments
	    public List<Department> getAllDepartments(){
	        List<Department> depts = (List<Department>)departmentRepository.findAll();
	        return depts;
	    }

	    //add new department
	    public void addDepartment(Department department) {
	        departmentRepository.save(department);
	    }

}
