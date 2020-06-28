package br.edu.unipampa.scpapp.Model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Sapo on 28/03/2017.
 */

public class TipoDAO  {

    private DBHelper helper;
    private Context ctx;
    private String table_name = "tipos";

    private String[] colunas = new String[]{"id_tipo", "nome_tipo"};

    /**
     * Metodo Construtor
     *
     * @param ctx
     */
    public TipoDAO(Context ctx) {

        helper = new DBHelper(ctx);
        this.ctx = ctx;
    }
    /**
     *Metodo De inserção de processo no BD
     * @param tipo
     * @return
     */
    public boolean insert(Tipo tipo) {
        SQLiteDatabase db = new DBHelper(ctx).getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("nome_tipo" ,tipo.getNome_tipo());
        return (db.insert(table_name, null, values) > 0);
    }

}
