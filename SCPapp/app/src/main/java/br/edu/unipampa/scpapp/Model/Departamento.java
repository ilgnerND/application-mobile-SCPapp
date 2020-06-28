package br.edu.unipampa.scpapp.Model;

/**
 * Created by Sapo on 27/03/2017.
 */

public class Departamento {


    private Integer id_dep;
    private String nome_dep;

    public Departamento(Integer id_dep, String nome_dep) {
        this.id_dep = id_dep;
        this.nome_dep = nome_dep;
    }

    public Departamento() {
    }

    public Integer getId_dep() {
        return id_dep;
    }

    public void setId_dep(Integer id_dep) {
        this.id_dep = id_dep;
    }

    public String getNome_dep() {
        return nome_dep;
    }

    public void setNome_dep(String nome_dep) {
        this.nome_dep = nome_dep;
    }

    @Override
    public String toString() {
        return "Departamento{" +
                "id_dep=" + id_dep +
                ", nome_dep='" + nome_dep + '\'' +
                '}';
    }


}
