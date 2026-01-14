package br.com.alura.modelos;

import br.com.alura.excecoes.ErroDeCriacaoDeTituloException;
import com.google.gson.annotations.SerializedName;

public class Titulo implements Comparable<Titulo>{
    @SerializedName("Title")
    private String nomeTitulo;
    @SerializedName("Year")
    private int anoDeLancamento;
    private boolean incluidoNoPlano;
    private double avaliacao;
    private int totalDeAvaliacoes;
    private int duracaoEmMinutos;

    public Titulo(String nomeTitulo, int anoDeLancamento){
        this.nomeTitulo = nomeTitulo;
        this.anoDeLancamento = anoDeLancamento;
    }

    public Titulo(TituloOMDB meuTituloOMDB){
        this.nomeTitulo = meuTituloOMDB.title();

        if(meuTituloOMDB.year().length() > 4){
            throw new ErroDeCriacaoDeTituloException("Não foi possivel converter este título");
        }
        this.anoDeLancamento = Integer.valueOf(meuTituloOMDB.year());
        this.duracaoEmMinutos = Integer.valueOf(meuTituloOMDB.runtime().substring(0,3));
    }

    public String getNomeTitulo() {
        return nomeTitulo;
    }

    public int getAnoDeLancamento() {
        return anoDeLancamento;
    }

    public boolean isIncluidoNoPlano() {
        return incluidoNoPlano;
    }

    public int getDuracaoEmMinutos() {
        return duracaoEmMinutos;
    }

    public int getTotalDeAvaliacoes() {
        return totalDeAvaliacoes;
    }

    public void setNomeTitulo(String nomeTitulo) {
        this.nomeTitulo = nomeTitulo;
    }

    public void setAnoDeLancamento(int anoDeLancamento) {
        this.anoDeLancamento = anoDeLancamento;
    }

    public void setDuracaoEmMinutos(int duracaoEmMinutos) {
        this.duracaoEmMinutos = duracaoEmMinutos;
    }

    public void setIncluidoNoPlano(boolean incluidoNoPlano) {
        this.incluidoNoPlano = incluidoNoPlano;
    }

    public void exibeFichaTecnica() {
        System.out.println("Título: " + nomeTitulo);
        System.out.println("Ano de lançamento: " + anoDeLancamento);
    }

    public void avaliarTitulo(double notaDoTitulo) {
        avaliacao += notaDoTitulo;
        totalDeAvaliacoes++;
    }

    public double returnMedias() {
        return avaliacao / totalDeAvaliacoes;
    }

    @Override
    public int compareTo(Titulo titulo) {
        return this.getNomeTitulo().compareTo(titulo.getNomeTitulo());
    }

    @Override
    public String toString() {
        return "(Titulo: " + nomeTitulo +
                ", Ano de lançamento: " + anoDeLancamento +
                ", Duração em minutos: " + duracaoEmMinutos + ")";
    }
}
