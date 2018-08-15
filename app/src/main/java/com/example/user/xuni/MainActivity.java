package com.example.user.xuni;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.app.Activity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.annotation.SuppressLint;
import java.io.*;
public class MainActivity extends Activity {
    EditText text1,text2;
    bases database;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text1= (EditText) findViewById(R.id.edit1);
        text2= (EditText) findViewById(R.id.edit2);
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
    public void valida(View v)///valida usuario
    {
        String user=text1.getText().toString();
        String password=text2.getText().toString();
        SQLiteDatabase db=database.getReadableDatabase();
        String[] projection={"ID, user, password"};
        Cursor fila=db.query("usuario",projection,"user = ? AND password = ?",new String[]{user,password},null,null,null,null);
        try{
            if(fila.moveToFirst())
            {
                Intent intent = new Intent(MainActivity.this, Sesion.class);
                startActivity(intent);
            }
            else
                Toast.makeText(getApplicationContext(),"Usuario y/o contraseña incorrecto",Toast.LENGTH_SHORT).show();
            db.close();
            text1.setText("");
            text2.setText("");
        }catch (Exception e){Toast.makeText(getApplicationContext(),"Error de lectura",Toast.LENGTH_SHORT).show();}

    }
    public void registra(View v)///registro
    {
        Intent intent = new Intent(MainActivity.this, Registro.class);
        startActivity(intent);
    }

}

