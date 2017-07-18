package br.araujo.caio.enums;

/**
 * Contem os tipos possíveis de entrada do usuário
 * 
 * @author Caio
 *
 */
public enum Input {
	EXIT("0"), COUNT("count"), ALL_LINES("*"), DISTINCT("distinct"), FILTER("filter");

	private final String input;

	Input(String inputValue) {
		input = inputValue;
	}

	public String getInput() {
		return input;
	}

	public static Input fromString(String text) {
		for (Input value : Input.values()) {
			if (value.input.equalsIgnoreCase(text)) {
				return value;
			}
		}
		return null;
	}

}
