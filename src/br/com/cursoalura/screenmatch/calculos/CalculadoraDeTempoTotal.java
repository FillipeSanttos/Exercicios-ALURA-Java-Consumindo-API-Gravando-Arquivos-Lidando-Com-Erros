package br.com.cursoalura.screenmatch.calculos;

//Classe para juntar filmes/series selecionados e dizer o tempo total deles somados


import br.com.cursoalura.screenmatch.modelos.Titulos;

public class CalculadoraDeTempoTotal {
    private int tempoTotal;

    public int getTempoTotal() {
        return tempoTotal;
    }

//    public void incluiTempoFilmes(Filme f) {      //Método para somar duração de vários filmes
//        tempoTotal += f.getDuracaoEmMinutos();
//    }
//
//    public void incluiTempoFilmes(Serie s) {      //Método para somar duração de várias séries
//        tempoTotal += s.getDuracaoEmMinutos();
//    }

    public void incluiTempoFilmes(Titulos t){ //Método para somar duração de várias séries e filmes pq usa a super classe
        tempoTotal += t.getDuracaoEmMinutos();
    }
}
