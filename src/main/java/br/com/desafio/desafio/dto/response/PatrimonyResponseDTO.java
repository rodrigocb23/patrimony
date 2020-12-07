package br.com.desafio.desafio.dto.response;

public class PatrimonyResponseDTO {

	private Long tomboId;

	private Long marcaId;

	private String name;

	private String description;

	private Long number;

	public Long getTomboId() {
		return tomboId;
	}

	public void setTomboId(Long tomboId) {
		this.tomboId = tomboId;
	}

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

	public Long getNumber() {
		return number;
	}

	public void setNumber(Long number) {
		this.number = number;
	}

}
