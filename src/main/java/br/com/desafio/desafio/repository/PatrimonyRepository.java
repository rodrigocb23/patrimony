package br.com.desafio.desafio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.desafio.desafio.model.PatrimonyEntity;

public interface PatrimonyRepository extends JpaRepository<PatrimonyEntity, Long>{
	
	List<PatrimonyEntity> findByMarcaId(Long marcaId);
	

}
