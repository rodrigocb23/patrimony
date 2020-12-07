package br.com.desafio.desafio.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.desafio.desafio.dto.request.PatrimonyRequestDTO;
import br.com.desafio.desafio.dto.response.PatrimonyResponseDTO;
import br.com.desafio.desafio.model.PatrimonyEntity;
import br.com.desafio.desafio.repository.PatrimonyRepository;

@Service
public class PatrimonyService {

	@Autowired
	private PatrimonyRepository repository;

	public List<PatrimonyResponseDTO> getPatrimonyAll() throws Exception {

		return createPatrimonyResponseList(validPatrimony());

	}

	private List<PatrimonyEntity> validPatrimony() throws Exception {
		List<PatrimonyEntity> listPatrimonys = repository.findAll();
		if (listPatrimonys.isEmpty()) {
			throw new Exception("Não existe patrimônios cadastrados");
		}
		return listPatrimonys;
	}

	private List<PatrimonyResponseDTO> createPatrimonyResponseList(List<PatrimonyEntity> listPatrimonys) {
		List<PatrimonyResponseDTO> listPatrimony = new ArrayList<>();

		listPatrimonys.stream().forEach(patrimony -> {
			PatrimonyResponseDTO response = new PatrimonyResponseDTO();
			response.setTomboId(patrimony.getNumeroTombo());
			response.setMarcaId(patrimony.getMarcaId());
			response.setName(patrimony.getNome());
			response.setDescription(patrimony.getDescricao());
			response.setNumber(patrimony.getNumeroTombo());

			listPatrimony.add(response);
		});
		return listPatrimony;
	}

	public PatrimonyResponseDTO getPatrimony(Long id) throws Exception {
		PatrimonyEntity patrimony = getPatrimonyEntity(id);

		return createPatrimonyResponse(patrimony);

	}

	private PatrimonyEntity getPatrimonyEntity(Long id) throws Exception {
		Optional<PatrimonyEntity> patrimonyOptional = repository.findById(id);

		PatrimonyEntity patrimony = patrimonyOptional.orElseThrow(() -> new Exception("Patrimônio não encontrado"));
		return patrimony;
	}

	private PatrimonyResponseDTO createPatrimonyResponse(PatrimonyEntity patrimony) {

		PatrimonyResponseDTO response = new PatrimonyResponseDTO();

		response.setMarcaId(patrimony.getMarcaId());
		response.setName(patrimony.getNome());
		response.setDescription(patrimony.getDescricao());
		response.setNumber(patrimony.getNumeroTombo());
		return response;
	}

	public void createPatrimony(PatrimonyRequestDTO request) throws Exception {

		savePatrimony(request);

	}

	private void savePatrimony(PatrimonyRequestDTO request) {
		PatrimonyEntity entity = new PatrimonyEntity();
		entity.setNome(request.getName());
		entity.setDescricao(request.getDescription());
		entity.setMarcaId(request.getMarcaId());

		repository.save(entity);
	}

	public void updatePatrimony(Long id, PatrimonyRequestDTO request) throws Exception {

		PatrimonyEntity entity = getPatrimonyEntity(id);

		entity.setDescricao(request.getDescription());
		entity.setMarcaId(request.getMarcaId());
		entity.setNome(request.getName());

		repository.save(entity);

	}

	public void deletePatrimony(Long id) throws Exception {
		PatrimonyEntity entity = getPatrimonyEntity(id);

		repository.delete(entity);

	}

}
