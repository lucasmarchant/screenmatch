package br.com.alura.screenmatch;

import br.com.alura.screenmatch.service.ConsumoApi;
import br.com.alura.screenmatch.service.model.ConverteDados;
import br.com.alura.screenmatch.service.model.DadosEpisodio;
import br.com.alura.screenmatch.service.model.DadosSerie;
import br.com.alura.screenmatch.service.model.DadosTemporada;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

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

		//json = consumoApi.obterDados("https://www.omdbapi.com/?t=lost&season=1&episode=1&apikey=c5f423d6");
		DadosEpisodio dadosEpisodio = conversor.obterDados(json, DadosEpisodio.class);

		System.out.println(dadosEpisodio);

		List<DadosTemporada> temporadas = new ArrayList<>();

		for (int i = 1; i <= dados.totalTemporadas(); i++){
			json = consumoApi.obterDados("https://www.omdbapi.com/?t=lost&season=" + i + "&apikey=c5f423d6");
			DadosTemporada dadosTemporada = conversor.obterDados(json, DadosTemporada.class);
			temporadas.add(dadosTemporada);
		}
		temporadas.forEach(System.out::println);


	}
}
