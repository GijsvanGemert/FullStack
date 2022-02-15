package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class PersonController {
	
	@Autowired
	private PersonService personService;
	
	@RequestMapping("/api/person/{id}")
	public Optional<Person> vindDvId(@PathVariable Long id) {	
//		System.out.println("De id is "+id );
//		return id*2;
		Optional<Person> opt = personService.zoekDmvId(id);
		
		return opt;
	}
	//@RequestMapping("/api/person/alle")
	@GetMapping("/api/person/alle")
	public List<Person> vindalle(){
		return personService.vindAllePersonen();
	}
	@PostMapping("/api/person")
	public void aanmaken(@RequestBody Person person) {
		personService.voegPersoonToe(person);
	}
	
	@PutMapping("/api/person/{id}")
	public void aanpassen(@PathVariable Long id,@RequestBody Person person) {
		Optional<Person> opt = personService.zoekDmvId(id);
		if(opt.isPresent()) {
			Person p=opt.get();
			p.setAge(person.getAge());
			p.setName(person.getName());
			personService.voegPersoonToe(p);
		}
	}
	@DeleteMapping("/api/person/{id}")
	public void verwijder(@PathVariable Long id) {
		Optional<Person> opt = personService.zoekDmvId(id);
		if(opt.isPresent()) {
			Person p=opt.get();
			personService.verwijderPersoon(p);
		}
	}
	@GetMapping("/api/person/allenaam/{naam}")
	public List<Person> vindAlleMetNaam(@PathVariable String naam){
		System.out.println(naam);
		return personService.vindAllePersonenMetNaam(naam);
	}
}
