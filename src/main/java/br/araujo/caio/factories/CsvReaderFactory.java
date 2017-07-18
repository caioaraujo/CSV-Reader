package br.araujo.caio.factories;

import java.io.BufferedReader;

import br.araujo.caio.csvreaders.CidadeReader;
import br.araujo.caio.csvreaders.CsvReader;

/**
 * Cria o leitor de csv a partir do nome
 * 
 * @author Caio
 *
 */
public class CsvReaderFactory {

	private static final String CIDADES = "cidades";

	public static CsvReader getCsvReader(String fileName, BufferedReader fileContent) {
		if (CIDADES.equalsIgnoreCase(fileName))
			return new CidadeReader(fileContent);
		return null;
	}

}
