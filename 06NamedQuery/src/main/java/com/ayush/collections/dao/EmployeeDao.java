package com.ayush.collections.dao;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ayush.collections.model.Employee;

@Repository
public interface EmployeeDao extends CrudRepository<Employee, Long> {
	
	List<Object[]> getMaxSalaryByDept(List<String> deptNames);
	
	
}
