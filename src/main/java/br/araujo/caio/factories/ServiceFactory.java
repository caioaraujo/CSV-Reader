package br.araujo.caio.factories;

import br.araujo.caio.services.CidadeService;
import br.araujo.caio.services.CidadeServiceImpl;
import br.araujo.caio.services.CsvReaderService;
import br.araujo.caio.services.CsvReaderServiceImpl;

public class ServiceFactory {

	public static CsvReaderService getCsvReaderService() {
		return new CsvReaderServiceImpl();
	}

	public static CidadeService getCidadeService() {
		return new CidadeServiceImpl();
	}

}
