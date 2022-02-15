package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

	@Autowired
	private IPersonDAO personDAO;
	
	public Optional<Person> zoekDmvId(Long id){
		return personDAO.findById(id);
	}
	public List<Person> vindAllePersonen(){
		return personDAO.findAll();
	}
	public void voegPersoonToe(Person person) {
		personDAO.save(person);
	}
	public void verwijderPersoon(Person person) {
		personDAO.delete(person);
	}
	public void verwijderPersoon(Long id) {
		personDAO.deleteById(id);
	}
	public List<Person> vindAllePersonenMetNaam(String naam){
		return personDAO.findByNameContains(naam);
	}
	
}
