package com.example.filmsmanager.Activitys;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.filmsmanager.R;

public class DescriptionActivity extends AppCompatActivity {
	ImageView img;
	TextView txvTitulo;
	TextView txvSinopsis;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		EdgeToEdge.enable(this);
		setContentView(R.layout.activity_description);
		ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
			Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
			v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
			return insets;
		});

		img = findViewById(R.id.imgPortada);
		txvTitulo = findViewById(R.id.txvTitulo);
		txvSinopsis = findViewById(R.id.txvSinopsis);
//		Intent intent = getIntent();
//		intent.putExtra("adfa", )
	}
}