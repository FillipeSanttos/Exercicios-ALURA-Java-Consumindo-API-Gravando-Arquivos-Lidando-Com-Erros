package br.com.cursoalura.screenmatch.modelos;

import br.com.cursoalura.screenmatch.calculos.Classificavel;

public class Episodio implements Classificavel {
    private String nome;
    private int numero;
    private Serie serie;
    private int totalVisualizações;

    public int getTotalVisualizações(int i) {
        return totalVisualizações;
    }

    public void setTotalVisualizações(int totalVisualizações) {
        this.totalVisualizações = totalVisualizações;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Serie getSerie() {
        return serie;
    }

    public void setSerie(Serie serie) {
        this.serie = serie;
    }

    //Regra de negócio arbitrária: se total de visualizações for maior que 100, retornar 4 estrelas, senão, retorne 2 estrelas
    @Override
    public int getClassificacao() {
        if (totalVisualizações>1000){
            return 4;
        } else {
            return 2;
        }
    }
}
