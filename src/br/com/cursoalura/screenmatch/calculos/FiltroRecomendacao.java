package br.com.cursoalura.screenmatch.calculos;

//Recomendações: se tiver avaliação acima de 4 estrelas, recomendar, acima de 2 avaliar, senão só colocar na lista

public class FiltroRecomendacao {

    public void filtrar(Classificavel classificavel){
        if (classificavel.getClassificacao() >=4){
            System.out.println("Esta entre os preferidos do momento.");
        } else if (classificavel.getClassificacao() >= 2) {
            System.out.println("Muito bem avaliado no momento");
        } else {
            System.out.println("Coloque na sua lista para assistir depois.");
        }
    }
}

