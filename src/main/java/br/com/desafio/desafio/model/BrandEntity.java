package br.com.desafio.desafio.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "marca")
@SequenceGenerator(name = "seq_id_marca", sequenceName = "seq_id_marca", allocationSize = 1)
public class BrandEntity implements Serializable {

	private static final long serialVersionUID = -2286625709215873563L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_id_marca")
	@Column(name = "marca_id")
	private Long marcaId;

	@Column(name = "nome")
	private String nome;

	public Long getMarcaId() {
		return marcaId;
	}

	public void setMarcaId(Long marcaId) {
		this.marcaId = marcaId;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
