package br.com.gerenciamentoDeUsuarios.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gerenciamentoDeUsuarios.dto.mapper.PersonMapper;
import br.com.gerenciamentoDeUsuarios.dto.request.PersonDTO;
import br.com.gerenciamentoDeUsuarios.dto.response.MessageResponseDTO;
import br.com.gerenciamentoDeUsuarios.entity.Person;
import br.com.gerenciamentoDeUsuarios.exception.PersonNotFoundException;
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
		
		MessageResponseDTO messageResponse = createMessageResponse("Person Successfully Created with ID ", savedPerson.getId());
		
		return messageResponse;
	}
	
	public PersonDTO findById(Long id) throws PersonNotFoundException {
		Optional<Person> person = personRepository.findById(id);
		
		if (person.isEmpty()) {
			throw new PersonNotFoundException(id);
		}
		
		return personMapper.toDTO(person.get());
	}
	
	public MessageResponseDTO update(Long id, PersonDTO personDTO) throws PersonNotFoundException {
		Optional<Person> person = personRepository.findById(id);
		
		if (person.isEmpty()) {
			throw new PersonNotFoundException(id);
		}
		
		Person updatedPerson = personMapper.toModel(personDTO);
		Person savedPerson = personRepository.save(updatedPerson);
		
		MessageResponseDTO messageResponse = createMessageResponse("Person Successfully Updated with ID ", savedPerson.getId());
		
		return messageResponse;
	}
	
	public List<PersonDTO> listAll(){
		List<Person> people = personRepository.findAll();
		
		return people.stream()
						.map(personMapper::toDTO)
						.collect(toList());
	}
	
	public MessageResponseDTO delete(Long id) throws PersonNotFoundException {
		Optional<Person> person = personRepository.findById(id);
		
		if (person.isEmpty()) {
			throw new PersonNotFoundException(id);
		}
		
		personRepository.deleteById(id);
		
		MessageResponseDTO messageResponse = createMessageResponse("Person Successfully Deleted with ID ", id);
		
		return messageResponse;
	}
	
	private MessageResponseDTO createMessageResponse(String s, Long id2) {
		return MessageResponseDTO.builder()
									.message(s + id2)
									.build();
	}
}