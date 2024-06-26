package br.com.cursoalura.DesafiosDoCurso.Desafio1;

//Crie um programa Java que faça uma consulta à API do TheMealDB utilizando as classes HttpClient, HttpRequest e HttpResponse. Solicite ao usuário que insira o nome de uma receita e exiba as informações disponíveis sobre essa receita.

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class PesquisaReceita {

    public void pesquisarReceita() throws IOException, InterruptedException {
        //Digitar nome de uma receita
        Scanner digitarTexto = new Scanner(System.in);
        System.out.println("Digite a receita que você deseja ver:");
        var nomeDaReceita = digitarTexto.nextLine();
        //DOCUMENTAÇÃO TheMealDB: **search.php?s=** para mostrar a receita escolhida
        String enderecoNoServidor = "https://www.themealdb.com/api/json/v1/1/search.php?s=" + nomeDaReceita;

        //HTTP CLIENT
        HttpClient client = HttpClient.newHttpClient();
        //HTTP REQUEST
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(enderecoNoServidor))
                .build();
        //HTTP RESPONSE
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        //Escrever JSON da pesquisa
        System.out.println(response.body());


    }
}
