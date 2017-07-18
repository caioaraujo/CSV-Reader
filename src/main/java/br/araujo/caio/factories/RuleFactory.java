package br.araujo.caio.factories;

import java.util.ArrayList;
import java.util.List;

import br.araujo.caio.rules.InputLengthRule;
import br.araujo.caio.rules.InputNameRule;
import br.araujo.caio.rules.InputRule;

/**
 * Cria um conjunto de regras especifico
 * 
 * @author Caio
 *
 */
public class RuleFactory {

	/**
	 * @return Listagem de regras para entrada de usuário
	 */
	public static List<InputRule> getInputRules() {

		List<InputRule> rules = new ArrayList<>();
		rules.add(new InputLengthRule());
		rules.add(new InputNameRule());
		return rules;
	}
}
