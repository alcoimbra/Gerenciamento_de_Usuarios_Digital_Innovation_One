package br.com.gerenciamentoDeUsuarios.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gerenciamentoDeUsuarios.entity.Person;
import br.com.gerenciamentoDeUsuarios.repository.PersonRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PersonService {
	
	@Autowired
	private PersonRepository personRepository;
	
	public Person create(Person person) {
		return personRepository.save(person);
	}
}