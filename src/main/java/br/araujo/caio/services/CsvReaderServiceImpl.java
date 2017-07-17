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
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import br.araujo.caio.enums.Uf;
import br.araujo.caio.exceptions.ResourceNotFoundException;
import br.araujo.caio.models.Cidade;

public class CsvReaderServiceImpl implements CsvReaderService {

	@Override
	public Map<String, Object> read(String fileName)
			throws FileNotFoundException, ResourceNotFoundException, IOException {
		File csvFile = this.getFile(FILEPATH + fileName);
		InputStream fileInputStream = new FileInputStream(csvFile);
		BufferedReader br = new BufferedReader(new InputStreamReader(fileInputStream));

		// Armazena o cabecalho do arquivo
		String header = br.readLine();
		// Armazena as linhas subsequentes
		List rows = br.lines().map(mapToItem).collect(Collectors.toList());
		br.close();

		Map<String, Object> result = new HashMap<>();
		result.put("header", header);
		result.put("rows", rows);
		return result;
	}

	private File getFile(String filePath) throws ResourceNotFoundException {

		// Busca o arquivo da pasta resources do projeto
		ClassLoader classLoader = getClass().getClassLoader();
		URL csvFile = classLoader.getResource(filePath);

		if (csvFile == null)
			throw new ResourceNotFoundException("Não foi possível encontrar o arquivo");

		return new File(csvFile.getFile());
	}

	private Function<String, Cidade> mapToItem = (line) -> {
		String[] p = line.split(",");
		Cidade cidade = new Cidade();
		cidade.setIbgeId(Long.parseLong(p[0]));
		cidade.setUf(Uf.valueOf(p[1]));
		cidade.setName(p[2]);
		cidade.setCapital(Boolean.parseBoolean(p[3]));
		cidade.setLongitude(Double.parseDouble(p[4]));
		cidade.setLatitude(Double.parseDouble(p[5]));
		cidade.setNoAccents(p[6]);
		cidade.setAlternativeNames(p[7]);
		cidade.setMicroregion(p[8]);
		cidade.setMesoregion(p[9]);

		return cidade;
	};

}
