//package com.rest.api.Service;
//
//import java.math.BigInteger;
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.rest.api.Model.EmployeeCount;
//import com.rest.api.Repository.EmployeeRepository;
//@Service
//public class EmployeeCountService {
//
//	@Autowired
//	private EmployeeRepository empRepo;
//	
//	public List<EmployeeCount> getAllEmployeeByDepartmentId(){
//		List<Object[]> result= empRepo.getEmpCountByDepartmentId();
//		List<EmployeeCount> list=new ArrayList<EmployeeCount>();
//		if(result!=null && !result.isEmpty()) {
//			for(Object[] object:result) {
//			EmployeeCount employee= new EmployeeCount();
//			employee.setDept_id(Integer.parseInt(object[0].toString()));
//			employee.setEmployee_count(new BigInteger(object[1].toString()).intValue());
//			list.add(employee);
//			}
//		}
//		return list;
//	}
//}
