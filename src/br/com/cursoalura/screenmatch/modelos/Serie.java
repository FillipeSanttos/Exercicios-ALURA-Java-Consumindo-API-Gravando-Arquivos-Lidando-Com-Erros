package br.com.cursoalura.screenmatch.modelos;

public class Serie extends Titulos {
    private int temporadas;
    private int episodiosPorTemporada;
    private int minutosPorEpisodio;


    //Construtor personalizado: obrigatorio titulo e ano.
    public Serie(String titulo, int ano) {
        super(titulo, ano);
    }

    @Override
    public String toString() {
        return "Serie: " + this.getTitulo() + " (" + this.getAno() + ")";
    }


    public int getTemporadas() {
        return temporadas;
    }

    public int getEpisodiosPorTemporada() {
        return episodiosPorTemporada;
    }



    public void setTemporadas(int temporadas) {
        this.temporadas = temporadas;
    }

    public void setEpisodiosPorTemporada(int episodiosPorTemporada) {
        this.episodiosPorTemporada = episodiosPorTemporada;
    }

    public int getMinutosPorEpisodio() {
        return minutosPorEpisodio;
    }

    public void setMinutosPorEpisodio(int minutosPorEpisodio) {
        this.minutosPorEpisodio = minutosPorEpisodio;
    }

    @Override
    public int getDuracaoEmMinutos() {
        return temporadas*episodiosPorTemporada*minutosPorEpisodio;
    }
}

