package br.com.dio.challenge.domain;

// Define an abstract class, because it does not make sense to instantiate Conteudo directly
public abstract class Conteudo {
    // Define a constant for default XP
    protected static final double XP_PADRAO = 10d;
    private String titulo;
    private String descricao;

    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public abstract double calcularXp();
}
