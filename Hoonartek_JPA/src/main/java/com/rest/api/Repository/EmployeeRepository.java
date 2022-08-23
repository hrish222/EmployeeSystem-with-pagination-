package com.rest.api.Repository;
import com.rest.api.Model.*;

import java.util.Collections;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.rest.api.Model.Employee;

import net.bytebuddy.asm.Advice.OffsetMapping.Sort;


@Repository
public interface EmployeeRepository  extends JpaRepository<Employee, Integer> {
    
//	@Query(value="select * from employee order by name;",nativeQuery = true)
//    public List<Employee> sortByNameAsc();

//    @Query(value="select * from employee order by name desc;",nativeQuery = true)
//    public List<Employee> sortByNameDesc();

//    @Query(value="select distinct department.d_id as dept_id, count(employee.id) as Employee_count from employee inner join department where employee.d_id=department.d_id group by employee.d_id;",nativeQuery = true)
//    public List<Object[]> getEmpCountByDepartmentId();

	
		
   
	

	
	
    
}
