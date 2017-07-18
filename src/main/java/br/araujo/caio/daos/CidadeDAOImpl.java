package br.araujo.caio.daos;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import br.araujo.caio.models.Cidade;

/**
 * Classe responsavel pelo acesso as informacoes de cidade
 * 
 * @author Caio
 *
 */
public class CidadeDAOImpl implements CidadeDAO {

	List<Cidade> cidades;
	String header;

	public CidadeDAOImpl(String header, List<Cidade> cidades) {
		this.header = header;
		this.cidades = cidades;
	}

	@Override
	public Integer countTotal() {
		if (cidades == null)
			return 0;
		return cidades.size();
	}

	@Override
	public Integer countDistinct(String property) {

		// Busca o metodo get do modelo Cidade relacionado a propriedade enviada
		String method = this.getMethodName(property);
		if (method == null)
			return 0;

		Set<Object> occurrences = new HashSet<Object>();
		for (Cidade cidade : cidades) {
			try {
				// Carrega e chama o metodo para recuperar o valor da
				// propriedade no modelo
				Method methodName = Cidade.class.getMethod(method);
				Object value = methodName.invoke(cidade);

				// Se encontrado, o valor é adicionado a um set list para
				// garantir a não-repetição do elemento na lista
				if (value != null)
					occurrences.add(value);
			} catch (NoSuchMethodException | SecurityException e) {
				e.printStackTrace();
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				e.printStackTrace();
			}

		}

		return occurrences.size();
	}

	@Override
	public String filterValues(String property, String value) {
		// Busca o metodo get do modelo Cidade relacionado a propriedade enviada
		String method = this.getMethodName(property);
		if (method == null || value == null)
			return "";

		// Inicia a string de retorno com o cabeçalho do arquivo carregado
		StringBuilder result = new StringBuilder(header);
		for (Cidade cidade : cidades) {
			try {
				// Através de reflexão, executa uma chamada ao método get do
				// modelo relacionado a propriedade enviada.
				Method methodName = Cidade.class.getMethod(method);
				Object obtainedValue = methodName.invoke(cidade);
				// Caso encontre o valor esperado, adiciona o conteudo de cidade
				// na string de retorno
				if (obtainedValue != null && value.equalsIgnoreCase(obtainedValue.toString())) {
					result.append("\n");
					result.append(cidade.toString());
				}

			} catch (NoSuchMethodException | SecurityException e) {
				e.printStackTrace();
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				e.printStackTrace();
			}
		}

		return result.toString();
	}

	private String getMethodName(String property) {
		if (property == null)
			return null;

		// Recupera o metodo get da classe cidade com base na propriedade
		// enviada
		Map<String, String> methodNames = Cidade.getMethodNamesMapping();
		return methodNames.get(property.toLowerCase());
	}

}
