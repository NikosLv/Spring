package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entity.Person;
import repository.PersonRepository;
import service.PersonService;

@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonRepository  personRepository;
	
	@Override
	public void savePerson(Person person) {
		personRepository.save(person);
		
	}

	@Override
	public Person findPersonById(int id) {
		
		return personRepository.getOne(id);
	}

	@Override
	public List<Person> findAllPersons() {
	
		return personRepository.findAll();
	}

}
