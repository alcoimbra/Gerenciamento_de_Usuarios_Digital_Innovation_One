package br.com.gerenciamentoDeUsuarios.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.gerenciamentoDeUsuarios.entity.Person;
import br.com.gerenciamentoDeUsuarios.service.PersonService;
import lombok.AllArgsConstructor;

@RestController("/api/v1/person")
@AllArgsConstructor
public class PersonController {
	
	@Autowired
	private PersonService personService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Person create(Person person) {
		return personService.create(person);
	}
}