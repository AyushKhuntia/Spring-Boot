package com.ayush.collections;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.ayush.collections.dao.PersonDao;
import com.ayush.collections.model.Employee;
import com.ayush.collections.model.Person;
import com.ayush.collections.service.PersonService;


@SpringBootApplication
public class Application implements CommandLineRunner{

    private final PersonDao personDao;

	@Autowired
	private PersonService personService;

    Application(PersonDao personDao) {
        this.personDao = personDao;
    } 
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
//		List<Person> personList = Arrays.asList(
//				new Person("Kiran","shyam","kiran@gmail.com",20)
//				new Person("Ram","kumar","ram@gmail.com",22)
//				);
//		Iterable<Person> list = personService.saveAllPerson(personList);
		
//		Iterable<Person> persons = personService.getAllPersons();
//		for(Person person : persons) {
//			System.out.println("Person Object"+person.toString());
//		}
//		List<Person> persons = personService.givebyLastName("shyam");
//		for(Person person : persons) {
//			System.out.println("Named Query Person Object"+person.toString());
//		}
//		createEmployees();
		getMaxSalaryByDept();
	}
	
	public void createEmployees() {
		List<Employee> empList = Arrays.asList(
				Employee.create("Ayush","IT",50000),
				Employee.create("Ram","IT",50000),
				Employee.create("Kiran","HR",40000),
				Employee.create("Ram","Finance",60000)
				);
		Iterable<Employee> list = personService.saveAllEmployees(empList);
		
		for(Employee emp : list) {
			System.out.println("Employee Object"+emp.toString());
		}
	}
	
	public void getMaxSalaryByDept() {
		List<String> deptNames = Arrays.asList("IT","HR","Finance");
		List<Object[]> maxSalaryByDept = personService.getMaxSalaryByDept(deptNames);
		for(Object[] record : maxSalaryByDept) {
			System.out.println("Dept Name: "+record[0]+" Max Salary: "+record[1]);
		}
	}
	
	

}
