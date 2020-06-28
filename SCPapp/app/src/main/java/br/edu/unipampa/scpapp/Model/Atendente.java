package br.edu.unipampa.scpapp.Model;


public class Atendente {


    private Integer id_atendente;
    private String nome_atendente;

    public Atendente() {
    }

    public Atendente(Integer id_atendente, String nome_atendente) {
        this.id_atendente = id_atendente;
        this.nome_atendente = nome_atendente;
    }

    public Integer getId_atendente() {
        return id_atendente;
    }

    public void setId_atendente(Integer id_atendente) {
        this.id_atendente = id_atendente;
    }

    public String getNome_atendente() {
        return nome_atendente;
    }

    public void setNome_atendente(String nome_atendente) {
        this.nome_atendente = nome_atendente;
    }

    @Override
    public String toString() {
        return "Atendente{" +
                "id_atendente=" + id_atendente +
                ", nome_atendente='" + nome_atendente + '\'' +
                '}';
    }


}