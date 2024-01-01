package com.example.tarea2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tarea2.db.Usuarios;

public class Registrarse extends AppCompatActivity {

    EditText txtNombre, txtCorreo, txtContraseña;
    Button registerR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrarse);
        txtNombre = findViewById(R.id.name);
        txtCorreo = findViewById(R.id.email);
        txtContraseña = findViewById(R.id.password);
        registerR = findViewById(R.id.registerR);
        Intent inicio = new Intent(this, MainActivity.class);
        registerR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Usuarios users = new Usuarios(Registrarse.this);
                long id = users.insertaUsers(txtNombre.getText().toString(), txtCorreo.getText().toString(), txtContraseña.getText().toString());

                if (id > 0) {
                    Toast.makeText(Registrarse.this, "REGISTRO GUARDADO", Toast.LENGTH_LONG).show();
                    limpiar();
                    startActivity(inicio);
                } else {
                    Toast.makeText(Registrarse.this, "ERROR AL GUARDAR REGISTRO", Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    private void limpiar() {
        txtNombre.setText("");
        txtCorreo.setText("");
        txtContraseña.setText("");
    }
}