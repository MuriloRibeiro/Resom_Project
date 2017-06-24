package com.htcursos.resom.migration;

import android.database.sqlite.SQLiteDatabase;

import se.emilsjolander.sprinkles.Migration;

/**
 * Created by Murilo Ribeiro on 24/06/2017.
 */

public class ClienteMigration extends Migration {
    @Override
    protected void doMigration(SQLiteDatabase db) {
       db.execSQL("CREATE TABLE cliente(" + "id INTEGER PRIMARY KEY AUTOINCREMENT," +
               "nome TEXT," +
               "email TEXT," +
               "cpf TEXT," +
               "cel TEXT," +
               "image INTEGER)");
    }
}
