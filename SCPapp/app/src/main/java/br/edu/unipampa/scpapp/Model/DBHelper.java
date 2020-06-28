package br.edu.unipampa.scpapp.Model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by JonerMello on 17/03/2017.
 */

/**
 * DBHelper classe responsável por criar a base de dados no momento em que a aplicação é instalada
 */
public class DBHelper extends SQLiteOpenHelper {

    protected SQLiteDatabase database;

    // Define o nome da base de dados e a versão.
    private static final String DATABASE_NAME="DB3";
    private static final int DATABASE_VERSION=3;

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {



       db.execSQL("CREATE TABLE atendentes (id_atendente INTEGER PRIMARY KEY AUTOINCREMENT,nome_atendente VARCHAR(255));");

        db.execSQL("CREATE TABLE cidadaos (id_cidadao INTEGER PRIMARY KEY AUTOINCREMENT , nome_cidadao VARCHAR(255), cpf_cidadao VARCHAR(15), cnpj_cidadao VARCHAR(20));");

        db.execSQL("CREATE TABLE departamentos (id_dep INTEGER PRIMARY KEY AUTOINCREMENT , nome_dep VARCHAR(255));");

        db.execSQL("CREATE TABLE tipos (id_tipo INTEGER PRIMARY KEY AUTOINCREMENT , nome_tipo VARCHAR(255));");

        db.execSQL("CREATE TABLE processos (id_processo INTEGER PRIMARY KEY AUTOINCREMENT,num_proc  VARCHAR (255),num_controle VARCHAR (255),data_proc DATETIME,tipo INTEGER,departamento INTEGER,instituicao  VARCHAR (255),requerente   INTEGER,observacao   LONGTEXT,nome INTEGER,atendente INTEGER REFERENCES atendentes (id_atendente),FOREIGN KEY (tipo)REFERENCES tipos (id_tipo),FOREIGN KEY (departamento)REFERENCES departamentos (id_dep),FOREIGN KEY (requerente)REFERENCES cidadaos (id_cidadao),FOREIGN KEY ( nome)REFERENCES cidadaos (id_cidadao) );");

        db.execSQL("CREATE TABLE andamentos (id_anda INTEGER  PRIMARY KEY AUTOINCREMENT, data   DATETIME, ocorrencia   VARCHAR, despacho     VARCHAR, departamento INTEGER  REFERENCES departamentos (id_dep), processo     INTEGER  REFERENCES processos (id_processo), FOREIGN KEY (departamento)REFERENCES departamentos (id_dep));");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
      db.execSQL("DROP TABLE IF EXISTS atendentes");
        db.execSQL("DROP TABLE IF EXISTS cidadaos");
        db.execSQL("DROP TABLE IF EXISTS departamentos");
        db.execSQL("DROP TABLE IF EXISTS tipos");
        db.execSQL("DROP TABLE IF EXISTS processos");
        db.execSQL("DROP TABLE IF EXISTS andamentos");
        onCreate(db);
    }

    public SQLiteDatabase getDatabase() {
        if (database == null) {
            database = getWritableDatabase();
        }
        return database;
    }


}
