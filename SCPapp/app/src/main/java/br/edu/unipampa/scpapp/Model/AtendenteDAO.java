package br.edu.unipampa.scpapp.Model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Sapo on 28/03/2017.
 */

public class AtendenteDAO  {

    private DBHelper helper;
    private Context ctx;
    private String table_name = "atendentes";
    private String[] colunas = new String[]{"id_atendente", "nome_atendente"};



    /**
     * Metodo Construtor
     *
     * @param ctx
     */
    public AtendenteDAO(Context ctx) {

        helper = new DBHelper(ctx);
        this.ctx = ctx;
    }
    /**
     *Metodo De inserção de processo no BD
     * @param atendente
     * @return
     */
    public boolean insert(Atendente atendente) {
        SQLiteDatabase db = new DBHelper(ctx).getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("nome_atendente" ,atendente.getNome_atendente());
        return (db.insert(table_name, null, values) > 0);
    }

}
