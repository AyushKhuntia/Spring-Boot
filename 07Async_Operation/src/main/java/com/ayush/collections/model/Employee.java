package com.ayush.collections.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tbl_employee")
@NamedQueries(value= {
		@NamedQuery(name="Employee.getMaxSalaryByDept" ,				
				query="SELECT e.dept,MAX(e.salary) from Employee e group by e.dept having e.dept IN ?1")
})

public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String dept;
	private int salary;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(String name, String dept, int salary) {
		super();
		this.name = name;
		this.dept = dept;
		this.salary = salary;
	}

	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", dept=" + dept + ", salary=" + salary + "]";
	}

	public static Employee create(String name, String dept, int salary) {
		Employee emp = new Employee();
		emp.setName(name);
		emp.setDept(dept);
		emp.setSalary(salary);
		return emp;
	}

}
