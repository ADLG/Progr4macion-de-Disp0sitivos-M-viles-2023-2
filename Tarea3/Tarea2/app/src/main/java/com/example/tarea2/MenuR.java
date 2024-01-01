package com.example.tarea2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MenuR extends AppCompatActivity {
    DrawerLayout dl;
    NavigationView nv;
    ActionBarDrawerToggle abdt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        dl = findViewById(R.id.principal);
        nv = findViewById(R.id.nav_view);
        abdt = new ActionBarDrawerToggle(this,dl,R.string.open,R.string.close);
        dl.addDrawerListener(abdt);
        abdt.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item)
            {
                switch (item.getItemId())
                {
                    case R.id.home: {Toast.makeText(MenuR.this, "Home Selected", Toast.LENGTH_SHORT).show(); break;}
                    case R.id.contact: {Toast.makeText(MenuR.this, "Contact Selected", Toast.LENGTH_SHORT).show(); break;}
                    case R.id.gallery: {Toast.makeText(MenuR.this, "Gallery Selected", Toast.LENGTH_SHORT).show(); break;}
                    case R.id.about: {Toast.makeText(MenuR.this, "About Selected", Toast.LENGTH_SHORT).show(); break;}
                    case R.id.login: {Toast.makeText(MenuR.this, "Log in Selected", Toast.LENGTH_SHORT).show(); break;}
                    case R.id.share: {Toast.makeText(MenuR.this, "Share Selected", Toast.LENGTH_SHORT).show(); break;}
                    case R.id.rate_us: {Toast.makeText(MenuR.this, "Rate us Selected", Toast.LENGTH_SHORT).show(); break;}
                }
                return false;
            }
        });
    }

    public void home(View view)
    {
        Intent inicio = new Intent(this,MainActivity.class);
        startActivity(inicio);
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.actionbar, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id = item.getItemId();
        if (id == R.id.item1)
            Toast.makeText(this,"Agregar platillo al carrito", Toast.LENGTH_SHORT).show();
        else if (id == R.id.item2)
            Toast.makeText(this,"Borrar platillo del carrito", Toast.LENGTH_SHORT).show();
        else if (id == R.id.item3)
            Toast.makeText(this,"Editar carrito", Toast.LENGTH_SHORT).show();

        if (abdt.onOptionsItemSelected(item))
            return true;

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed()
    {
        if (dl.isDrawerOpen(GravityCompat.START))
            dl.closeDrawer(GravityCompat.START);
        else
            super.onBackPressed();
    }
}