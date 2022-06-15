package br.com.gerenciamentoDeUsuarios.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gerenciamentoDeUsuarios.dto.mapper.PersonMapper;
import br.com.gerenciamentoDeUsuarios.dto.request.PersonDTO;
import br.com.gerenciamentoDeUsuarios.dto.response.MessageResponseDTO;
import br.com.gerenciamentoDeUsuarios.entity.Person;
import br.com.gerenciamentoDeUsuarios.repository.PersonRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PersonService {
	
	@Autowired
	private PersonRepository personRepository;
	
	private PersonMapper personMapper;
	
	public MessageResponseDTO create(PersonDTO personDTO) {
		Person person = personMapper.toModel(personDTO);
		Person savedPerson = personRepository.save(person);
		
		MessageResponseDTO messageResponse = MessageResponseDTO.builder()
																.message("Person Created with ID " + savedPerson.getId())
																.build();
		
		return messageResponse;
	}
}