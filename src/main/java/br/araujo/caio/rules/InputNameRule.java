package br.araujo.caio.rules;

import br.araujo.caio.enums.Input;

public class InputNameRule implements InputRule {

	@Override
	public Boolean isValid(String[] inputs) {
		if (inputs == null || inputs.length == 0)
			return false;

		Input firstCommand = Input.fromString(inputs[0]);

		if (firstCommand == null)
			return false;

		// Primeiro comando incorreto
		if (Input.COUNT != firstCommand && Input.FILTER != firstCommand)
			return false;

		Input secondCommand = Input.fromString(inputs[1]);
		// Segundo comando para count incorreto
		if (Input.COUNT == firstCommand && Input.ALL_LINES != secondCommand && Input.DISTINCT != secondCommand)
			return false;

		// Terceiro comando para filter incorreto
		if (Input.FILTER == firstCommand && inputs.length != 3)
			return false;

		return true;
	}

}
