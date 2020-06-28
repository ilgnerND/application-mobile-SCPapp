package br.edu.unipampa.scpapp.Model;

/**
 * Created by Sapo on 27/03/2017.
 */

public class Tipo {


    private Integer id_tipo;
    private String nome_tipo;


    public Tipo(Integer id_tipo, String nome_tipo) {
        this.id_tipo = id_tipo;
        this.nome_tipo = nome_tipo;
    }

    public Tipo() {
    }

    public Tipo(String nome_tipo) {
        this.nome_tipo = nome_tipo;
    }

    public Integer getId_tipo() {
        return id_tipo;
    }

    public void setId_tipo(Integer id_tipo) {
        this.id_tipo = id_tipo;
    }

    public String getNome_tipo() {
        return nome_tipo;
    }

    public void setNome_tipo(String nome_tipo) {
        this.nome_tipo = nome_tipo;
    }

    @Override
    public String toString() {
        return "Tipo{" +
                "id_tipo=" + id_tipo +
                ", nome_tipo='" + nome_tipo + '\'' +
                '}';
    }
}
