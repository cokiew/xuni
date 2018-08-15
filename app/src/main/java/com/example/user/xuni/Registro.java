package com.example.user.xuni;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.app.Activity;
import android.widget.EditText;
import android.widget.Toast;
import android.annotation.SuppressLint;
import java.io.*;

public class Registro extends Activity {
    EditText text10,text11;
    Button b1,b2;
    bases database;
    String name,alias,pass;
    Double peso,alt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        text10= (EditText) findViewById(R.id.editUser10);
        text11= (EditText) findViewById(R.id.editUser11);
        b1=(Button) findViewById(R.id.btnguardar);
        b2=(Button) findViewById(R.id.btncancelar);
        text10.setText("");
        text11.setText("");
    }
    protected void onStart()
    {
        super.onStart();

    }
    protected void onResume()
    {
        super.onResume();
        try
        {
            database=new bases(getApplicationContext());
        }catch(Exception e){
            Toast.makeText(getApplicationContext(),"Error al crear la base  de datos", Toast.LENGTH_SHORT).show();
        }
    }
    protected void onStop()
    {
        super.onStop();
    }

    protected void onDestroy()
    {
        super.onDestroy();
    }
    public void insertar(View v)
    {
        alias=text10.getText().toString();
        pass=text11.getText().toString();
        if (alias!="" || pass!="")
        {

            try {

                SQLiteDatabase bd=database.getWritableDatabase();
                ContentValues values=new ContentValues();
                values.put("user",alias);
                values.put("password",pass);
                bd.insert("usuario",null,values);
                bd.close();
                Toast.makeText(getApplicationContext(),"usuario agregado", Toast.LENGTH_SHORT).show();
                text10.setText("");
                text11.setText("");
            }catch(Exception e)
            {
                Toast.makeText(getApplicationContext(),"Datos erroneos", Toast.LENGTH_SHORT).show();
            };
        }
        else
        {
            Toast.makeText(getApplicationContext(),"hay campos vacios", Toast.LENGTH_SHORT).show();
        }
    }
    public void limpia(View v)
    {
        text10.setText("");
        text11.setText("");
    }

}
