package br.com.gerenciamentoDeUsuarios.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.gerenciamentoDeUsuarios.dto.mapper.PersonMapper;
import br.com.gerenciamentoDeUsuarios.dto.request.PersonDTO;
import br.com.gerenciamentoDeUsuarios.dto.request.PhoneDTO;
import br.com.gerenciamentoDeUsuarios.entity.Person;
import br.com.gerenciamentoDeUsuarios.entity.Phone;
import br.com.gerenciamentoDeUsuarios.utils.PersonUtils;

@SpringBootTest
public class PersonMapperTest {
	
	@Autowired
	private PersonMapper personMapper;
	
	void testGivenPersonDTOThenReturnPersonEntity() {
		PersonDTO personDTO = PersonUtils.createFakeDTO();
		Person person = personMapper.toModel(personDTO);
		
		assertEquals(personDTO.getFirstName(), person.getFirstName());
		assertEquals(personDTO.getLastName(), person.getLastName());
		assertEquals(personDTO.getCpf(), person.getCpf());
		
		Phone phone = person.getPhones().get(0);
		PhoneDTO phoneDTO = personDTO.getPhones().get(0);
		
		assertEquals(phoneDTO.getPhoneType(), person.getPhones());
		assertEquals(phoneDTO.getNumber(), phone.getNumber());
	}
	
	void testGivenPersonEntityThenReturnPersonDTO() {
		Person person = PersonUtils.createFakeEntity();
		PersonDTO personDTO = personMapper.toDTO(person);
		
		assertEquals(person.getFirstName(), personDTO.getFirstName());
		assertEquals(person.getLastName(), personDTO.getLastName());
		assertEquals(person.getCpf(), personDTO.getCpf());
		
		Phone phone = person.getPhones().get(0);
		PhoneDTO phoneDTO = personDTO.getPhones().get(0);
		
		assertEquals(phone.getType(), phoneDTO.getPhoneType());
		assertEquals(phone.getNumber(), phoneDTO.getNumber());
	}
}