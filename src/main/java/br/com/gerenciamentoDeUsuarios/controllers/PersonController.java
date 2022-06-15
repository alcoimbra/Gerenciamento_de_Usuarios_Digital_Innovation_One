package br.com.gerenciamentoDeUsuarios.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.gerenciamentoDeUsuarios.dto.request.PersonDTO;
import br.com.gerenciamentoDeUsuarios.dto.response.MessageResponseDTO;
import br.com.gerenciamentoDeUsuarios.exception.PersonNotFoundException;
import br.com.gerenciamentoDeUsuarios.service.PersonService;
import lombok.AllArgsConstructor;

@RestController("/api/v1/person")
@AllArgsConstructor
public class PersonController {
	
	@Autowired
	private PersonService personService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public MessageResponseDTO create(@RequestBody @Valid PersonDTO personDTO) {
		return personService.create(personDTO);
	}
	
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public PersonDTO findById(@PathVariable Long id) throws PersonNotFoundException {
		return personService.findById(id);
	}
	
	@PostMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public MessageResponseDTO update(@PathVariable Long id, @RequestBody @Valid PersonDTO personDTO) throws PersonNotFoundException {
		return personService.update(id, personDTO);
	}
	
	@GetMapping
	public List<PersonDTO> listAll() {
		return personService.listAll();
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public MessageResponseDTO delete(@PathVariable Long id) throws PersonNotFoundException {
		return personService.delete(id);
	}
}