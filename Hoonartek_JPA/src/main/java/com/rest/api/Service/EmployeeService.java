package com.rest.api.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.rest.api.DTO.EmployeeDeptDTO;
import com.rest.api.Model.Employee;
import com.rest.api.Repository.EmployeeRepository;
import com.rest.api.exception.EmptyInputException;





	@Service
	public class EmployeeService {

	    @Autowired
	    private EmployeeRepository employeeRepository;

	    //get all employees
	    public List<Employee> getAllEmployees(){
	        List<Employee> employees = (List<Employee>)employeeRepository.findAll();
	        return employees;
	    }

	    public Employee getEmployeeById(int id) {
		   return employeeRepository.findById(id).get();
		
			
		}

	    //add 
	    public Employee addEmployees(Employee employee) {
	    	if((employee.getName().isEmpty() || employee.getName().length() == 0 )||(employee.getJoiningdate().isEmpty() || employee.getJoiningdate().length() == 0)||(employee.getEmail().isEmpty()|| employee.getEmail().length()== 0)||(employee.getDepartment().getdName().isEmpty()|| employee.getDepartment().getdName().length()==0) ) {
	    		throw new EmptyInputException("601","Input Fields are empty");
	    	}
	        return employeeRepository.save(employee);
	    }

	    //update 
	    public Employee updateEmployee(Employee employee, int id){
	       
	    	 return employeeRepository.save(employee);
	                  
	}
	  
	    //delete 
	    public String deleteEmployeeByID(int id){
	        employeeRepository.deleteById(id);
	        return "Deleted Employee Record";
	    }
       //Dsec
		public List<Employee> getByDescOrder()
		{
			List<Employee> employees = getAllEmployees();
			return employees.stream().sorted(Comparator.comparing(Employee::getName).reversed()).collect(Collectors.toList());
		}
      //Asc
		public List<Employee> getByAscOrder()
		{
			List<Employee> employees = getAllEmployees();
			return employees.stream().sorted(Comparator.comparing(Employee::getName)).collect(Collectors.toList());
		}

		//pagination method
//		 public Page<Employee> findEmployeesWithPagination(int pagenumber,int pageSize){
//		        Page<Employee> employee = employeeRepository.findAll(PageRequest.of(pagenumber, pageSize));
//		        return  employee;
//		    }
//
//		    public Page<Employee> findEmployeesWithPaginationAndSorting(int offset,int pageSize,String field){
//		        Page<Employee> employee = employeeRepository.findAll(PageRequest.of(offset, pageSize).withSort(Sort.by(field)));
//		        return  employee;
//		    }
		
		    
		    //Dto Mapping Method
		    
		    public List<EmployeeDeptDTO> getAllEmployeeDept(){
		    	
		            return employeeRepository.findAll()
		                    .stream()
		                    .map(this::convertEntityToDto)
		                    .collect(Collectors.toList());

		        
		    }
		    
		    private EmployeeDeptDTO convertEntityToDto(Employee employee) {
		    	EmployeeDeptDTO employeeDeptDTO = new EmployeeDeptDTO();
		    	employeeDeptDTO.setId(employee.getId());
		    	employeeDeptDTO.setEmail(employee.getEmail());
		    	employeeDeptDTO.setName(employee.getName());
		    	employeeDeptDTO.setDname(employee.getDepartment().getdName());
		    	return employeeDeptDTO;
		    }
		    

//		    private EmployeeDeptDTO convertEntityToDto(Employee employee){
//		        modelMapper.getConfiguration()
//		                .setMatchingStrategy(MatchingStrategy.LOOSE);
//		        EmployeeDeptDTO employeeDeptDTO = new EmployeeDeptDTO();
//		        employeeDeptDTO = modelMapper.map(employee, EmployeeDeptDTO.class);
//		        return employeeDeptDTO;
//		    }
//
//		    private Employee convertDtoToEntity(EmployeeDeptDTO employeeDeptDTO){
//		        modelMapper.getConfiguration()
//		                .setMatchingStrategy(MatchingStrategies.LOOSE);
//		        Employee employee = new Employee();
//		        employee = modelMapper.map(employeeDeptDTO, Employee.class);
//		        return employee;
//		    }
		    
	}
		 
	
		
	


