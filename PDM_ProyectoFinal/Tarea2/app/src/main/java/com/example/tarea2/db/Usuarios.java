package com.example.tarea2.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

public class Usuarios extends DbHelper
{
    Context context;
    public Usuarios(@Nullable Context context) {
        super(context);
        this.context = context;
    }

    public long insertaUsers(String name, String email, String password)
    {
        long id = 0;
        try {
            DbHelper dbh = new DbHelper(context);
            SQLiteDatabase db = dbh.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put("name", name);
            values.put("email", email);
            values.put("password", password);
            id = db.insert(TABLE_USER, null, values);
        } catch (Exception ex)
        {
            ex.toString();
        }
        return id;
    }

    public boolean verifNombreContra(String nombre, String contra)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery("select * from t_user where name = ? and password = ?", new String[] {nombre,contra});
        if (c.getCount() > 0)
            return true;
        else
            return false;
    }
}
