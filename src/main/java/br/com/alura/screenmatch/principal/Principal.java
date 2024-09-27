package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.service.ConsumoApi;
import com.sun.jdi.PrimitiveValue;

import java.util.Scanner;

public class Principal {

    private ConsumoApi consumoApi = new ConsumoApi();
    private Scanner leitura = new Scanner(System.in);
    private final String ENDERECO = "https://www.omdbapi.com/?t=";
    private final String API_KEY = "&apikey=c5f423d6";

    public void exibeMenu(){
        System.out.println("Digite o nome da série para buscar");
        String nomeSerie = leitura.nextLine();

        String json = consumoApi.obterDados(ENDERECO + nomeSerie.replace(" ", "+") + API_KEY);
    }
}
