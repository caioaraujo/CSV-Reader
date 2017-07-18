package br.araujo.caio.csvreaders;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

/**
 * 
 * 
 * @author Caio
 *
 */
public abstract class CsvReader {

	private BufferedReader fileContent;

	public CsvReader(BufferedReader fileContent) {
		this.fileContent = fileContent;
	}

	/**
	 * Le e retorna o cabeçalho do conteudo do arquivo csv
	 * 
	 * @return cabeçalho (primeira linha do arquivo)
	 * @throws IOException
	 */
	public String getHeader() throws IOException {
		return this.fileContent.readLine();
	}

	/**
	 * Le e retorna todas as linhas do arquivo subsequentes ao cabeçalho
	 * 
	 * @return
	 */
	public abstract List<Object> getRows();
}
