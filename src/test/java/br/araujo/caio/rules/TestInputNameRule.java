package br.araujo.caio.rules;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import br.araujo.caio.enums.Input;

public class TestInputNameRule {

	InputNameRule inputNameRule;

	@Before
	public void setUp() {
		this.inputNameRule = new InputNameRule();
	}

	@Test
	public void testIsValid_nullInput() {
		Boolean isValid = this.inputNameRule.isValid(null);
		assertFalse(isValid);
	}

	@Test
	public void testIsValid_emptyInput() {
		String[] inputs = {};
		Boolean isValid = this.inputNameRule.isValid(inputs);
		assertFalse(isValid);
	}

	@Test
	public void testIsValid_invalidFirstInput() {
		String[] inputs = { "aaa" };
		Boolean isValid = this.inputNameRule.isValid(inputs);
		assertFalse(isValid);
	}

	@Test
	public void testIsValid_invalidSecondInput() {
		String[] inputs = { Input.COUNT.getInput(), "aaa" };
		Boolean isValid = this.inputNameRule.isValid(inputs);
		assertFalse(isValid);
	}

	@Test
	public void testIsValid_invalidInputForFilter() {
		String[] inputs = { Input.FILTER.getInput(), "property" };
		Boolean isValid = this.inputNameRule.isValid(inputs);
		assertFalse(isValid);
	}

	@Test
	public void testIsValid_validInputForCount() {
		String[] inputs = { Input.COUNT.getInput(), Input.ALL_LINES.getInput() };
		Boolean isValid = this.inputNameRule.isValid(inputs);
		assertTrue(isValid);
	}

	@Test
	public void testValid_validInputForFilter() {
		String[] inputs = { Input.FILTER.getInput(), "ibge_id", "3" };
		Boolean isValid = this.inputNameRule.isValid(inputs);
		assertTrue(isValid);
	}

}
