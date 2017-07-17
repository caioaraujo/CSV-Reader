package br.araujo.caio.factories;

import java.util.ArrayList;
import java.util.List;

import br.araujo.caio.rules.InputLengthRule;
import br.araujo.caio.rules.InputNameRule;
import br.araujo.caio.rules.InputRule;

public class RuleFactory {

	public static List<InputRule> getInputRules() {

		List<InputRule> rules = new ArrayList<>();
		rules.add(new InputLengthRule());
		rules.add(new InputNameRule());
		return rules;
	}
}
