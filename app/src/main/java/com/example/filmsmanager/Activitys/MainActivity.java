package com.example.filmsmanager.Activitys;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.filmsmanager.Adapters.AdapterMain;
import com.example.filmsmanager.R;
import com.example.filmsmanager.resources.Datos;
import com.example.filmsmanager.resources.Pelicula;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
	ArrayList<Pelicula> peliculas;
	RecyclerView recyclerView;
	Toolbar toolbar;
	AdapterMain adaptador;
	ActionBar actionBar;
	RecyclerView.LayoutManager miLayoutManager;
	TextView txv;

	ActivityResultLauncher<Intent> launcher;

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
		ArrayList<Pelicula> auxPelis = new ArrayList<>();
		toolbar = findViewById(R.id.toolbar);
		txv = findViewById(R.id.textView2);
		setSupportActionBar(toolbar);
		recyclerView = findViewById(R.id.rv2);
		peliculas = Datos.rellenaPeliculas();
		adaptador = new AdapterMain(peliculas, txv);
		//miLayoutManager = new GridLayoutManager(this, 1);
		miLayoutManager = new GridLayoutManager(this, 1,
				GridLayoutManager.VERTICAL, true);
		recyclerView.setLayoutManager(miLayoutManager);
		recyclerView.setAdapter(adaptador);

		launcher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
			@Override
			public void onActivityResult(ActivityResult o) {
				if (o.getResultCode() == RESULT_OK){
					Intent intent=o.getData();
					auxPelis = (ArrayList<Pelicula>) intent.getSerializableExtra("Peliculas");

				}
			}
		});
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
			// Lanzar la otra activity con el adapter
			Intent lanzarListadoFavorito = new Intent(MainActivity.this, MainActivity2.class);
			lanzarListadoFavorito.putExtra("Peliculas", peliculas);
			launcher.launch(lanzarListadoFavorito);
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