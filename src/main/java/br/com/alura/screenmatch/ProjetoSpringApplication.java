package br.com.alura.screenmatch;

import br.com.alura.screenmatch.service.ConsumoApi;
import br.com.alura.screenmatch.service.model.ConverteDados;
import br.com.alura.screenmatch.service.model.DadosSerie;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProjetoSpringApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ProjetoSpringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		ConsumoApi consumoApi = new ConsumoApi();

		String json = consumoApi.obterDados("http://www.omdbapi.com/?t=lost&apikey=c5f423d6");

		//System.out.println(json);


		//String json2 = consumoApi.obterDados("https://coffee.alexflipnote.dev/random.json");
		//System.out.println(json2);

		ConverteDados conversor = new ConverteDados();

		DadosSerie dados = conversor.obterDados(json, DadosSerie.class);
		System.out.println(dados);




	}
}
