package com.example.filmsmanager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx. appcompat. widget. Toolbar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.filmsmanager.resources.Datos;
import com.example.filmsmanager.resources.Pelicula;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {
	ArrayList<Pelicula> peliculas;
	RecyclerView rv;
	AdapterListadoCompleto adpatadorListado;
	RecyclerView.LayoutManager miLayoutManager;
	Toolbar tb;
	ActionBar actionBar;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		EdgeToEdge.enable(this);
		setContentView(R.layout.activity_main2);
		ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
			Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
			v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
			return insets;
		});
		rv = findViewById(R.id.rv2);
		tb = findViewById(R.id.toolbar2);
		peliculas = Datos.rellenaPeliculas();
		adpatadorListado = new AdapterListadoCompleto(peliculas);
		miLayoutManager = new GridLayoutManager(this, 1);
		miLayoutManager = new GridLayoutManager(this, 1,
				GridLayoutManager.VERTICAL, true);
		rv.setLayoutManager(miLayoutManager);
		rv.setAdapter(adpatadorListado);
		setSupportActionBar(tb);
		actionBar = getSupportActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater menuInflater = getMenuInflater();
		menuInflater.inflate(R.menu.menu_volver,menu);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if(id ==  android.R.id.home ) {
			onBackPressed();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}