package com.example.tarea2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.tarea2.db.DbHelper;
import com.example.tarea2.db.Items;

import java.util.ArrayList;

public class Carrito extends AppCompatActivity
{
    ListView l1;
    ArrayList<String> t = new ArrayList<String>();
    ArrayAdapter adapter;
    Button btnMen, btnOrd;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrito);
        DbHelper dbh = new DbHelper(Carrito.this);
        SQLiteDatabase db = dbh.getWritableDatabase();

        l1 = findViewById(R.id.l1);

        Items ittab = new Items(Carrito.this);
        String usr = ittab.getLast();
        Toast.makeText(Carrito.this, "Este es tu carrito "+usr, Toast.LENGTH_LONG).show();

        final Cursor c = db.rawQuery("select * from t_item where usuario = ?",new String[] {usr});
        int id = c.getColumnIndex("id");
        int usuario = c.getColumnIndex("usuario");
        int nombreItem = c.getColumnIndex("nombreItem");
        int precio = c.getColumnIndex("precio");
        t.clear();
        adapter = new ArrayAdapter(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,t);
        l1.setAdapter(adapter);

        final ArrayList<Item> itemsl = new ArrayList<Item>();
        if (c.moveToFirst())
        {
            do {
                    Item it = new Item();
                    it.id = c.getString(id);
                    it.usuario = c.getString(usuario);
                    it.nombreItem = c.getString(nombreItem);
                    it.precio = c.getString(precio);
                    itemsl.add(it);
                    //t.add(c.getString(id)+"\t"+c.getString(usuario)+"\t"+c.getString(nombreItem)+"\t"+c.getString(precio));
                //if (c.getString(usuario) == extras.getString("actuser"))
                    t.add("Usuario:" + c.getString(usuario) + "  Producto: " + c.getString(nombreItem) + "    Precio: $" + c.getString(precio));
            }while (c.moveToNext());
            adapter.notifyDataSetChanged();
        }

        btnMen = findViewById(R.id.btnMen);
        Intent menu = new Intent(this,MenuR.class);
        btnMen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(menu);
            }
        });

        btnOrd = findViewById(R.id.btnOrd);
        Intent grax = new Intent(this,GraciasCompra.class);
        btnOrd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(grax);
            }
        });
    }
}