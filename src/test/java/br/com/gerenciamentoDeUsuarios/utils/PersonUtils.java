package br.com.gerenciamentoDeUsuarios.utils;

import java.time.LocalDate;
import java.util.Collections;

import br.com.gerenciamentoDeUsuarios.dto.request.PersonDTO;
import br.com.gerenciamentoDeUsuarios.entity.Person;

public class PersonUtils {
	
	private static final String FIRST_NAME = "Alan";
	private static final String LAST_NAME = "Coimbra";
	private static final String CPF_NUMBER = "080.427.878-47";
	private static final Long PERSON_ID = 1L;
	private static final LocalDate BIRTH_DATE = LocalDate.of(2022, 06, 15);
	
	public static PersonDTO createFakeDTO() {
		return PersonDTO.builder()
						.firstName(FIRST_NAME)
						.lastName(LAST_NAME)
						.cpf(CPF_NUMBER)
						.birthDate("16-06-2022")
						.phones(Collections.singletonList(PhoneUtils.createFakeDTO()))
						.build();
	}
	
	public static Person createFakeEntity() {
		return Person.builder()
						.id(PERSON_ID)
						.firstName(FIRST_NAME)
						.lastName(LAST_NAME)
						.cpf(CPF_NUMBER)
						.birthDate(BIRTH_DATE)
						.phones(Collections.singletonList(PhoneUtils.createFakeEntity()))
						.build();
	}
}