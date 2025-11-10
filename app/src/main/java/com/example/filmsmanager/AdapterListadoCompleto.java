package com.example.filmsmanager;

import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.filmsmanager.resources.Pelicula;

import java.util.ArrayList;

public class AdapterListadoCompleto {
	ArrayList<Pelicula> peliculas;

	public AdapterListadoCompleto(ArrayList<Pelicula> peliculas){
		this.peliculas = peliculas;
	}

	public class ViewHolder extends RecyclerView.ViewHolder {
		private ImageView imgPortada;
		private ImageView imgPegi;
		private ImageButton imgButton;
		private TextView txv4;
		private TextView txv5;
		private TextView txv6;
		private TextView txv7;

		public ViewHolder(@NonNull View itemView) {
			super(itemView);
		}
	}
}
