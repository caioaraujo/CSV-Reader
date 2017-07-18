package br.araujo.caio.services;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
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
		File csvFile = this.getFile(FILEPATH + fileName);
		InputStream fileInputStream = new FileInputStream(csvFile);
		return fileInputStream;
	}

	private File getFile(String filePath) throws ResourceNotFoundException {

		// Busca o arquivo da pasta resources do projeto
		ClassLoader classLoader = getClass().getClassLoader();
		URL csvFile = classLoader.getResource(filePath);

		if (csvFile == null)
			throw new ResourceNotFoundException("Não foi possível encontrar o arquivo");

		return new File(csvFile.getFile());
	}

}
