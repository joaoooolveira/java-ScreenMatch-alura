package br.com.alura.modelos;

public class Serie extends Titulo{
    private int temporadasDaSerie;
    private int episodiosPorTemporada;
    private int minutosPorEpisodio;
    private boolean serieAtiva;

    public Serie(String nome, int anoDeLancamento) {
        super(nome, anoDeLancamento);
    }

    public String toString(){
        return "Serie: " + this.getNomeTitulo() + "(" + this.getAnoDeLancamento() + ")";
    }

    public int getTemporadasDaSerie() {
        return temporadasDaSerie;
    }

    public void setTemporadasDaSerie(int temporadasDaSerie) {
        this.temporadasDaSerie = temporadasDaSerie;
    }

    public int getEpisodiosPorTemporada() {
        return episodiosPorTemporada;
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

    public boolean isSerieAtiva() {
        return serieAtiva;
    }

    public void setSerieAtiva(boolean serieAtiva) {
        this.serieAtiva = serieAtiva;
    }

    @Override
    public int getDuracaoEmMinutos() {
        return temporadasDaSerie * episodiosPorTemporada * minutosPorEpisodio;
    }
}
