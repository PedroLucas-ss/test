package com.example.tester;

import android.database.Cursor;
import android.util.Log;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class BancodeDados extends SQLiteOpenHelper {

    private static BancodeDados instance = null;
    private static final int Database_Version = 1;
    private static final String Database_Name = "BancodeDadosaaa.sqlite";
    private Context context;

    public BancodeDados(Context context) {
        super(context, Database_Name, null, Database_Version);
        this.context = context;

    }

    public static synchronized BancodeDados ShareInstance(Context context) {
        if (instance == null) {
            instance = new BancodeDados(context);
        }
        return instance;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String Query1;
        Query1 = "CREATE TABLE Dentista (id INTEGER PRIMARY KEY AUTOINCREMENT, nomeDentista TEXT, senhaDentista TEXT, CRO TEXT , emailDentista TEXT, TelefoneDentista TEXT, estadoDentista TEXT, UNIQUE (CRO, estadoDentista))";

        db.execSQL(Query1);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public long insert(Dentista dentista) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("nomeDentista", dentista.nomeDentista);
        values.put("senhaDentista", dentista.senhaDentista);
        values.put("CRO", dentista.CRO);
        values.put("emailDentista", dentista.emailDentista);
        values.put("TelefoneDentista", dentista.TelefoneDentista);
        values.put("estadoDentista", dentista.Estado);

        long id = db.insert("Dentista", null, values);

        return id;
    }
    public boolean verificarCredenciais(String username, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        String queryVer = "SELECT * FROM Dentista WHERE nomeDentista = ? AND senhaDentista = ?";
        Cursor cursor = db.rawQuery(queryVer, new String[]{username, password});
        Log.d("DBHelper", "Consulta SQL: " + queryVer);
        Log.d("DBHelper", "Valores: " + username + ", " + password );

        boolean credenciaisCorretas = cursor.moveToFirst();

//a
        return credenciaisCorretas;
    }

    }
