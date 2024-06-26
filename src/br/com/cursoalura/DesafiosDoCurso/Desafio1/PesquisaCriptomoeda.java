package br.com.cursoalura.DesafiosDoCurso.Desafio1;

//Crie um programa Java que utiliza as classes HttpClient, HttpRequest e HttpResponse para fazer uma consulta à API CoinGecko e exiba a cotação atual de uma criptomoeda escolhida pelo usuário.

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class PesquisaCriptomoeda {

    public void pesquisarCriptoCoinGekco() throws IOException, InterruptedException {

        //Digitar nome de criptomoeda
        Scanner digitarTexto = new Scanner(System.in);
        System.out.println("Digite a criptomoeda que você quer ver a cotação:");
        var nomeDaMoeda = digitarTexto.nextLine();
        //DOCUMENTAÇÃO COINGECKO: **simples/price?vs_currencies=usd&ids=** para mostrar a cotação simples de uma moeda
        String enderecoNoServidor = "https://api.coingecko.com/api/v3/simple/price?vs_currencies=usd&ids=" + nomeDaMoeda + "&x_cg_demo_api_key=CG-8dtkwfUbmgJAjULpGMMc8xst";

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
