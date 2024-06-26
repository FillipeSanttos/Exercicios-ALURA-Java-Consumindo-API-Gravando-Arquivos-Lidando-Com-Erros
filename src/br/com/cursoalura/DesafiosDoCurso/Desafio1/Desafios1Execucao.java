package br.com.cursoalura.DesafiosDoCurso.Desafio1;

import java.io.IOException;

//DESAFIO 1 - APRENDENDO APIs

public class Desafios1Execucao {
    public static void main(String[] args) throws IOException, InterruptedException {

        //DESAFIO 1 - ATIVIDADE 1
        PesquisaGoogleBooks novapesquisaLivro = new PesquisaGoogleBooks();
        novapesquisaLivro.pesquisarLivroNoGoogle();

        //DESAFIO 1 - ATIVIDADE 2
        PesquisaCriptomoeda novapesquisaCripto = new PesquisaCriptomoeda();
        novapesquisaCripto.pesquisarCriptoCoinGekco();

        //DESAFIO 1 - ATIVIDADE 3
        PesquisaReceita novapesquisaReceita = new PesquisaReceita();
        novapesquisaReceita.pesquisarReceita();
    }
}