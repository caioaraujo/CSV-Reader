package br.araujo.caio.rules;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class TestInputLengthRule {

	InputLengthRule inputLengthRule;

	@Before
	public void setUp() {
		this.inputLengthRule = new InputLengthRule();
	}

	@Test
	public void testIsValid_zeroLength() {
		String[] inputs = {};
		Boolean isValid = this.inputLengthRule.isValid(inputs);
		assertFalse(isValid);
	}

	@Test
	public void testIsValid_lowerThanExpected() {
		String[] inputs = { "aaa" };
		Boolean isValid = this.inputLengthRule.isValid(inputs);
		assertFalse(isValid);
	}

	@Test
	public void testIsValid_higherThanExpected() {
		String[] inputs = { "aaa", "bbb", "ccc", "ddd" };
		Boolean isValid = this.inputLengthRule.isValid(inputs);
		assertFalse(isValid);
	}

	@Test
	public void testIsValid_success() {
		String[] inputs = { "aaa", "bbb" };
		Boolean isValid = this.inputLengthRule.isValid(inputs);
		assertTrue(isValid);
	}

}
