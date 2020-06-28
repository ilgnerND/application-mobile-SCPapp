package br.edu.unipampa.scpapp.Model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Sapo on 28/03/2017.
 */

public class DepartamentoDAO {
    private DBHelper helper;
    private Context ctx;
    private String[] colunas = new String[]{"id_dep", "nome_dep"};


    private final String table_name = "departamentos";

    public DepartamentoDAO(Context ctx) {
        helper = new DBHelper(ctx);
        this.ctx = ctx;

    }


    /**
     *Metodo De inserção de processo no BD
     * @param tipo
     * @return
     */
    public boolean insert(Departamento departamento) {
        SQLiteDatabase db = new DBHelper(ctx).getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("nome_dep" ,departamento.getNome_dep());
        return (db.insert(table_name, null, values) > 0);
    }


}
