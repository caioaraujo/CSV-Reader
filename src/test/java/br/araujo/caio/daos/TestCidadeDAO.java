package br.araujo.caio.daos;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.araujo.caio.enums.Uf;
import br.araujo.caio.factories.DAOFactory;
import br.araujo.caio.models.Cidade;

public class TestCidadeDAO {

	private static final String HEADER = "ibge_id,uf,name,capital,lon,lat,no_accents,alternative_names,microregion,mesoregion";

	CidadeDAO cidadeDAO;
	List<Cidade> cidades;

	@Before
	public void setUp() {
		this.cidades = this.getCidades();
		this.cidadeDAO = DAOFactory.getCidadeDAO(HEADER, cidades);
	}

	@Test
	public void testCountTotal() {
		Integer expectedValue = this.cidades.size();
		Integer obtainedValue = this.cidadeDAO.countTotal();
		assertEquals(expectedValue, obtainedValue);
	}

	@Test
	public void testCountTotal_nullList() {
		Integer expectedValue = 0;
		this.cidadeDAO = DAOFactory.getCidadeDAO(null, null);
		Integer obtainedValue = this.cidadeDAO.countTotal();
		assertEquals(expectedValue, obtainedValue);
	}

	@Test
	public void testCountTotal_emptyList() {
		Integer expectedValue = 0;
		this.cidadeDAO = DAOFactory.getCidadeDAO(null, new ArrayList<Cidade>());
		Integer obtainedValue = this.cidadeDAO.countTotal();
		assertEquals(expectedValue, obtainedValue);
	}

	@Test
	public void testCountDistinct_ibgeId() {
		Integer expectedValue = this.cidades.size();

		// lower case
		String property = "ibge_id";
		Integer obtainedValue = this.cidadeDAO.countDistinct(property);
		assertEquals(expectedValue, obtainedValue);

		// upper case
		property = "IBGE_ID";
		obtainedValue = this.cidadeDAO.countDistinct(property);
		assertEquals(expectedValue, obtainedValue);
	}

	@Test
	public void testCountDistinct_uf() {
		Integer expectedValue = 2;

		String property = "uf";
		Integer obtainedValue = this.cidadeDAO.countDistinct(property);
		assertEquals(expectedValue, obtainedValue);
	}

	@Test
	public void testCountDistinct_name() {
		Integer expectedValue = this.cidades.size();

		String property = "name";
		Integer obtainedValue = this.cidadeDAO.countDistinct(property);
		assertEquals(expectedValue, obtainedValue);
	}

	@Test
	public void testCountDistinct_capital() {
		Integer expectedValue = 1;

		String property = "capital";
		Integer obtainedValue = this.cidadeDAO.countDistinct(property);
		assertEquals(expectedValue, obtainedValue);
	}

	@Test
	public void testCountDistinct_longitude() {
		Integer expectedValue = this.cidades.size();

		String property = "longitude";
		Integer obtainedValue = this.cidadeDAO.countDistinct(property);
		assertEquals(expectedValue, obtainedValue);

		property = "lon";
		obtainedValue = this.cidadeDAO.countDistinct(property);
		assertEquals(expectedValue, obtainedValue);
	}

	@Test
	public void testCountDistinct_latitude() {
		Integer expectedValue = this.cidades.size();

		String property = "latitude";
		Integer obtainedValue = this.cidadeDAO.countDistinct(property);
		assertEquals(expectedValue, obtainedValue);

		property = "lat";
		obtainedValue = this.cidadeDAO.countDistinct(property);
		assertEquals(expectedValue, obtainedValue);
	}

	@Test
	public void testCountDistinct_noAccents() {
		Integer expectedValue = this.cidades.size();

		String property = "no_accents";
		Integer obtainedValue = this.cidadeDAO.countDistinct(property);
		assertEquals(expectedValue, obtainedValue);
	}

	@Test
	public void testCountDistinct_alternativeNames() {
		Integer expectedValue = 1;

		String property = "alternative_names";
		Integer obtainedValue = this.cidadeDAO.countDistinct(property);
		assertEquals(expectedValue, obtainedValue);
	}

	@Test
	public void testCountDistinct_microregion() {
		Integer expectedValue = this.cidades.size();

		String property = "microregion";
		Integer obtainedValue = this.cidadeDAO.countDistinct(property);
		assertEquals(expectedValue, obtainedValue);
	}

	@Test
	public void testCountDistinct_mesoregion() {
		Integer expectedValue = 3;

		String property = "mesoregion";
		Integer obtainedValue = this.cidadeDAO.countDistinct(property);
		assertEquals(expectedValue, obtainedValue);
	}

	@Test
	public void testCountDistinct_invalidProperty() {
		Integer expectedValue = 0;

		String property = "aaa";
		Integer obtainedValue = this.cidadeDAO.countDistinct(property);
		assertEquals(expectedValue, obtainedValue);
	}

	@Test
	public void testCountDistinct_nullProperty() {
		Integer expectedValue = 0;

		String property = null;
		Integer obtainedValue = this.cidadeDAO.countDistinct(property);
		assertEquals(expectedValue, obtainedValue);
	}

	@Test
	public void testFilterValues() {
		Integer expectedValue = 4;

		String property = "uf";
		String value = "sc";
		String obtainedValue = this.cidadeDAO.filterValues(property, value);
		String[] obtainedValueList = obtainedValue.split("\n");
		assertEquals(expectedValue, (Integer) obtainedValueList.length);
	}

	@Test
	public void testFilterValues_valueNotFound() {
		Integer expectedValue = 1;

		String property = "microregion";
		String value = "são paulo";
		String obtainedValue = this.cidadeDAO.filterValues(property, value);
		String[] obtainedValueList = obtainedValue.split("\n");
		assertEquals(expectedValue, (Integer) obtainedValueList.length);
	}

	@Test
	public void testFilterValues_propertyNotFound() {
		Integer expectedValue = 1;

		String property = "aaa";
		String value = "aaa";
		String obtainedValue = this.cidadeDAO.filterValues(property, value);
		String[] obtainedValueList = obtainedValue.split("\n");
		assertEquals(expectedValue, (Integer) obtainedValueList.length);
	}

	private List<Cidade> getCidades() {
		List<Cidade> cidades = new ArrayList<Cidade>();

		Cidade cidade = new Cidade();
		cidade.setIbgeId(1L);
		cidade.setUf(Uf.SC);
		cidade.setName("Florianópolis");
		cidade.setCapital(true);
		cidade.setLongitude(-12345D);
		cidade.setLatitude(123456D);
		cidade.setNoAccents("Florianopolis");
		cidade.setAlternativeNames("Nª Srª do Desterro");
		cidade.setMicroregion("Florianópolis");
		cidade.setMesoregion("Grande Florianópolis");
		cidades.add(cidade);

		cidade = new Cidade();
		cidade.setIbgeId(2L);
		cidade.setUf(Uf.SC);
		cidade.setName("Palhoça");
		cidade.setLongitude(-12346D);
		cidade.setLatitude(123457D);
		cidade.setNoAccents("Palhoca");
		cidade.setMicroregion("Palhoça");
		cidade.setMesoregion("Grande Florianópolis");
		cidades.add(cidade);

		cidade = new Cidade();
		cidade.setIbgeId(3L);
		cidade.setUf(Uf.SC);
		cidade.setName("Criciúma");
		cidade.setLongitude(-12355D);
		cidade.setLatitude(123458D);
		cidade.setNoAccents("Criciuma");
		cidade.setMicroregion("Criciuma");
		cidade.setMesoregion("Sul catarinense");
		cidades.add(cidade);

		cidade = new Cidade();
		cidade.setIbgeId(4L);
		cidade.setUf(Uf.PR);
		cidade.setName("Curitiba");
		cidade.setCapital(true);
		cidade.setLongitude(-12322D);
		cidade.setLatitude(1234512D);
		cidade.setNoAccents("Curitiba");
		cidade.setMicroregion("Curitiba");
		cidade.setMesoregion("Metropolitana de Curitiba");
		cidades.add(cidade);

		return cidades;
	}

}
