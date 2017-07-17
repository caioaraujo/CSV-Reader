package br.araujo.caio.services;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

import br.araujo.caio.exceptions.ResourceNotFoundException;

public interface CsvReaderService {

	static final String FILEPATH = "files/";

	/**
	 * Le um arquivo csv devolvendo um mapeamento contendo seu cabecalho e seus
	 * dados
	 * 
	 * @param fileName
	 *            Nome do arquivo (sem o caminho)
	 * @return Map<String, Object> onde: <br>
	 *         header - String com nome das colunas do arquivo separados por
	 *         virgula <br>
	 *         rows - Lista com as linhas encontradas no arquivo (sem o
	 *         cabecalho)
	 * @throws FileNotFoundException
	 * @throws ResourceNotFoundException
	 * @throws IOException
	 */
	Map<String, Object> read(String fileName) throws FileNotFoundException, ResourceNotFoundException, IOException;

}
