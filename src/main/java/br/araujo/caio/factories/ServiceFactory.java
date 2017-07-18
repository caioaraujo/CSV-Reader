package br.araujo.caio.factories;

import br.araujo.caio.services.CidadeService;
import br.araujo.caio.services.CidadeServiceImpl;
import br.araujo.caio.services.CsvService;
import br.araujo.caio.services.CsvServiceImpl;

public class ServiceFactory {

	public static CsvService getCsvReaderService() {
		return new CsvServiceImpl();
	}

	public static CidadeService getCidadeService() {
		return new CidadeServiceImpl();
	}

}
