package br.edu.unipampa.scpapp.Model;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by JonerMello on 17/03/2017.
 */

public class ProcessoRepository {


    /* //preparando a classe DAO para conexao com webservice
    private static final String URL="";
    private static final String NAMESPACE="";

    private static final String INSERIR="";
    private static final String ATUALIZAR="";
    private static final String PESQUISAR_TODOS="";
    private static final String PESQUISAR_ID="";

    */
    private DBHelper helper;
    private Context ctx;
    private String table_name = "processos";
    private String tabelaCidadaos = "cidadaos";

    private String[] colunas = new String[]{"id_processo", "num_proc", "num_controle", "data_proc",
            "tipo", "departamento", "instituicao", "requerente", "observacao", "nome", "atendente"};

    /**
     * Metodo Construtor
     *
     * @param ctx
     */
    public ProcessoRepository(Context ctx) {

        helper = new DBHelper(ctx);
        this.ctx = ctx;
    }


    /**
     * Metodo De inserção de processo no BD
     *
     * @param processo
     * @return
     */
    public boolean insert(Processo processo) {
        SQLiteDatabase db = new DBHelper(ctx).getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("num_proc", processo.getNum_proc());
        values.put("num_controle", processo.getNum_controle());
        values.put("data_proc", processo.getData());
        values.put("tipo", processo.getTipo());
        values.put("departamento", processo.getDepartamento());
        values.put("instituicao", processo.getInstituicao());
        values.put("requerente", processo.getRequerente());
        values.put("observacao", processo.getObservacao());
        values.put("nome", processo.getNome());
        values.put("atendente", processo.getAtendente());

        Cursor cursor = db.rawQuery("SELECT* from processos where id_processo = " + processo.getId_processo(), null);

        if (cursor.getCount() == 0) {
            db.insert(table_name, null, values);
        } else {
            db.update(table_name, values, " id_processo = ? ", new String[]{String.valueOf(processo.getId_processo())});
        }

        return true;

    }

    /**
     * Metodo para verificar se existe  processo daquele cpf
     *
     * @param numeroProcesso
     * @return
     */
    public boolean existeProcessoCpf(String numeroProcesso, String cpf) {
        if (numeroProcesso.length() > 0) {


            SQLiteDatabase db = helper.getReadableDatabase();

            Cursor cursor;
            String strSql = "SELECT processos.num_controle, cidadaos.cpf_cidadao FROM processos " +
                    "INNER JOIN cidadaos ON (processos.requerente= cidadaos.id_cidadao) " +
                    "WHERE processos.num_controle = " + numeroProcesso + " AND cidadaos.cpf_cidadao = " + cpf;

            cursor = db.rawQuery(strSql, null);
            Log.e("Consulta", strSql);
            if (cursor.getCount() > 0) {
                return true;
            }
        }
        return false;
    }


    /**
     * busca o processo do cpf digitado
     *
     * @param numeroProcesso
     * @return
     */
    public Processo buscaProcessoNumeroCpf(String numeroProcesso, String cpf) {
        Processo processo = new Processo();
        SQLiteDatabase db = helper.getReadableDatabase();


        String[] args = new String[]{numeroProcesso, cpf};
        Log.e("BUSCA", numeroProcesso + " " + cpf + " ");
        String strSql = "SELECT processos.num_controle,processos.num_proc, processos.data_proc,processos.instituicao,processos.observacao,cid.nome_cidadao AS nome,req.nome_cidadao AS requerente, tipos.nome_tipo, departamentos.nome_dep, atendentes.nome_atendente " +
                " FROM processos JOIN cidadaos req ON (processos.requerente = req.id_cidadao) JOIN cidadaos cid ON (processos.nome = cid.id_cidadao)" +
                " JOIN tipos ON (processos.tipo = tipos.id_tipo)" +
                " JOIN departamentos ON (processos.departamento = departamentos.id_dep)" +
                " JOIN atendentes ON (processos.atendente = atendentes.id_atendente)" +
                " WHERE processos.num_controle = " + numeroProcesso + " AND  req.cpf_cidadao = " + cpf;

        Cursor cursor = db.rawQuery(strSql, null);

        if (cursor.getCount() > 0) {

            cursor.moveToPosition(-1);
            cursor.moveToNext();

            processo.setNum_proc(cursor.getString(cursor.getColumnIndex("num_proc")));
            processo.setNum_controle(cursor.getString(cursor.getColumnIndex("num_controle")));
            processo.setData(cursor.getString(cursor.getColumnIndex("data_proc")));
            processo.setTipo(cursor.getString(cursor.getColumnIndex("nome_tipo")));
            processo.setDepartamento(cursor.getString(cursor.getColumnIndex("nome_dep")));
            processo.setInstituicao(cursor.getString(cursor.getColumnIndex("instituicao")));
            processo.setRequerente(cursor.getString(cursor.getColumnIndex("requerente")));
            processo.setObservacao(cursor.getString(cursor.getColumnIndex("observacao")));
            processo.setNome(cursor.getString(cursor.getColumnIndex("nome")));
            processo.setAtendente(cursor.getString(cursor.getColumnIndex("nome_atendente")));

        }
        return processo;

    }


    /**
     * Metodo para verificar se existe  processo daquele cnpj
     *
     * @param numeroProcesso
     * @return
     */
    public boolean existeProcessoCnpj(String numeroProcesso, String cnpj) {
        if (numeroProcesso.length() > 0) {
            SQLiteDatabase db = helper.getReadableDatabase();

            Cursor cursor;
            String strSql = "SELECT processos.num_controle, cidadaos.cnpj_cidadao FROM processos " +
                    "INNER JOIN cidadaos ON (processos.requerente= cidadaos.id_cidadao) " +
                    "WHERE processos.num_controle = " + numeroProcesso + " AND cidadaos.cnpj_cidadao = " + cnpj;

            cursor = db.rawQuery(strSql, null);
            Log.e("Consulta", strSql);
            if (cursor.getCount() > 0) {
                return true;
            }
        }
        return false;
    }

    /**
     * busca o processo do cnpj digitado
     *
     * @param numeroProcesso
     * @return
     */
    public Processo buscaProcessoNumeroCnpj(String numeroProcesso, String cnpj) {
        Processo processo = new Processo();
        SQLiteDatabase db = helper.getReadableDatabase();


        String[] args = new String[]{numeroProcesso, cnpj};
        Log.e("BUSCA", numeroProcesso + " " + cnpj + " ");
        String strSql = "SELECT processos.num_controle,processos.num_proc, processos.data_proc,processos.instituicao,processos.observacao,cid.nome_cidadao AS nome,req.nome_cidadao AS requerente, tipos.nome_tipo, departamentos.nome_dep, atendentes.nome_atendente " +
                " FROM processos JOIN cidadaos req ON (processos.requerente = req.id_cidadao) JOIN cidadaos cid ON (processos.nome = cid.id_cidadao)" +
                " JOIN tipos ON (processos.tipo = tipos.id_tipo)" +
                " JOIN departamentos ON (processos.departamento = departamentos.id_dep)" +
                " JOIN atendentes ON (processos.atendente = atendentes.id_atendente)" +
                " WHERE processos.num_controle = " + numeroProcesso + " AND  req.cnpj_cidadao = " + cnpj;

        Cursor cursor = db.rawQuery(strSql, null);

        if (cursor.getCount() > 0) {

            cursor.moveToPosition(-1);
            cursor.moveToNext();

            processo.setNum_proc(cursor.getString(cursor.getColumnIndex("num_proc")));
            processo.setNum_controle(cursor.getString(cursor.getColumnIndex("num_controle")));
            processo.setData(cursor.getString(cursor.getColumnIndex("data_proc")));
            processo.setTipo(cursor.getString(cursor.getColumnIndex("nome_tipo")));
            processo.setDepartamento(cursor.getString(cursor.getColumnIndex("nome_dep")));
            processo.setInstituicao(cursor.getString(cursor.getColumnIndex("instituicao")));
            processo.setRequerente(cursor.getString(cursor.getColumnIndex("requerente")));
            processo.setObservacao(cursor.getString(cursor.getColumnIndex("observacao")));
            processo.setNome(cursor.getString(cursor.getColumnIndex("nome")));
            processo.setAtendente(cursor.getString(cursor.getColumnIndex("nome_atendente")));

        }
        return processo;


    }


    /**
     * lista todos os processos
     *
     * @param processo
     * @return
     */
    public List<Processo> mostraProcesso(Processo processo) {

        List<Processo> lista = new ArrayList();

        lista.add(processo);
        return lista;

    }


}