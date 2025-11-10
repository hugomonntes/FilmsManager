package com.example.filmsmanager;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
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

		Datos datos = new Datos();
		peliculas = datos.rellenaPeliculas();
		adpatadorListado = new AdapterListadoCompleto(peliculas);
		//rv = findViewById(R.id.);
		miLayoutManager = new GridLayoutManager(this, 3,
				GridLayoutManager.VERTICAL, true);
	}
}