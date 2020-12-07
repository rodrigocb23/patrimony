package br.com.desafio.desafio.dto.response;

public class PatrimonyAndBrandResponseDTO {

	private Long marcaId;

	private String nameMarca;

	private String name;

	private String description;

	private Long number;

	public Long getMarcaId() {
		return marcaId;
	}

	public void setMarcaId(Long marcaId) {
		this.marcaId = marcaId;
	}

	public String getNameMarca() {
		return nameMarca;
	}

	public void setNameMarca(String nameMarca) {
		this.nameMarca = nameMarca;
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

	public Long getNumber() {
		return number;
	}

	public void setNumber(Long number) {
		this.number = number;
	}

}
