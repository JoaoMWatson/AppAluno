package com.example.appaluno;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            //Criando o banco
            SQLiteDatabase bd = openOrCreateDatabase("dbAlunoCriar", MODE_PRIVATE, null);

            //Criando a tabela
            bd.execSQL("CREATE TABLE IF NOT EXISTS tbAluno (nome VARCHAR,email VARCHAR, telefone VARCHAR    )");

            //Inserindo dados na tabela
            bd.execSQL("INSERT INTO tbAluno(nome,email,telefone)VALUES('Maria','maria5203@gmail.com','1191236578')");
            bd.execSQL("INSERT INTO tbAluno(nome,email,telefone)VALUES('João','joao1365@gmail.com','11984751935')");
            bd.execSQL("INSERT INTO tbAluno(nome,email,telefone)VALUES('Ropgerio','tales9575@gmail.com','11993857644')");
            bd.execSQL("INSERT INTO tbAluno(nome,email,telefone)VALUES('João Pedo','joana9255@gmail.com','11911980364')");
            bd.execSQL("INSERT INTO tbAluno(nome,email,telefone)VALUES('Ana','joaquim8465@gmail.com','11987457661')");
            bd.execSQL("INSERT INTO tbAluno(nome,email,telefone)VALUES('Bruno','josefina0465@gmail.com','11919998564')");
            bd.execSQL("INSERT INTO tbAluno(nome,email,telefone)VALUES('Marcela','marcio1074@gmail.com','11964839944')");
            bd.execSQL("INSERT INTO tbAluno(nome,email,telefone)VALUES('Natalya','iradi1195@gmail.com','11983755778')");

            //Buscando os dados na tabela
            Cursor cursor = bd.rawQuery("SELECT nome, email, telefone FROM tbPessoas", null);

            //Extração dos valores
            int indiceNome = cursor.getColumnIndex("nome");
            int indiceEmail = cursor.getColumnIndex("email");
            int indiceTelefone = cursor.getColumnIndex("telefone");

            //Guia o cursor para frente da tabela
            cursor.moveToFirst();

            while (cursor != null) {
                Log.i("Resultado - nome", cursor.getString(indiceNome));
                Log.i("Resultado - email", cursor.getString(indiceEmail));
                Log.i("Resultado - telefone", cursor.getString(indiceTelefone));
                //Guia o cursor para frente de cada registro
                cursor.moveToNext();
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}