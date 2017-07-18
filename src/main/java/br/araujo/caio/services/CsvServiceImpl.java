package br.araujo.caio.services;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import br.araujo.caio.csvreaders.CsvReader;
import br.araujo.caio.exceptions.ResourceNotFoundException;
import br.araujo.caio.factories.CsvReaderFactory;

public class CsvServiceImpl implements CsvService {

	@Override
	public Map<String, Object> read(String fileName)
			throws FileNotFoundException, ResourceNotFoundException, IOException {

		InputStream fileInputStream = this.getCsvInputStream(fileName);
		BufferedReader br = new BufferedReader(new InputStreamReader(fileInputStream));

		String fileNamePrefix = fileName.split("\\.")[0];
		CsvReader csvReader = CsvReaderFactory.getCsvReader(fileNamePrefix, br);

		Map<String, Object> result = new HashMap<>();
		result.put("header", csvReader.getHeader());
		result.put("rows", csvReader.getRows());
		return result;
	}

	protected InputStream getCsvInputStream(String fileName) throws ResourceNotFoundException, FileNotFoundException {
		InputStream fileInputStream = this.getFileInputStream(FILEPATH + fileName);
		return fileInputStream;
	}

	private InputStream getFileInputStream(String filePath) throws ResourceNotFoundException {

		// Busca o arquivo da pasta resources do projeto
		InputStream inputStream = getClass().getResourceAsStream(filePath);

		if (inputStream == null)
			throw new ResourceNotFoundException("Não foi possível encontrar o arquivo");

		return inputStream;
	}

}
