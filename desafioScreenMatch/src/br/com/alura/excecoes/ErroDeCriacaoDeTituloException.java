package br.com.alura.excecoes;

public class ErroDeCriacaoDeTituloException extends RuntimeException {
    private String mensagem;

    public ErroDeCriacaoDeTituloException(String mensagemDeErro) {
        this.mensagem = mensagemDeErro;
    }

    public String getMensagem() {
        return this.mensagem;
    }
}
