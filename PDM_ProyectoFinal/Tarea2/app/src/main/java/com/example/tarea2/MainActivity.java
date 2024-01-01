package com.example.tarea2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.BugreportManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tarea2.db.Items;
import com.example.tarea2.db.Usuarios;

public class MainActivity extends AppCompatActivity
{
    EditText nombre, contra;
    Button loginbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombre = (EditText) findViewById(R.id.nombre);
        contra = (EditText) findViewById(R.id.contra);
        loginbtn = (Button) findViewById(R.id.loginbtn);
        Intent login = new Intent(this,MenuR.class);
        Items ittab = new Items(MainActivity.this);
        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Usuarios users = new Usuarios(MainActivity.this);
                String user = nombre.getText().toString();
                String pass = contra.getText().toString();

                if (user.equals("")||pass.equals(""))
                    Toast.makeText(MainActivity.this, "Porfavor llene los campos", Toast.LENGTH_SHORT).show();
                else
                {
                    Boolean verNC = users.verifNombreContra(user,pass);
                    if (verNC==true)
                    {   Toast.makeText(MainActivity.this,"Has iniciado Sesión", Toast.LENGTH_SHORT).show();
                        ittab.insertaSesion(user);
                        startActivity(login);
                    }
                    else
                        Toast.makeText(MainActivity.this,"Credenciales no validas", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    public void register(View view)
    {
        Intent register = new Intent(this,Registrarse.class);
        startActivity(register);
    }

    public void login(View view)
    {


    }
}