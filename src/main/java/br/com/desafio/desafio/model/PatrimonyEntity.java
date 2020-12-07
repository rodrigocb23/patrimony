package br.com.desafio.desafio.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "patrimonio")
@SequenceGenerator(name = "seq_id_patrimonio", sequenceName = "seq_id_patrimonio", allocationSize = 1)
public class PatrimonyEntity implements Serializable {

	private static final long serialVersionUID = -2738995877020434406L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_id_patrimonio")
	@Column(name = "tombo_id")
	private Long numeroTombo;

	@Column(name = "marcaId")
	private Long marcaId;

	@Column(name = "nome")
	private String nome;

	@Column(name = "descricao")
	private String descricao;

	@ManyToMany
	@JoinTable(name = "patrimomio_marca",
		joinColumns = @JoinColumn(name = "patrimonio_id"),
		inverseJoinColumns = @JoinColumn(name = "marca_id"))
	private Set<BrandEntity> marcas = new HashSet<>();

	public Set<BrandEntity> getMarcas() {
		return marcas;
	}

	public void setMarcas(Set<BrandEntity> marcas) {
		this.marcas = marcas;
	}

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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Long getNumeroTombo() {
		return numeroTombo;
	}

	public void setNumeroTombo(Long numeroTombo) {
		this.numeroTombo = numeroTombo;
	}

}
