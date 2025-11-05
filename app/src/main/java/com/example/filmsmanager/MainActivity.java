package com.example.filmsmanager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;

import android.app.Notification;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.filmsmanager.resources.Datos;
import com.example.filmsmanager.resources.Pelicula;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
	ArrayList<Pelicula> peliculas;
	RecyclerView recyclerView;
	Toolbar toolbar;
	MyAdapter adaptador;
	ActionBar actionBar;
	RecyclerView.LayoutManager miLayoutManager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		EdgeToEdge.enable(this);
		setContentView(R.layout.activity_main);
		ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
			Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
			v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
			return insets;
		});
		toolbar = findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);
		recyclerView = findViewById(R.id.rv);
		Datos d = new Datos();
		peliculas = d.rellenaPeliculas();
		adaptador = new MyAdapter(peliculas);
		//miLayoutManager = new GridLayoutManager(this, 1);
		miLayoutManager = new GridLayoutManager(this, 1,
				GridLayoutManager.VERTICAL, true);
		recyclerView.setLayoutManager(miLayoutManager);
		recyclerView.setAdapter(adaptador);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater menuInflater = getMenuInflater();
		menuInflater.inflate(R.menu.menu_principal, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(@NonNull MenuItem item) {
		actionBar = getSupportActionBar();
		int id = item.getItemId();
		if (id == R.id.all) {
			return true;
		} else if (id == R.id.add) {
			return true;
		} else if (id == R.id.see) {
			return true;
		} else if (id == R.id.show) {
			return true;
		} else if (id == R.id.favs) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}