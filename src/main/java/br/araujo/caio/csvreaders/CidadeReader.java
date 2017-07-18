package br.araujo.caio.csvreaders;

import java.io.BufferedReader;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import br.araujo.caio.enums.Uf;
import br.araujo.caio.models.Cidade;

/**
 * Responsavel pela leitura do arquivo cidades.csv
 * 
 * @author Caio
 *
 */
public class CidadeReader extends CsvReader {

	private BufferedReader fileContent;

	public CidadeReader(BufferedReader fileContent) {
		super(fileContent);
		this.fileContent = fileContent;
	}

	/**
	 * Le todas as linhas do arquivo (com exclusão do cabeçalho) e retorna como
	 * uma lista do modelo Cidade
	 * 
	 */
	@Override
	public List<Object> getRows() {
		return this.fileContent.lines().map(mapToItem).collect(Collectors.toList());
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
