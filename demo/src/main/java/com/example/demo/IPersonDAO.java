package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IPersonDAO extends JpaRepository<Person, Long>{
	public List<Person> findByNameContains(String Name);
	public List<Person> findByName(String Name);
}
