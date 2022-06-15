package br.com.gerenciamentoDeUsuarios.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import br.com.gerenciamentoDeUsuarios.dto.request.PersonDTO;
import br.com.gerenciamentoDeUsuarios.entity.Person;

@Mapper(componentModel = "spring")
public interface PersonMapper {
	
	@Mapping(target = "birthDate", source = "birthDate", dateFormat = "dd-MM-yyyy")
	Person toModel(PersonDTO personDTO);
	
	@Mapping(target = "birthDate", source = "birthDate", dateFormat = "dd-MM-yyyy")
	PersonDTO toDTO(Person person);
}