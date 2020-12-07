package br.com.desafio.desafio.dto.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class PatrimonyRequestDTO {

	@NotBlank(message = "Informe um nome válido!")
	private String name;
	
	private String description;
	
	@NotNull
	private Long marcaId;

	public Long getMarcaId() {
		return marcaId;
	}

	public void setMarcaId(Long marcaId) {
		this.marcaId = marcaId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
