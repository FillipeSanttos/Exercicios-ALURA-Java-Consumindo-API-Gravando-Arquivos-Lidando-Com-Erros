package br.com.cursoalura.DesafiosDoCurso.Desafio1;

//1 - Crie um programa em Java que utilize as classes HttpClient, HttpRequest e HttpResponse para fazer uma consulta à API do Google Books. Solicite ao usuário que insira o título de um livro, e exiba as informações disponíveis sobre o livro retornado pela API.


import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class PesquisaGoogleBooks {

   public void pesquisarLivroNoGoogle() throws IOException, InterruptedException {
       //Digitar nome do filme
        Scanner digitarTexto = new Scanner(System.in);
        System.out.println("Digite o título de um livro para buscar:");
        var nomeDoFilme = digitarTexto.nextLine();
       //DOCUMENTAÇÃO GOOGLE BOOKS: **shttps://www.googleapis.com/books/v1/volumes?q=** para mostrar as informações de um livro
       String enderecoNoServidor = "https://www.googleapis.com/books/v1/volumes?q=" + nomeDoFilme + "&key=CG-8dtkwfUbmgJAjULpGMMc8xst";

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
