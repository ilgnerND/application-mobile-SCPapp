package br.edu.unipampa.scpapp.Model;

import java.io.Serializable;

/**
 * Created by Cristiane on 23/03/2017.
 */

public class Andamento implements Serializable {

    private Integer id_anda;
    private String processo;
    private String data;
    private String departamento;
    private String ocorrencia;
    private String despacho;

    public Andamento() {
    }

    public Andamento(Integer id_anda, String processo, String data, String departamento, String ocorrencia, String despacho) {
        this.id_anda = id_anda;
        this.processo = processo;
        this.data = data;
        this.departamento = departamento;
        this.ocorrencia = ocorrencia;
        this.despacho = despacho;
    }

    public Andamento(Integer id_anda, String data, String departamento, String ocorrencia, String despacho) {
        this.id_anda = id_anda;
        this.data = data;
        this.departamento = departamento;
        this.ocorrencia = ocorrencia;
        this.despacho = despacho;
    }




    public String getProcesso() {
        return processo;
    }

    public void setProcesso(String processo) {
        this.processo = processo;
    }

    public Integer getId_anda() {
        return id_anda;
    }

    public void setId_anda(Integer id_anda) {
        this.id_anda = id_anda;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getOcorrencia() {
        return ocorrencia;
    }

    public void setOcorrencia(String ocorrencia) {
        this.ocorrencia = ocorrencia;
    }

    public String getDespacho() {
        return despacho;
    }

    public void setDespacho(String despacho) {
        this.despacho = despacho;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Andamento andamento = (Andamento) o;

        return id_anda.equals(andamento.id_anda);

    }

    @Override
    public int hashCode() {
        return id_anda.hashCode();
    }

    @Override
    public String toString() {
        return "" + id_anda + "" + processo + "Data: " + data + "Departamento: " + departamento + "Ocorencia: " + ocorrencia +
                "Despacho: " + despacho;
    }
}
