package com.example.user.xuni;

import android.database.sqlite.SQLiteDatabase;
import android.content.Context;
import android.database.sqlite.SQLiteOpenHelper;
public class bases extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION=1;
    public static final String DATABASE_NAME="usuario.db";
    public static final String CREATE_TABLE_USUARIO="create table usuario(ID integer primary key autoincrement, user text, password text)";
    public static final String CREATE_TABLE_REGISTRO="create table registro(ID integer primary key autoincrement, hora text, fecha text, momento text," +
            "antecedente text, nivel double)";
    public static final String UPGRADE_TABLE_USUARIO="DROP TABLE IF EXISTS usuario";
    public static final String UPGRADE_TABLE_REGISTRO="DROP TABLE IF EXISTS registro";
    public bases(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL(CREATE_TABLE_USUARIO);
        db.execSQL(CREATE_TABLE_REGISTRO);
    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newversion)
    {
        db.execSQL(UPGRADE_TABLE_USUARIO);
        db.execSQL(UPGRADE_TABLE_REGISTRO);
        onCreate(db);
    }
}
