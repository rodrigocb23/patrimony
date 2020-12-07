package br.com.desafio.desafio.controller;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import br.com.desafio.desafio.dto.request.PatrimonyRequestDTO;
import br.com.desafio.desafio.dto.response.PatrimonyResponseDTO;
import br.com.desafio.desafio.service.PatrimonyService;
import br.com.desafio.desafio.service.UploadService;

@Controller
@RequestMapping("/api/patrimonios")
public class PatrimonyController {

	@Autowired
	private PatrimonyService service;

	@Autowired
	private UploadService uploadService;

	@GetMapping
	public ResponseEntity<List<PatrimonyResponseDTO>> getPatrimonyAll() {

		try {
			return ResponseEntity.ok(service.getPatrimonyAll());
		} catch (Exception e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
		}

	}

	@GetMapping("/{id}")
	public ResponseEntity<PatrimonyResponseDTO> getPatrimony(@PathVariable Long id) {
		try {
			return ResponseEntity.ok(service.getPatrimony(id));
		} catch (Exception e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
		}

	}

	@PostMapping
	public ResponseEntity<?> createPatrimony(@RequestBody @Valid PatrimonyRequestDTO request) {

		try {
			service.createPatrimony(request);
			return ResponseEntity.ok(HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.CONFLICT);
		}

	}

	@PutMapping("/{id}")
	public ResponseEntity<?> updatePatrimony(@PathVariable Long id, @RequestBody @Valid PatrimonyRequestDTO request) {

		try {
			service.updatePatrimony(id, request);
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.CONFLICT);
		}

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletePatrimony(@PathVariable Long id) {

		try {
			service.deletePatrimony(id);
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
		}

	}

	@PostMapping("/upload")
	public ResponseEntity<String> upload(@RequestParam MultipartFile file) throws IOException {

		try {
			uploadService.uplo	ad(file);
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
