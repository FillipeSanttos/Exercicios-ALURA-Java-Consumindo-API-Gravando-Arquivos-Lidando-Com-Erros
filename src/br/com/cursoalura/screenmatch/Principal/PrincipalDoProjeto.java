package br.com.cursoalura.screenmatch.Principal;

import br.com.cursoalura.screenmatch.calculos.CalculadoraDeTempoTotal;
import br.com.cursoalura.screenmatch.calculos.FiltroRecomendacao;
import br.com.cursoalura.screenmatch.modelos.Episodio;
import br.com.cursoalura.screenmatch.modelos.Filme;
import br.com.cursoalura.screenmatch.modelos.Serie;
import br.com.cursoalura.screenmatch.modelos.Titulos;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class PrincipalDoProjeto {
    public static void main(String[] args) {
        Filme filme01 = new Filme("Star Wars",1950);


//        filme01.titulo = "Star Wars";   *NAO PODE SER MODIFICADO DIRETAMENTE, ATRIBUTE PRIVATE
//        filme01.ano = 1950;   *NAO PODE SER MODIFICADO DIRETAMENTE, ATRIBUTE PRIVATE
//        filme01.incluidoNoPlano = true;   *NAO PODE SER MODIFICADO DIRETAMENTE, ATRIBUTE PRIVATE
//        filme01.quantidadeDeAvaliacoes = 1;   *NAO PODE SER MODIFICADO DIRETAMENTE, ATRIBUTE PRIVATE
//        filme01.valorTotalAvaliacoes = 10;    *NAO PODE SER MODIFICADO DIRETAMENTE, ATRIBUTE PRIVATE

       // filme01.setTitulo("Star Wars");    //*Modificar atributo privado através de setter
       /* filme01.setAno(1950);*/ //*Modificar atributo privado através de setter
        filme01.setIncluidoNoPlano(true); //*Modificar atributo privado através de setter
        filme01.setDuracaoEmMinutos(180); //*Modificar atributo privado através de setter

        filme01.adicionarAvaliacao(10);
        filme01.adicionarAvaliacao(9);
        filme01.adicionarAvaliacao(8);
        filme01.adicionarAvaliacao(7);

        filme01.exibeFichaTecnica();
        System.out.println("Média de Notas " + filme01.mediaDeNotas());
        System.out.println("Total de Avaliações: " + filme01.getValorTotalAvaliacoes());


        Serie serie01 = new Serie("Lost",2000);

/*        serie01.setTitulo("Lost");
        serie01.setAno(2000);*/
        serie01.setTemporadas(5);
        serie01.setEpisodiosPorTemporada(3);
        serie01.setMinutosPorEpisodio(30);


        System.out.println("Duração total em minutos da serie: " + serie01.getDuracaoEmMinutos());

        Filme filme02 = new Filme("Indiana Jones",1977);
      //  filme02.setTitulo("Indiana Jones");    //*Modificar atributo privado através de setter
       /* filme02.setAno(1977);*/ //*Modificar atributo privado através de setter
        filme02.setIncluidoNoPlano(true); //*Modificar atributo privado através de setter
        filme02.setDuracaoEmMinutos(100); //*Modificar atributo privado através de setter

        filme02.adicionarAvaliacao(10);
        filme02.adicionarAvaliacao(9);
        filme02.adicionarAvaliacao(8);
        filme02.adicionarAvaliacao(7);

        CalculadoraDeTempoTotal calculadora = new CalculadoraDeTempoTotal();
        calculadora.incluiTempoFilmes(filme01);
        calculadora.incluiTempoFilmes(filme02);
        calculadora.incluiTempoFilmes(serie01);
        System.out.println(calculadora.getTempoTotal());


        FiltroRecomendacao filtro = new FiltroRecomendacao();
        Episodio episodio01 = new Episodio();

        episodio01.setNome("Nome do Episodio");
        episodio01.setNumero(5);
        episodio01.setSerie(serie01);
        episodio01.setTotalVisualizações(300);

        filtro.filtrar(filme01);
        filtro.filtrar(filme02);
        filtro.filtrar(episodio01);

        //3° Curso:

        Filme filme03 = new Filme("Filme do Paulo",2003);
       // filme03.setTitulo("Filme do Paulo");
       /* filme03.setAno(2003);*/
        filme03.setDuracaoEmMinutos(44);
        filme03.setDiretor("Vileneve");
        filme03.adicionarAvaliacao(10);
        ArrayList<Titulos> listaDeAssistidos = new ArrayList<>();

        listaDeAssistidos.add(filme01);
        listaDeAssistidos.add(filme02);
        listaDeAssistidos.add(filme03);

        System.out.println(listaDeAssistidos.size());
        System.out.println(listaDeAssistidos.get(1).getTitulo());
        System.out.println(listaDeAssistidos);

        listaDeAssistidos.add(serie01);

        System.out.println(listaDeAssistidos);

        //Módulo para mostrar itens da lista um abaixo do outro
        for (Titulos item: listaDeAssistidos){
            System.out.println(item);
            //Mostrar classificação, configurar filme porque é o ÚNICO que tem a classificacao
            if (item instanceof Filme filme && filme.getClassificacao() > 2){
                System.out.println("Classificação: "+filme.getClassificacao());
            }
        }


        ArrayList <String> buscaPorArtista = new ArrayList<>();

        buscaPorArtista.add("Andre");
        buscaPorArtista.add("Joao");
        buscaPorArtista.add("Gabriela");

        //ordenar lista pelo nome em ordem alfabetica
        System.out.println(buscaPorArtista);
        Collections.sort(buscaPorArtista);
        System.out.println(buscaPorArtista);

        //ordenar lista pelo nome do titulo em ordem alfabetica
        System.out.println(listaDeAssistidos);
        Collections.sort(listaDeAssistidos);
        System.out.println(listaDeAssistidos);

        //ordenar lista pelo ano de lancamento
        listaDeAssistidos.sort(Comparator.comparing(Titulos::getAno));
        System.out.println(listaDeAssistidos);

        //4° Curso: INTEGRANDO COM UMA API











    }
}
