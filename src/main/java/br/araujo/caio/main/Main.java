package br.araujo.caio.main;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import br.araujo.caio.enums.Input;
import br.araujo.caio.exceptions.ResourceNotFoundException;
import br.araujo.caio.factories.ServiceFactory;
import br.araujo.caio.models.Cidade;
import br.araujo.caio.services.CidadeService;
import br.araujo.caio.services.CsvReaderService;

public class Main {

	private static final String FILENAME = "cidades.csv";

	public static void main(String args[]) {

		System.out.println("Lendo arquivo " + FILENAME + "...");
		try {
			// Leitura do arquivo csv
			CsvReaderService csvReader = ServiceFactory.getCsvReaderService();
			Map<String, Object> fileContent = csvReader.read(FILENAME);
			String header = (String) fileContent.get("header");
			List<Cidade> cidades = (List<Cidade>) fileContent.get("rows");

			System.out.println("Arquivo processado.");
			StringBuilder instructions = new StringBuilder();
			instructions.append("Por favor, informe os comandos para consulta: \n");
			instructions.append("0 - Sair; \n");
			instructions.append("count * - Contagem total de registros importados; \n");
			instructions.append(
					"count distinct [nome da propriedade] - total de valores distintos da propriedade (coluna) enviada; \n");
			instructions.append(
					"filter [nome da propriedade] [valor] - linha de cabeçalho e todas as linhas em que a propriedade enviada possua o valor enviado.");

			System.out.println(instructions);

			// Leitura dos comandos de entrada do usuario
			Scanner sc = new Scanner(System.in);
			while (sc.hasNextLine()) {
				String inputSequence = sc.nextLine();
				if (Input.EXIT == Input.fromString(inputSequence)) {
					System.out.println("Execução finalizada");
					System.exit(0);
				}

				String[] inputs = inputSequence.split(" ");

				// Valida os comandos enviados
				CidadeService cidadeService = ServiceFactory.getCidadeService();
				Boolean isValid = cidadeService.isValid(inputs);
				if (!isValid) {
					System.out.println("Comando inválido. Por favor, tente novamente:");
					continue;
				}

				String firstInput = inputs[0];
				String secondInput = inputs[1];
				String thirdInput = null;

				if (inputs.length > 2)
					thirdInput = inputs[2];

				// Verifica se foi solicitada contagem de registros
				if (Input.COUNT == Input.fromString(firstInput)) {

					Integer total = cidadeService.count(cidades, secondInput, thirdInput);
					System.out.println("Total de registros encontrados: " + total);
				}

				// Verifica se foi solicitada filtragem dos registros
				if (Input.FILTER == Input.fromString(firstInput)) {
					String result = cidadeService.filter(header, cidades, secondInput, thirdInput);
					System.out.println(result);
				}

			}
			sc.close();

		} catch (FileNotFoundException e) {
			System.out.println("Falha ao ler arquivo: " + e.getMessage());
		} catch (ResourceNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

	}

}
