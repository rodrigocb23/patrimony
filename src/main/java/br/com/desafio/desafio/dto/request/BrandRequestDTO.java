package br.com.desafio.desafio.dto.request;



import javax.validation.constraints.NotBlank;

public class BrandRequestDTO {

	@NotBlank(message = "Informa um nome válido!")
	private String nome;


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
