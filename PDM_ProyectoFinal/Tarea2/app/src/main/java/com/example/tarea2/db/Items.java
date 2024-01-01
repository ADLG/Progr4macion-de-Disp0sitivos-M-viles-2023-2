package com.example.tarea2.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class Items extends DbHelper
{
    Context context;

    public Items(@Nullable Context context) {
        super(context);
        this.context = context;
    }

    public long insertaItem(String usuario, String nombreItem, int precio)
    {
        long id = 0;
        try {
            DbHelper dbh = new DbHelper(context);
            SQLiteDatabase db = dbh.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put("usuario", usuario);
            values.put("nombreItem", nombreItem);
            values.put("precio", precio);
            id = db.insert(TABLE_ITEM, null, values);
        } catch (Exception ex)
        {
            ex.toString();
        }
        return id;
    }

    public String getLast()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM t_InicioSesion", null);
        c.moveToLast();
        String ultimo = c.getString(c.getColumnIndex("usuario"));
        return ultimo;
    }

    public void insertaSesion(String user)
    {
        long id = 0;
        DbHelper dbh = new DbHelper(context);
        SQLiteDatabase db = dbh.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("usuario", user);
        id = db.insert(TABLE_SESI, null, values);
    }

    public ArrayList<String> getItems()
    {
        ArrayList<String> list = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery("Select * from t_item", null);
        int a = 0;
        while (c.moveToNext())
        {
            list.add(c.getString(a));
            a++;
        }
        return list;
    }
}
