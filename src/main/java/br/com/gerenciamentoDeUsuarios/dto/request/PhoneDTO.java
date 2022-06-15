package br.com.gerenciamentoDeUsuarios.dto.request;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import br.com.gerenciamentoDeUsuarios.enums.PhoneType;

public class PhoneDTO {
	
	@Enumerated(EnumType.STRING)
	private PhoneType phoneType;
	
	@NotEmpty
	@Size(min = 13, max = 14)
	private String number;

	public PhoneType getPhoneType() {
		return phoneType;
	}

	public void setPhoneType(PhoneType phoneType) {
		this.phoneType = phoneType;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
}