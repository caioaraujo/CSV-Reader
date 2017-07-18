package br.araujo.caio.daos;

public interface CidadeDAO {

	/**
	 * Calcula o total de registros encontrados na fonte de dados
	 * 
	 * @return total de ocorrencias
	 */
	Integer countTotal();

	/**
	 * Calcula o total de registros encontros pela propriedade especifica
	 * 
	 * @param property
	 *            - propriedade a ser considerada na contagem
	 * @return total de ocorrencias
	 */
	Integer countDistinct(String property);

	/**
	 * Filtra os registros pelo valor da propriedade indicada
	 * 
	 * @param property
	 *            - propriedade a ser filtrada
	 * @param value
	 *            - valor correspondente a propriedade
	 * @return Uma string contendo todos os resultados encontrados
	 */
	String filterValues(String property, String value);
}
