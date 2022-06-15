package br.com.gerenciamentoDeUsuarios.dto.request;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import br.com.gerenciamentoDeUsuarios.enums.PhoneType;

public class CreatePhoneDTO {
	
	@Enumerated(EnumType.STRING)
	private PhoneType phoneType;
	
	@NotEmpty
	@Size(min = 13, max = 14)
	private String number;
}