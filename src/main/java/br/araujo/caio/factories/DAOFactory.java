package br.araujo.caio.factories;

import java.util.List;

import br.araujo.caio.daos.CidadeDAO;
import br.araujo.caio.daos.CidadeDAOImpl;
import br.araujo.caio.models.Cidade;

public class DAOFactory {

	public static CidadeDAO getCidadeDAO(String header, List<Cidade> cidades) {
		return new CidadeDAOImpl(header, cidades);
	}

}
