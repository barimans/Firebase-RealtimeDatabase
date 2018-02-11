package com.example.brizz.budayabandung;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.brizz.budayabandung.KategoriActivity.AlatMusikActivity;
import com.example.brizz.budayabandung.KategoriActivity.MakananActivity;
import com.example.brizz.budayabandung.KategoriActivity.PakaianActivity;
import com.example.brizz.budayabandung.KategoriActivity.SeniActivity;
import com.example.brizz.budayabandung.AddActivity.AddDataActivity;
import com.example.brizz.budayabandung.KategoriActivity.TemaActivity;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbarMain;

    private TextView tvAlatMusik, tvSeniTradisi, tvMakanan, tvPakaian, tvTema;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbarMain = findViewById(R.id.toolbarMain);
        toolbarMain.setTitle("");
        setSupportActionBar(toolbarMain);

        tvAlatMusik = findViewById(R.id.tv_alatMusik);
        tvSeniTradisi = findViewById(R.id.tv_seniTradisi);
        tvMakanan = findViewById(R.id.tv_makanan);
        tvPakaian = findViewById(R.id.tv_pakaian);
        tvTema = findViewById(R.id.tv_tema);

        tvAlatMusik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, AlatMusikActivity.class));
            }
        });

        tvSeniTradisi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, SeniActivity.class));
            }
        });

        tvMakanan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, MakananActivity.class));
            }
        });

        tvPakaian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, PakaianActivity.class));
            }
        });

        tvTema.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, TemaActivity.class));
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main_menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.action_add){
            startActivity(new Intent(MainActivity.this, AddDataActivity.class));
        }

        return super.onOptionsItemSelected(item);
    }
}
