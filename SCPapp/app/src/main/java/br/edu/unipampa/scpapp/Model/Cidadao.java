package br.edu.unipampa.scpapp.Model;


public class Cidadao {



    private Integer id_cidadao;
    private String cpf_Cidadao;
    private String cnpj_cidadao;
    private String nome_cidadao;


    public Cidadao(Integer id_cidadao, String cpf_Cidadao, String cnpj_cidadao, String nome_cidadao) {
        this.id_cidadao = id_cidadao;
        this.cpf_Cidadao = cpf_Cidadao;
        this.cnpj_cidadao = cnpj_cidadao;
        this.nome_cidadao = nome_cidadao;
    }

    public Cidadao() {
    }

    public Integer getId_cidadao() {
        return id_cidadao;
    }

    public void setId_cidadao(Integer id_cidadao) {
        this.id_cidadao = id_cidadao;
    }

    public String getCpf_Cidadao() {
        return cpf_Cidadao;
    }

    public void setCpf_Cidadao(String cpf_Cidadao) {
        this.cpf_Cidadao = cpf_Cidadao;
    }

    public String getCnpj_cidadao() {
        return cnpj_cidadao;
    }

    public void setCnpj_cidadao(String cnpj_cidadao) {
        this.cnpj_cidadao = cnpj_cidadao;
    }

    public String getNome_cidadao() {
        return nome_cidadao;
    }

    public void setNome_cidadao(String nome_cidadao) {
        this.nome_cidadao = nome_cidadao;
    }

    @Override
    public String toString() {
        return "Cidadao{" +
                "id_cidadao=" + id_cidadao +
                ", cpf_Cidadao='" + cpf_Cidadao + '\'' +
                ", cnpj_cidadao='" + cnpj_cidadao + '\'' +
                ", nome_cidadao='" + nome_cidadao + '\'' +
                '}';
    }
}