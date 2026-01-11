package com.ayush.collections;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.ayush.collections.dao.PersonDao;
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
		
		List<Person> personList = Arrays.asList(
				new Person("Kiran","shyam","kiran@gmail.com",20),
				new Person("Ram","kumar","ram@gmail.com",22)
				);
		Iterable<Person> list = personService.saveAllPerson(personList);
		
		Iterable<Person> persons = personService.getAllPersons();
		for(Person person : persons) {
			System.out.println("Person Object"+person.toString());
		}

	}
	
	
	

}
