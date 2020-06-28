package br.edu.unipampa.scpapp.Model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sapo on 03/04/2017.
 */

public class AndamentoRepository {


    private DBHelper helper;
    private Context ctx;
    private String table_name = "andamentos";
    private String tabelaDepartamentos = "departamentos";

    private String[] colunas = new String[]{"id_anda", "data", "nome_dep", "ocorrencia", "despacho", "num_controle", "processo"};

    public AndamentoRepository(Context ctx) {
        helper = new DBHelper(ctx);
        this.ctx = ctx;
    }




    /**
     * Metodo para Listagem de todos os itens na Tabela Andamentos
     *
     * @return
     */
    public List<Andamento> lista(String numeroProcesso) {

        List<Andamento> lista = new ArrayList();
        Andamento andamento;
        SQLiteDatabase db = helper.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT id_anda, data ,nome_dep, ocorrencia , despacho, processo " +
                " FROM andamentos INNER JOIN departamentos ON departamentos.id_dep = andamentos.departamento " +
                " JOIN  processos ON processos.id_processo = andamentos.processo " +
                " WHERE processos.num_controle = " + numeroProcesso, null);



        while (cursor.moveToNext()) {
            andamento = new Andamento();
            andamento.setId_anda(cursor.getInt(0));
            andamento.setData(cursor.getString(1));
            andamento.setDepartamento(cursor.getString(2));
            andamento.setOcorrencia(cursor.getString(3));
            andamento.setDespacho(cursor.getString(4));
            andamento.setProcesso(cursor.getString(5));
            lista.add(andamento);


        }
        db.close();
        return lista;
    }

    public List<Andamento> listaDetalheAndamento(Integer id_anda) {

        List<Andamento> lista = new ArrayList();
        Andamento andamento;
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cursor;
        String detalhes =("SELECT  ocorrencia , despacho " +
                " FROM andamentos " +
               " WHERE andamentos.id_anda = " + id_anda);
        cursor = db.rawQuery(detalhes,null);
        Log.e("BUSCA Detalhes ID", detalhes+ " ");


        while (cursor.moveToNext()) {
            andamento = new Andamento();
            andamento.setOcorrencia(cursor.getString(0));
            andamento.setDespacho(cursor.getString(1));
            lista.add(andamento);


        }
        db.close();
        return lista;
    }


    /**
     * Metodo para verificar se existe  processo daquele cpf
     *
     * @param numeroProcesso
     * @return
     */
    public boolean existeAndamento(String numeroProcesso) {
        if (numeroProcesso.length() > 0) {


            SQLiteDatabase db = helper.getReadableDatabase();

            Cursor cursor;
            String strSql = "SELECT id_anda, data ,nome_dep, ocorrencia , despacho, processo " +
                    " FROM departamentos INNER JOIN andamentos ON departamentos.id_dep = andamentos.departamento " +
                    " JOIN  processos ON processos.id_processo = andamentos.processo WHERE processos.num_controle = " + numeroProcesso;


            cursor = db.rawQuery(strSql, null);
            Log.e("Consulta", strSql);
            if (cursor.getCount() > 0) {
                return true;
            }
        }
        return false;
    }

    /**
     * Metodo De inserção de andamento no BD
     *
     * @param andamento
     * @return
     */
    public boolean insert(Andamento andamento) {
        SQLiteDatabase db = new DBHelper(ctx).getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("data", andamento.getData().toString());
        values.put("departamento", andamento.getDepartamento());

        values.put("ocorrencia", andamento.getOcorrencia());
        values.put("despacho", andamento.getDespacho());
        values.put("processo", andamento.getProcesso());


        Cursor cursor = db.rawQuery("SELECT* from andamentos where id_anda = " + andamento.getId_anda(), null);

        if (cursor.getCount() == 0) {
            db.insert(table_name, null, values);
        } else {
            db.update(table_name, values, " id_anda = ? ", new String[]{String.valueOf(andamento.getId_anda())});
        }

        return true;

    }

    /**
     * busca o processo do cpf digitado
     *
     * @param numeroProcesso
     * @return
     */
    public List<Andamento>  buscaAndamentoPorProcesso(String numeroProcesso) {
        Andamento andamento = new Andamento();
        List<Andamento> lista = new ArrayList();
        SQLiteDatabase db = helper.getReadableDatabase();


        String[] args = new String[]{numeroProcesso};
        Log.e("BUSCA", numeroProcesso + " ");
        String strSql = "SELECT andamentos.id_anda, departamentos.nome_dep, andamentos.data, andamentos.ocorrencia, andamentos.despacho, andamentos.processo " +
                " FROM andamentos INNER JOIN departamentos ON departamentos.id_dep = andamentos.departamento" +
                " INNER JOIN processos ON processos.id_processo = andamentos.processo " +
                " WHERE processos.num_controle = " + numeroProcesso;

        Cursor cursor = db.rawQuery(strSql, null);
        Log.e("SQL", strSql + " ");
        Log.e("CURSOR", String.valueOf(cursor.getCount()));

        if (cursor.getCount() > 0) {

            cursor.moveToPosition(-1);
            cursor.moveToNext();
         do{
            andamento.setData(cursor.getString(cursor.getColumnIndex("data")));
            andamento.setDepartamento(cursor.getString(cursor.getColumnIndex("nome_dep")));
            andamento.setOcorrencia(cursor.getString(cursor.getColumnIndex("ocorrencia")));
            andamento.setDespacho(cursor.getString(cursor.getColumnIndex("despacho")));
            andamento.setProcesso(cursor.getString(cursor.getColumnIndex("processo")));
            lista.add(andamento);
            cursor.moveToNext();
            }while (!cursor.isLast());

        }
        return lista;

    }

    public void buscaDetalhesAndamento(){

    }

    /**
     * lista todos os andamentos
     *
     * @param andamento
     * @return
     */
    public List<Andamento> mostraAndamento(Andamento andamento) {

        List<Andamento> lista = new ArrayList();
        Log.e("BUSCA", lista.toString());
        lista.add(andamento);
        return lista;

    }


}


