package br.com.gerenciamentoDeUsuarios.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SucessMessageDTO {
	
	private String message;
}