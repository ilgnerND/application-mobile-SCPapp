package br.edu.unipampa.scpapp.Model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Joner Mello on 28/03/2017.
 */

public class CidadaoDAO  {

    private DBHelper helper;
    private Context ctx;
    private String table_name = "cidadaos";

    private String[] colunas = new String[]{"id_cidadao", "nome_cidadao","cpf_cidadao","cnpj_cidadao"};

    /**
     * Metodo Construtor
     *
     * @param ctx
     */
    public CidadaoDAO(Context ctx) {

        helper = new DBHelper(ctx);
        this.ctx = ctx;
    }
    /**
     *Metodo De inserção de processo no BD
     * @param cidadao
     * @return
     */
    public boolean insert(Cidadao cidadao) {
        SQLiteDatabase db = new DBHelper(ctx).getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("nome_cidadao" ,cidadao.getNome_cidadao());
        values.put("cpf_cidadao" ,cidadao.getCpf_Cidadao());
        values.put("cnpj_cidadao" ,cidadao.getCnpj_cidadao());
        return (db.insert(table_name, null, values) > 0);
    }

}
