package com.rest.api.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rest.api.Model.Department;
import com.rest.api.Service.DepartmentService;

import io.swagger.annotations.Api;
@CrossOrigin
@RestController
@Api(value="DEPARTMENT OPERATION")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/departments")
    public List<Department> getAllDepartment(){
        return departmentService.getAllDepartments();
    }

    @PostMapping("/add-department")
    public void addDepartment(@RequestBody Department department){
        departmentService.addDepartment(department);
    }
}