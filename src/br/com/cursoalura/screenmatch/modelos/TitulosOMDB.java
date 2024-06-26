package br.com.cursoalura.screenmatch.modelos;

//Pegar os dados que virão no JSON da API do OMDB

public record TitulosOMDB(String title, String year, String runtime) {
}
