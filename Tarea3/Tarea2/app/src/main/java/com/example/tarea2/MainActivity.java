package com.example.tarea2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void register(View view)
    {
        Intent register = new Intent(this,Registrarse.class);
        startActivity(register);
    }

    public void login(View view)
    {
        Intent login = new Intent(this,MenuR.class);
        startActivity(login);
    }
}