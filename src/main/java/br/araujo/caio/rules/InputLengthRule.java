package br.araujo.caio.rules;

public class InputLengthRule implements InputRule {

	@Override
	public Boolean isValid(String[] inputs) {
		// Nenhum comando informado
		if (inputs.length == 0)
			return false;

		// Quantidade minima de comandos invalida
		if (inputs.length < 2)
			return false;

		// Quantidade maxima de comandos invalida
		if (inputs.length > 3)
			return false;

		return true;
	}

}
