package br.com.cursoalura.screenmatch.excessoes;

public class ErrorDeConversaoDeAno extends RuntimeException {
    private String mensagem;

    public ErrorDeConversaoDeAno(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getMensagem() {
        return this.mensagem;
    }
}
