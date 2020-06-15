package com.example.appaluno;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Conexao extends SQLiteOpenHelper {


    public static final String NOME_DO_BANCO = "DbSqlite3H.db";
    public static final int VERSAO_DO_BANCO = 1;

    public Conexao(@Nullable Context context) {
        super(context, NOME_DO_BANCO, null, VERSAO_DO_BANCO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String cria_tabela = "CREATE TABLE tbpessoas(codigo INTEGER PRIMARY KEY, nome VARCHAR, email VARCHAR)";

        db.execSQL(cria_tabela);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}