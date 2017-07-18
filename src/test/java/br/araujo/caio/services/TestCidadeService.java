package br.araujo.caio.services;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.araujo.caio.daos.CidadeDAO;
import br.araujo.caio.daos.CidadeDAOImpl;
import br.araujo.caio.models.Cidade;

public class TestCidadeService {

	private static final Integer COUNT_ALL_TOTAL = 100;
	private static final Integer COUNT_DISTINCT_TOTAL = 30;
	private static final String FILTER_RESULT = "TEST";

	CidadeService cidadeService;

	@Before
	public void setUp() {
		this.cidadeService = new CidadeServiceMock();
	}

	@Test
	public void testCount_allLines() {
		Integer expectedValue = COUNT_ALL_TOTAL;
		Integer obtainedValue = this.cidadeService.count(null, "*", null);
		assertEquals(expectedValue, (Integer) obtainedValue);
	}

	@Test
	public void testCount_distinct() {
		Integer expectedValue = COUNT_DISTINCT_TOTAL;
		Integer obtainedValue = this.cidadeService.count(null, "ibge_id", "1");
		assertEquals(expectedValue, (Integer) obtainedValue);
	}

	@Test
	public void testFilter() {
		String expectedValue = FILTER_RESULT;
		String obtainedValue = this.cidadeService.filter(null, null, "ibge_id", "1");
		assertEquals(expectedValue, obtainedValue);
	}

	/**
	 * Mock do service original para nao utilizar as camadas mais internas do
	 * sistema e testar apenas o service
	 * 
	 * @author Caio
	 *
	 */
	class CidadeServiceMock extends CidadeServiceImpl {

		@Override
		protected CidadeDAO getCidadeDAO(String header, List<Cidade> cidades) {
			return new CidadeDAOMock(header, cidades);
		}

	}

	/**
	 * Mock do CidadeDAOImpl para retornar valores fixos dos metodos
	 * 
	 * @author Caio
	 *
	 */
	class CidadeDAOMock extends CidadeDAOImpl {
		public CidadeDAOMock(String header, List<Cidade> cidades) {
			super(header, cidades);
		}

		@Override
		public Integer countTotal() {
			return COUNT_ALL_TOTAL;
		}

		@Override
		public Integer countDistinct(String property) {
			return COUNT_DISTINCT_TOTAL;
		}

		@Override
		public String filterValues(String property, String value) {
			return FILTER_RESULT;
		}
	}

}
