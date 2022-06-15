package br.com.gerenciamentoDeUsuarios.service;

import static br.com.gerenciamentoDeUsuarios.utils.PersonUtils.createFakeDTO;
import static br.com.gerenciamentoDeUsuarios.utils.PersonUtils.createFakeEntity;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.gerenciamentoDeUsuarios.dto.mapper.PersonMapper;
import br.com.gerenciamentoDeUsuarios.dto.request.PersonDTO;
import br.com.gerenciamentoDeUsuarios.dto.response.MessageResponseDTO;
import br.com.gerenciamentoDeUsuarios.entity.Person;
import br.com.gerenciamentoDeUsuarios.repository.PersonRepository;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {
	
	@Mock
	private PersonRepository personRepository;
	
	@Mock
	private PersonMapper personMapper;
	
	@InjectMocks
	private PersonService personService;
	
	@Test
	public void testGivenPersonDTOThenReturnSucessSavedMessage() {
		PersonDTO personDTO = createFakeDTO();
		Person expectedSavedPerson = createFakeEntity();
		
		when(personMapper.toModel(personDTO)).thenReturn(expectedSavedPerson);
		when(personRepository.save(any(Person.class))).thenReturn(expectedSavedPerson);
		
		MessageResponseDTO expectedSucessMessage = createExpectedSucessMessage(expectedSavedPerson.getId());
		MessageResponseDTO sucessMessage = personService.create(personDTO);
		
		assertEquals(expectedSucessMessage, sucessMessage);
	}
	
	private MessageResponseDTO createExpectedSucessMessage(Long savedPersonId) {
		return MessageResponseDTO.builder()
									.message("Person Successfully Created with ID " + savedPersonId)
									.build();
	}
}