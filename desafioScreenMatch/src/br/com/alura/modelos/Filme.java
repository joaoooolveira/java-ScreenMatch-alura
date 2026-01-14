package br.com.alura.modelos;

public class Filme extends Titulo{
    private String diretorDoFilme;

    public Filme(String nome, int anoDeLancamento){
        super(nome, anoDeLancamento);
    }

    public String getDiretorDoFilme() {
        return diretorDoFilme;
    }

    public void setDiretorDoFilme(String diretorDoFilme) {
        this.diretorDoFilme = diretorDoFilme;
    }

    @Override
        public String toString() {
        return "Filme: " + this.getNomeTitulo() + "(" + this.getAnoDeLancamento() + ")";
    }
}
