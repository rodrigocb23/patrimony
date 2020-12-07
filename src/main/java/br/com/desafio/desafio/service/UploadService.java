package br.com.desafio.desafio.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UploadService {

	@Value("${desafio.upload.file.path}")
	private String path;

	@Value("${desafio.upload.directory.files}")
	private String directory;

	public void upload(MultipartFile file) throws IOException {

		saveFile(directory, file);
	}

	private void saveFile(String directory, MultipartFile file) {

		Path directoryPath = Paths.get(path, directory);
		Path filePath = directoryPath.resolve(file.getOriginalFilename());

		try {
			Files.createDirectories(directoryPath);
			file.transferTo(filePath.toFile());
		} catch (IOException e) {
			throw new RuntimeException("Erro ao carregar o arquivo!");
		}

	}
}
