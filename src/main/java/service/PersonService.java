package service;

import java.util.List;
import entity.Person;

public interface PersonService {
	
	void savePerson(Person person);
	
	Person findPersonById(int id);
	
	List<Person> findAllPersons();

}
