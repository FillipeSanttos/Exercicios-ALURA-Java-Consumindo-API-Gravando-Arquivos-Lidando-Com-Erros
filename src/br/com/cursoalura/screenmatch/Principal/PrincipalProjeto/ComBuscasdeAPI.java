package br.com.cursoalura.screenmatch.Principal.PrincipalProjeto;

import br.com.cursoalura.screenmatch.excessoes.ErrorDeConversaoDeAno;
import br.com.cursoalura.screenmatch.modelos.Titulos;
import br.com.cursoalura.screenmatch.modelos.TitulosOMDB;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ComBuscasdeAPI {
    public static void main(String[] args) throws IOException, InterruptedException {

        String buscando = "";
        List<Titulos> titulosAdicionar = new ArrayList<>();
        Scanner buscaDeNome = new Scanner(System.in);

        //Modificação para que, se o JSON começar com letra maiúscula, ele entender isso
        Gson novoGSON = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).setPrettyPrinting().create();



        while (!buscando.equalsIgnoreCase("sair")) {


            //Scanner para digitar o nome do filme para pesquisar, armazenar resposta em variavel que será colocada na requisição da API
            System.out.println("Digite um filme para busca:");
            var filmeEscolhido = buscaDeNome.nextLine();
            buscando = filmeEscolhido;

            if (buscando.equalsIgnoreCase("sair")){
                break;
            }

            String enderecoNoServidor = ("https://www.omdbapi.com/?t=" + filmeEscolhido.replace(" ", "+") + "&apikey=5feb3f14");

            try {
                //HTTP CLIENT criar um novo cliente
                HttpClient client = HttpClient.newHttpClient();

                //HTTP REQUEST para o servidor
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(enderecoNoServidor))
                        .build();

                //HTTP RESPONSE para receber os itens do servidor
                HttpResponse<String> response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());

                //Imprimir dados recebidos da API
                System.out.println(response.body());
                String arquivoJSONdaAPI = response.body();

                //Criação da dependencia da biblioteca GSON no intelij para integração no projeto
                //Modificação para que, se o JSON começar com letra maiúscula, ele entender isso
                /*Gson novoGSON = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).create();
*/
                //Colocando o JSON como um Titulo no projeto automaticamente
                Titulos novoTitulo = novoGSON.fromJson(arquivoJSONdaAPI, Titulos.class);

                //Puxando os dados através do Record
                TitulosOMDB novoTituloOMDB = novoGSON.fromJson(arquivoJSONdaAPI, TitulosOMDB.class);

                System.out.println(novoTitulo);
                System.out.println(novoTituloOMDB);

                //Convertendo o formato de dados da API para o meu estilo de Título

//        try {
                Titulos novoTituloAPI = new Titulos(novoTituloOMDB);
                System.out.println("Titulo já convertido");

                //Criar arquivo de texto externo com os dados pesquisados
//                FileWriter escreverArquivoDeTexto = new FileWriter("Filmes.txt");
//                escreverArquivoDeTexto.write(novoTituloAPI.toString());
//                escreverArquivoDeTexto.close();

                titulosAdicionar.add(novoTituloAPI);


                //O que vai acontecer se ele reconhecer algum erro das exceçôes abaixo:
            } catch (JsonSyntaxException e) {
                System.out.println("Aconteceu um erro de sinteaxe: ");
                System.out.println(e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Aconteceu um erro de numeral: ");
                System.out.println(e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println("Aconteceu um erro de argumento: ");
                System.out.println(e.getMessage());
            } catch (ErrorDeConversaoDeAno e) {
                System.out.println(e.getMensagem());
            }


        }



        //Criar arquivo de texto externo com os dados pesquisados
               FileWriter escreverArquivoDeTexto = new FileWriter("filmes.json");
               escreverArquivoDeTexto.write(novoGSON.toJson(titulosAdicionar));
               escreverArquivoDeTexto.close();

        System.out.println(titulosAdicionar);
    }
}
