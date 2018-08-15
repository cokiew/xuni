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
public class TomaMuestras extends Activity {

    EditText text1,text2,text3,text4,text5,text6,text7,text8,text9,text10,text11;
    Button b1,b2;
    int ID=-1;
    bases database;
    String name,lastname,dir,tel,email,enfermedad,med,alias,pass;
    Double peso,alt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.toma_muestras);
        text1= (EditText) findViewById(R.id.editUser1);
        text2= (EditText) findViewById(R.id.editUser2);
        text3= (EditText) findViewById(R.id.editUser3);
        text4= (EditText) findViewById(R.id.editUser4);
        text5= (EditText) findViewById(R.id.editUser5);
        text6= (EditText) findViewById(R.id.editUser6);
        text7= (EditText) findViewById(R.id.editUser7);
        text8= (EditText) findViewById(R.id.editUser8);
        text9= (EditText) findViewById(R.id.editUser9);
        text10= (EditText) findViewById(R.id.editUser10);
        text11= (EditText) findViewById(R.id.editUser11);
        b1=(Button) findViewById(R.id.btnguardar);
        b2=(Button) findViewById(R.id.btncancelar);
        text1.setText("");
        text2.setText("");
        text3.setText("");
        text4.setText("");
        text5.setText("");
        text6.setText("");
        text7.setText("");
        text8.setText("");
        text9.setText("");
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

        name=text1.getText().toString();
        lastname=text2.getText().toString();
        dir=text3.getText().toString();
        tel=text4.getText().toString();
        email=text5.getText().toString();
        enfermedad=text8.getText().toString();
        med=text9.getText().toString();
        alias=text10.getText().toString();
        pass=text11.getText().toString();
        if (name!="" || lastname!="" || dir!="" || tel!="" || email!="" || enfermedad!="" ||med!="" || alias!="" || pass!="")
        {

            try {
                alt = Double.parseDouble(text6.getText().toString());
                peso = Double.parseDouble(text7.getText().toString());
                SQLiteDatabase bd=database.getWritableDatabase();
                ContentValues values=new ContentValues();
                values.put("nombre",name);
                values.put("apellidos",lastname);
                values.put("direccion",dir);
                values.put("telefono",tel);
                values.put("correo",email);
                values.put("enfermedad",enfermedad);
                values.put("medicamento",med);
                values.put("peso",peso);
                values.put("altura",alt);
                values.put("user",alias);
                values.put("password",pass);
                bd.insert("usuario",null,values);
                bd.close();
                Toast.makeText(getApplicationContext(),"usuario agregado", Toast.LENGTH_SHORT).show();
                text1.setText("");
                text2.setText("");
                text3.setText("");
                text4.setText("");
                text5.setText("");
                text6.setText("");
                text7.setText("");
                text8.setText("");
                text9.setText("");
                text10.setText("");
                text11.setText("");
            }catch(Exception e)
            {
                Toast.makeText(getApplicationContext(),"peso y/o estatura erroneo", Toast.LENGTH_SHORT).show();
            };
        }
        else
        {
            Toast.makeText(getApplicationContext(),"hay campos vacios", Toast.LENGTH_SHORT).show();
        }
    }
    public void limpia(View v)
    {
        text1.setText("");
        text2.setText("");
        text3.setText("");
        text4.setText("");
        text5.setText("");
        text6.setText("");
        text7.setText("");
        text8.setText("");
        text9.setText("");
        text10.setText("");
        text11.setText("");
    }

}
