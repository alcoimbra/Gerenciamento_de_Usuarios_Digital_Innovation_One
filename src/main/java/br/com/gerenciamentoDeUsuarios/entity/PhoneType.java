package br.com.gerenciamentoDeUsuarios.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PhoneType {
	
	HOME("Home"),
	MOBILE("Mobile"),
	COMMERCIAL("Commercial");
	
	private final String description;
	
	PhoneType(String description) {
		this.description = description;
	}
}