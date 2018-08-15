package com.example.user.xuni;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.telephony.SmsManager;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import android.app.ProgressDialog;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Properties;

import android.os.AsyncTask;

public class Sesion extends Activity {




    /////////////////////////Sesion paciente atributos////////////////////////////

    bases database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sesion);



    }

    protected void onStart() {
        super.onStart();

    }

    protected void onResume() {
        super.onResume();


    }











    ///////////////////////////Metodos Sesion Paciente/////////////////////////////////////

    public void grafica(View v)
    {
        //Intent intent = new Intent(Sesion.this, GraficaPeso.class);
        //startActivity(intent);
    }
    public void tabla(View v){
        //Intent intent = new Intent(SesionPaciente.this, TablaUsuario.class);
        //startActivity(intent);
    }
}
