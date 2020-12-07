package br.com.desafio.desafio.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.desafio.desafio.dto.request.BrandRequestDTO;
import br.com.desafio.desafio.dto.request.UpdateBrandRequestDTO;
import br.com.desafio.desafio.dto.response.BrandResponseDTO;
import br.com.desafio.desafio.dto.response.PatrimonyAndBrandResponseDTO;
import br.com.desafio.desafio.model.BrandEntity;
import br.com.desafio.desafio.model.PatrimonyEntity;
import br.com.desafio.desafio.repository.BrandRepository;
import br.com.desafio.desafio.repository.PatrimonyRepository;

@Service
public class BrandService {

	@Autowired
	private BrandRepository repository;

	@Autowired
	private PatrimonyRepository patrimonyRepository;

	public List<BrandEntity> getBrandAll() throws Exception {

		return createObjetctBrand(validBrand());

	}

	private List<BrandEntity> createObjetctBrand(List<BrandEntity> validBrand) {
		List<BrandEntity> listBrand = new ArrayList<>();
		validBrand.stream().forEach(brand -> {
			BrandResponseDTO responseDTO = new BrandResponseDTO();
			responseDTO.setMarcaId(brand.getMarcaId());
			responseDTO.setNome(brand.getNome());

			listBrand.add(brand);

		});
		return listBrand;
	}

	private List<BrandEntity> validBrand() throws Exception {
		List<BrandEntity> listBrand = repository.findAll();
		if (listBrand.isEmpty()) {
			throw new Exception("Não existe marca cadastrados");
		}
		return listBrand;
	}

	public BrandResponseDTO getBrand(Long id) throws Exception {

		BrandEntity brand = getBrandEntity(id);

		BrandResponseDTO responseDTO = new BrandResponseDTO();
		responseDTO.setMarcaId(brand.getMarcaId());
		responseDTO.setNome(brand.getNome());

		return responseDTO;
	}

	private BrandEntity getBrandEntity(Long id) throws Exception {
		Optional<BrandEntity> brandOptional = repository.findById(id);

		BrandEntity brand = brandOptional.orElseThrow(() -> new Exception("Marca não encontrada!"));
		return brand;
	}

	public void createBrand(BrandRequestDTO request) throws Exception {
		validateIfBrandExist(request.getNome());

		BrandEntity entity = new BrandEntity();
		entity.setNome(request.getNome());

		repository.save(entity);
	}

	private void validateIfBrandExist(String name) throws Exception {
		Optional<BrandEntity> brand = repository.findByNome(name);

		if (brand.isPresent()) {
			throw new Exception("Marca já cadastrada!");
		}

	}

	public List<PatrimonyAndBrandResponseDTO> getPatrimonyByBrand(Long id) throws Exception {

		return createPatrimonyAndBrandResponseList(validPatrimony(id));

	}

	private List<PatrimonyEntity> validPatrimony(Long id) throws Exception {
		List<PatrimonyEntity> listPatrimonys = patrimonyRepository.findByMarcaId(id);
		if (listPatrimonys.isEmpty()) {
			throw new Exception("Não existe patrimônios cadastrados para essa marca!");
		}
		return listPatrimonys;
	}
	
	private List<PatrimonyAndBrandResponseDTO> createPatrimonyAndBrandResponseList(List<PatrimonyEntity> listPatrimonys) throws Exception {
		
		List<PatrimonyAndBrandResponseDTO> listPatrimony = new ArrayList<>();
		
		 BrandEntity brandEntity = getBrandEntity(listPatrimonys.get(0).getMarcaId());

		listPatrimonys.stream().forEach(patrimony -> {
			PatrimonyAndBrandResponseDTO response = new PatrimonyAndBrandResponseDTO();
			response.setMarcaId(patrimony.getMarcaId());
			response.setName(patrimony.getNome());
			response.setDescription(patrimony.getDescricao());
			response.setNumber(patrimony.getNumeroTombo());
			response.setNameMarca(brandEntity.getNome());

			listPatrimony.add(response);
		});
		return listPatrimony;
	}

	public void updateBrand(Long id, UpdateBrandRequestDTO request) throws Exception {

		validateIfBrandExist(request.getNome());

		BrandEntity entity = getBrandEntity(id);
		entity.setNome(request.getNome());

		repository.save(entity);

	}

	public void deleteBrand(Long id) throws Exception {
		BrandEntity entity = getBrandEntity(id);

		repository.delete(entity);

	}

}
