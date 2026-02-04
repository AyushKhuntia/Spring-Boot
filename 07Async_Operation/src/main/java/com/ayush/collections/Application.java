package com.ayush.collections;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

import com.ayush.collections.dao.EmployeeDao;
import com.ayush.collections.dao.PersonDao;
import com.ayush.collections.model.Employee;
import com.ayush.collections.model.Person;
import com.ayush.collections.service.PersonService;


@EnableAsync
@SpringBootApplication
public class Application implements CommandLineRunner{

    private final EmployeeDao employeeDao;

    private final PersonDao personDao;

	@Autowired
	private PersonService personService;

    Application(PersonDao personDao, EmployeeDao employeeDao) {
        this.personDao = personDao;
        this.employeeDao = employeeDao;
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
//		getMaxSalaryByDept();
//		runsync();
		runAsync();
	}
	public void runAsync() throws InterruptedException, ExecutionException {
		long start = System.currentTimeMillis();
		CompletableFuture<List<Person>> person1 = personService.findByemail("kiran@gmail.com");
		System.out.println("Person1 call completed");
	
		CompletableFuture<List<Person>> person2 = personService.findByemail("ram@gmail.com");
		System.out.println("Person2 call completed");
		CompletableFuture.allOf(person1,person2).join();
		System.out.println(System.currentTimeMillis() - start);
		
	}
	public void runSsync() throws InterruptedException, ExecutionException {
		long start = System.currentTimeMillis();
		
		List<Person> person1 = personService.findByEmail("kiran@gmail.com");
		System.out.println("Person1 Call Completed");
		
		List<Person> person2 = personService.findByEmail("ram@gmail.com");
		System.out.println("Person2 Call Completed");
		
		
		person1.forEach(System.out::println);
		
		person2.forEach(System.out::println);
		
		
		
		System.out.println("Total Time took"+(System.currentTimeMillis()-start));
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
