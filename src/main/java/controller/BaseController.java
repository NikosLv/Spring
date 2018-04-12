package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import entity.Person;
import service.PersonService;

@Controller
public class BaseController {
	
	@Autowired
	private PersonService personService;
	
	@GetMapping("/")
	public String showHome() {
		return "home";
		
	}
	
	@GetMapping("/register")
	public String showRegister() {
		return "register";
	}
	
	@GetMapping("/home")
	public String showHomePage() {
		return "home";
	}
	
	
	
	@PostMapping("/addNewPerson")
	public String savePerson(@RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName)
	 {
		
		Person person = new Person();
		person.setFirstName(firstName);
		person.setLastName(lastName);
		
		personService.savePerson(person);
		
		return "redirect:/persons";
	}
	
	@GetMapping("/persons")
	public String getAllPersons(Model model) {
		List<Person>persons=personService.findAllPersons();
		model.addAttribute("personList",persons);
		return "person/persons";
		
	}

}
