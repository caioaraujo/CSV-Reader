package br.araujo.caio.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import br.araujo.caio.exceptions.ResourceNotFoundException;

public class TestCsvService {

	private static final String HEADER = "header";
	CsvService csvService;

	@Before
	public void setUp() {
		this.csvService = new CsvReaderServiceMock();
	}

	@Test
	public void testRead_cidadeCsv() throws FileNotFoundException, ResourceNotFoundException, IOException {
		Map<String, Object> result = this.csvService.read("cidades");
		assertNotNull(result);

		String expectedHeader = HEADER;
		Object obtainedHeader = result.get("header");
		assertTrue(obtainedHeader instanceof String);
		assertEquals(expectedHeader, obtainedHeader.toString());

		List<Object> obtainedRows = (List<Object>) result.get("rows");
		assertEquals(3, obtainedRows.size());
	}

	@Test(expected = ResourceNotFoundException.class)
	public void testRead_resourceNotFound() throws FileNotFoundException, ResourceNotFoundException, IOException {
		this.csvService = new CsvServiceImpl();
		this.csvService.read("xxx");
	}

	/**
	 * Mock da classe CsvReaderServiceImpl para poder substituir a leitura de
	 * bytes de um arquivo por um StringBuilder durante o teste
	 * 
	 * @author Caio
	 *
	 */
	class CsvReaderServiceMock extends CsvServiceImpl {

		@Override
		protected InputStream getCsvInputStream(String fileName)
				throws ResourceNotFoundException, FileNotFoundException {
			InputStream mockedInputStream = new ByteArrayInputStream(this.createCidadeFileContent());
			return mockedInputStream;
		}

		private byte[] createCidadeFileContent() {
			StringBuilder fileContent = new StringBuilder(HEADER);
			fileContent.append(
					"\n1,SC,Florianópolis,true,-88,88,Florianopolis,Floripa,Florianópolis,Grande Florianopolis,");
			fileContent.append("\n2,SC,Blumenau,,-99,99,Blumenau,,Blumenau,Blumenau");
			fileContent.append("\n3,PR,Curitiba,true,-66,66,Curitiba,,Curitiba,Grande Curitiba");

			return fileContent.toString().getBytes();
		}
	}

}
