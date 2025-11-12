package com.example.filmsmanager.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.filmsmanager.R;
import com.example.filmsmanager.resources.Pelicula;

import java.util.ArrayList;

public class AdapterMain extends RecyclerView.Adapter<AdapterMain.ViewHolder> {
	TextView txv;
	ArrayList<Pelicula> peliculas;
	static int selectedPos = RecyclerView.NO_POSITION;

	public AdapterMain(ArrayList<Pelicula> peliculas, TextView txv) {
		this.peliculas = peliculas;
		this.txv = txv;
	}

	public int getSelectedPos(){
		return selectedPos;
	}

	public void setSelectedPos(int nuevaPos){
		if (nuevaPos == selectedPos){
			this.selectedPos = RecyclerView.NO_POSITION;
			notifyItemChanged(selectedPos);
		} else {
			if (this.selectedPos != RecyclerView.NO_POSITION){
				notifyItemChanged(selectedPos);
			}
			this.selectedPos = nuevaPos;
		}
		notifyItemChanged(selectedPos);
	}

	@NonNull
	@Override
	public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		View elemento = LayoutInflater.from(parent.getContext()).inflate(R.layout.celda, parent, false);
		ViewHolder vh = new ViewHolder(elemento);
		return vh;
	}

	@Override
	public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
		Pelicula pelicula = this.peliculas.get(position);
		holder.getTxvDirector().setText(pelicula.getDirector());
		holder.getTxvTitulo().setText(pelicula.getTitulo());
		holder.getImgPegi().setImageResource(pelicula.getClasi());
		holder.getImagePortada().setImageResource(pelicula.getPortada());
		if (selectedPos == position)
			holder.itemView.setBackgroundResource(R.color.green);
		else holder.itemView.setBackgroundResource(R.color.white);
	}

	@Override
	public int getItemCount() {
		return this.peliculas.size();
	}

	public class ViewHolder extends RecyclerView.ViewHolder {
		TextView txvTitulo;
		TextView txvDirector;
		ImageView imgPegi;
		ImageView imagePortada;

		public ViewHolder(View viewElemento) {
			super(viewElemento);
			this.txvTitulo = viewElemento.findViewById(R.id.textView);
			this.txvDirector = viewElemento.findViewById(R.id.textView3);
			this.imgPegi = viewElemento.findViewById(R.id.pegi);
			this.imagePortada = viewElemento.findViewById(R.id.imageView);

			viewElemento.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					int posPulsada=getAdapterPosition();
					setSelectedPos(posPulsada);
					txv.setText(peliculas.get(posPulsada).getTitulo());
				}
			});
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

		public ImageView getImagePortada() {
			return imagePortada;
		}
	}
}