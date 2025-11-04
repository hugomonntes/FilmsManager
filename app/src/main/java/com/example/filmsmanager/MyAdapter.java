package com.example.filmsmanager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.filmsmanager.resources.Pelicula;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
	ArrayList<Pelicula> peliculas;

	public MyAdapter(ArrayList<Pelicula> peliculas) {
		this.peliculas = peliculas;
	}

	@NonNull
	@Override
	public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		View elemento = LayoutInflater.from(parent.getContext()).inflate(R.layout.celda, parent, false);
		ViewHolder vh = new ViewHolder(elemento);
		return vh;
	}

	@Override // Se añaden los datos a cada celda
	public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
		Pelicula pelicula = this.peliculas.get(position);
		holder.getTxvDirector().setText(pelicula.getDirector());
		holder.getTxvTitulo().setText(pelicula.getTitulo());
		holder.getImgPegi().setImageResource(pelicula.getClasi());
	}

	@Override
	public int getItemCount() {
		return this.peliculas.size();
	}

	public class ViewHolder extends RecyclerView.ViewHolder {
		TextView txvTitulo;
		TextView txvDirector;
		ImageView imgPegi;

		public ViewHolder(View viewElemento) {
			super(viewElemento);
			this.txvTitulo = viewElemento.findViewById(R.id.textView);
			this.txvDirector = viewElemento.findViewById(R.id.textView3);
			this.imgPegi = viewElemento.findViewById(R.id.imageView);
		}

		public TextView getTxvTitulo() {
			return txvTitulo;
		}

		public TextView getTxvDirector() {
			return txvDirector;
		}

		public ImageView getImgPegi() {
			return imgPegi;
		}
	}
}