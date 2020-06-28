package br.edu.unipampa.scpapp.Model;

import java.io.Serializable;

/**
 * Created by Sapo on 17/03/2017.
 */

public class Processo implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id_processo ;
    private String num_proc;
    private String num_controle;
    private String data;
    private String tipo;
    private String departamento;
    private String instituicao;
    private String requerente;
    private String nome;
    private String observacao;
    private String atendente;

    public Processo(Integer id_processo, String num_proc, String num_controle, String data,
                    String tipo, String departamento, String instituicao, String requerente,
                    String nome, String observacao, String atendente) {
        this.id_processo = id_processo;
        this.num_proc = num_proc;
        this.num_controle = num_controle;
        this.data = data;
        this.tipo = tipo;
        this.departamento = departamento;
        this.instituicao = instituicao;
        this.requerente = requerente;
        this.nome = nome;
        this.observacao = observacao;
        this.atendente = atendente;
    }

    public Processo() {
    }

    public Integer getId_processo() {
        return id_processo;
    }

    public void setId_processo(Integer id_processo) {
        this.id_processo = id_processo;
    }

    public String getNum_proc() {
        return num_proc;
    }

    public void setNum_proc(String num_proc) {
        this.num_proc = num_proc;
    }

    public String getNum_controle() {
        return num_controle;
    }

    public void setNum_controle(String num_controle) {
        this.num_controle = num_controle;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(String instituicao) {
        this.instituicao = instituicao;
    }

    public String getRequerente() {
        return requerente;
    }

    public void setRequerente(String requerente) {
        this.requerente = requerente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getAtendente() {
        return atendente;
    }

    public void setAtendente(String atendente) {
        this.atendente = atendente;
    }


    @Override
    public String toString() {
        return
                "id_processo=" + id_processo +
                "num_proc=" + num_proc +
                "num_controle=" + num_controle +
                "data=" + data  +
                "tipo=" + tipo +
                "departamento=" + departamento +
                "instituicao=" + instituicao +
                "requerente=" + requerente +
                "nome=" + nome +
                "observacao=" + observacao  +
                " atendente=" + atendente;
    }
}