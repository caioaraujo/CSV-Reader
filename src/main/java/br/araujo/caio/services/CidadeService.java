package br.araujo.caio.services;

import java.util.List;

import br.araujo.caio.models.Cidade;

public interface CidadeService {

	/**
	 * Conta a quantidade de ocorrencias encontradas na listagem de cidades.
	 * 
	 * @param cidades
	 *            fonte de dados contendo todas as instancias de cidades para
	 *            pesquisar
	 * @param condition
	 *            condicao para contagem (* - todas as ocorrencias, distinct -
	 *            distincao por propriedade)
	 * @param property
	 *            (opcional) propriedade a ser considerada na contagem
	 * @return total de ocorrencias
	 */
	Integer count(List<Cidade> cidades, String condition, String property);

	/**
	 * Filtra as linhas onde coincidirem os valores nas suas respectivas
	 * propriedades.
	 * 
	 * @param header
	 *            cabecalho com o nome das colunas
	 * @param cidades
	 *            fonte de dados contendo todas as instancias de cidades para
	 *            pesquisar
	 * @param property
	 *            propriedade da listagem
	 * @param value
	 *            valor a ser filtrado
	 * @return
	 */
	String filter(String header, List<Cidade> cidades, String property, String value);

	/**
	 * Valida as strings de entrada do usuario
	 * 
	 * @param inputs
	 *            array de strings com as entradas utilizadas na ordem em que o
	 *            usuario deu entrada
	 * @return false caso alguma entrada esteja invalida.
	 */
	Boolean isValid(String inputs[]);

}
