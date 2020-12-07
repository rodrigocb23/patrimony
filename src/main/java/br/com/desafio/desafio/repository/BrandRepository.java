package br.com.desafio.desafio.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.desafio.desafio.model.BrandEntity;

public interface BrandRepository extends JpaRepository<BrandEntity, Long>{
	
	Optional<BrandEntity> findByNome(String nome);

}
