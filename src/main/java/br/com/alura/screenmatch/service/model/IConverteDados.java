package br.com.alura.screenmatch.service.model;

public interface IConverteDados {

    <T> T obterDados(String json, Class<T> classe);


}
