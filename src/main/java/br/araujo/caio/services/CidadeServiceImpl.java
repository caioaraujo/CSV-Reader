package br.araujo.caio.services;

import java.util.List;

import br.araujo.caio.daos.CidadeDAO;
import br.araujo.caio.enums.Input;
import br.araujo.caio.factories.DAOFactory;
import br.araujo.caio.factories.RuleFactory;
import br.araujo.caio.models.Cidade;
import br.araujo.caio.rules.InputRule;

public class CidadeServiceImpl implements CidadeService {

	@Override
	public Integer count(List<Cidade> cidades, String condition, String property) {
		CidadeDAO cidadeDAO = this.getCidadeDAO(null, cidades);

		if (Input.ALL_LINES == Input.fromString(condition))
			return cidadeDAO.countTotal();
		return cidadeDAO.countDistinct(property);
	}

	@Override
	public String filter(String header, List<Cidade> cidades, String property, String value) {
		CidadeDAO cidadeDAO = this.getCidadeDAO(header, cidades);
		return cidadeDAO.filterValues(property, value);
	}

	@Override
	public Boolean isValid(String[] inputs) {

		for (InputRule rule : RuleFactory.getInputRules()) {
			if (!rule.isValid(inputs))
				return false;
		}

		return true;
	}

	protected CidadeDAO getCidadeDAO(String header, List<Cidade> cidades) {
		return DAOFactory.getCidadeDAO(header, cidades);
	}

}
