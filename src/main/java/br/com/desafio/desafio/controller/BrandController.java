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

import br.com.desafio.desafio.dto.request.BrandRequestDTO;
import br.com.desafio.desafio.dto.request.UpdateBrandRequestDTO;
import br.com.desafio.desafio.dto.response.BrandResponseDTO;
import br.com.desafio.desafio.dto.response.PatrimonyAndBrandResponseDTO;
import br.com.desafio.desafio.model.BrandEntity;
import br.com.desafio.desafio.service.BrandService;
import br.com.desafio.desafio.service.UploadService;

@Controller
@RequestMapping(value = "/api/marca")
public class BrandController {

	@Autowired
	private BrandService service;

	@Autowired
	private UploadService uploadService;

	@GetMapping
	public ResponseEntity<List<BrandEntity>> getBrandAll() {
		try {
			return ResponseEntity.ok(service.getBrandAll());
		} catch (Exception e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
		}

	}

	@GetMapping("/{id}")
	public ResponseEntity<BrandResponseDTO> getBrand(@PathVariable Long id) {

		try {
			return ResponseEntity.ok(service.getBrand(id));
		} catch (Exception e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
		}

	}

	@GetMapping("/{id}/patrimonio")
	public ResponseEntity<List<PatrimonyAndBrandResponseDTO>> getPatrimonyByBrand(@PathVariable Long id) {

		try {
			return ResponseEntity.ok(service.getPatrimonyByBrand(id));
		} catch (Exception e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
		}

	}

	@PostMapping
	public ResponseEntity<?> createBrand(@Valid @RequestBody BrandRequestDTO request) {

		try {
			service.createBrand(request);
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.CONFLICT);
		}

	}

	@PutMapping("/{id}")
	public ResponseEntity<?> updateBrand(@PathVariable Long id, @RequestBody UpdateBrandRequestDTO request) {

		try {
			service.updateBrand(id, request);
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
		}

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteBrand(@PathVariable Long id) {

		try {
			service.deleteBrand(id);

			return ResponseEntity.ok().build();
		} catch (Exception e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
		}

	}

	@PostMapping("/upload")
	public ResponseEntity<String> upload(@RequestParam MultipartFile file) throws IOException {

		try {
			uploadService.upload(file);
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
