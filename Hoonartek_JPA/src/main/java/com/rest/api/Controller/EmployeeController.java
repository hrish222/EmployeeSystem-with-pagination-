package com.rest.api.Controller;
import com.rest.api.Service.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.collect.Lists;
import com.rest.api.DTO.EmployeeDeptDTO;
import com.rest.api.Model.ApiResponse;
import com.rest.api.Model.Employee;
//import com.rest.api.Model.EmployeeCount;
import com.rest.api.Repository.EmployeeRepository;
//import com.rest.api.Service.EmployeeCountService;
import com.rest.api.Service.EmployeeService;
import com.rest.api.exception.EmptyInputException;

import ch.qos.logback.core.status.ErrorStatus;
import io.swagger.annotations.Api;
@CrossOrigin(origins ="http://localhost:3000")
@RestController
@Api(value="EMPLOYEE OPERATION")
@RequestMapping("/api")
public class EmployeeController {



	@Autowired
	    private EmployeeService employeeService;

	   @Autowired
	   private  EmployeeRepository ERepo;
	  @GetMapping("/getallemployees")
	    public ResponseEntity<List<Employee>> getAllEmployee(){
		   List<Employee> listOfAllEmps=  employeeService.getAllEmployees();
	        return new ResponseEntity<List<Employee>>(listOfAllEmps, HttpStatus.OK);
	    }

	    @GetMapping("/employee/{id}")
	    public ResponseEntity<Employee> getEmployee(@Valid @PathVariable  ("id") int id) throws EmptyInputException{
	        Employee emp =employeeService.getEmployeeById(id);
	        return new ResponseEntity<Employee>(emp, HttpStatus.OK);	
	    }

	    @PostMapping("/createEmployee")
	    public ResponseEntity<Employee>addEmployees(@Valid @RequestBody Employee employee) throws EmptyInputException{
	        System.out.println(employee);
	       Employee employeeSaved = employeeService.addEmployees(employee);
	        return new ResponseEntity<Employee>(employeeSaved, HttpStatus.CREATED);
	    }

	    @PutMapping("/Updateemployee/{id}")
	    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee, @PathVariable ("id") int id){
	        System.out.println(employee);
	       Employee employeeSaved= employeeService.updateEmployee(employee, id);
	       return new ResponseEntity<Employee>(employeeSaved, HttpStatus.CREATED);
	    }

	    @DeleteMapping("/DeleteEmployee/{id}")
	    public  ResponseEntity<Void> deleteEmployeeByID(@PathVariable ("id") int id){
	        employeeService.deleteEmployeeByID(id);
	        return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
	    }

	    @GetMapping("/employee")
		public List<Employee> sort(@RequestParam String order)
		{
			return employeeService.getByDescOrder();
		}
	    
	    @GetMapping("/employees")
		public List<Employee> sortAsc(@RequestParam String order)
		{
			return employeeService.getByAscOrder();
		}
	    
//	    @GetMapping("/DeptList")
//	    public ResponseEntity<List<EmployeeCount>> getAllEmployeeByDepartmentId(){
//	    	System.out.println(employeeCountService.getAllEmployeeByDepartmentId());
//	    	List<EmployeeCount> list= employeeCountService.getAllEmployeeByDepartmentId();
//	    	if(list.size()<=0)
//	    		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//	    	return ResponseEntity.status(HttpStatus.OK).body(list);
//	    	
//	    }
	    
	    @GetMapping("/employees/Count")
		public Map<String, Integer> getCountByDepartment() 
		{ 
			List<Employee> employees = employeeService.getAllEmployees(); 

			Map<String, Integer> map = new HashMap<String, Integer>(); 
			
			for(Employee employee : employees)
			{
				if(!map.containsKey(employee.getDepartment().getdName()))
					map.put(employee.getDepartment().getdName(), Integer.valueOf(1));
				else
					map.put(employee.getDepartment().getdName(), map.get(employee.getDepartment().getdName())+1);
			}
			return map;
		}
	    
	    //Paging 
	    @GetMapping("/paginate/{page}/{size}")
	    public ResponseEntity<Map<String, Object>> getAllEmployeesPage( @PathVariable ("page") int page,@PathVariable ("size") int size) {

	     try {
	       List<Employee> employee = new ArrayList<Employee>();
	       Pageable pages = PageRequest.of(page, size);
	       Page<Employee> employeelist;
	        
	       employeelist = ERepo.findAll(pages);
	           employee = employeelist.getContent();
	       Map<String, Object> response = new TreeMap<>();
	        response.put("employees", employee);
	        response.put("currentPage", employeelist.getNumber());
	        response.put("totalItems", employeelist.getTotalElements());
	        response.put("totalPages", employeelist.getTotalPages());
	       return new ResponseEntity<>(response, HttpStatus.OK);
	      } catch (Exception e) {
	        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	      }
	    }
	    
//	    @GetMapping("/pagination/{pagenumber}/{pageSize}")
//	    private ApiResponse<Page<Employee>> getEmployeesWithPagination(@PathVariable int pagenumber, @PathVariable int pageSize) {
//	        Page<Employee> employeesWithPagination = employeeService.findEmployeesWithPagination(pagenumber, pageSize);
//	       return new ApiResponse<>(employeesWithPagination.getSize(), employeesWithPagination);
//	       
//	    	//return ResponseEntity.status(HttpStatus.OK).body(employeesWithPagination);
//	    }
//
//	    @GetMapping("/paginationAndSort/{pagenumber}/{pageSize}/{field}")
//	    private ApiResponse<Page<Employee>> getEmployeesWithPaginationAndSort(@PathVariable int pagenumber, @PathVariable int pageSize,@PathVariable String field) {
//	        Page<Employee> employeesWithPagination = employeeService.findEmployeesWithPaginationAndSorting(pagenumber, pageSize, field);
//	        return new ApiResponse<>(employeesWithPagination.getSize(), employeesWithPagination);	   
//	        }
	    
	    //Dto Method
	    @GetMapping("/employee-record")
	    public List<EmployeeDeptDTO> getAllEmployeeDepartment(){
	        return employeeService.getAllEmployeeDept();
	    }
	   
	    
	    
	    
	    
}
