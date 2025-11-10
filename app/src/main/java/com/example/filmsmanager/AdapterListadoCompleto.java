package com.example.filmsmanager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.filmsmanager.resources.Pelicula;

import java.util.ArrayList;

public class AdapterListadoCompleto extends RecyclerView.Adapter<AdapterListadoCompleto.ViewHolder>{
	ArrayList<Pelicula> peliculas;

	public AdapterListadoCompleto(ArrayList<Pelicula> peliculas){
		this.peliculas = peliculas;
	}

	@NonNull
	@Override
	public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		View elemento = LayoutInflater.from(parent.getContext()).inflate(R.layout.celda_listado_completo,parent,false);
		ViewHolder vh = new ViewHolder(elemento);
		return vh;
	}

	@Override
	public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
		Pelicula pelicula = this.peliculas.get(position);
		holder.getImgPortada().setImageResource(pelicula.getPortada());
		holder.getImgPegi().setImageResource(pelicula.getClasi());
		holder.getTxv4().setText(pelicula.getDirector());
		holder.getTxv5().setText(pelicula.getFecha().toString());
		holder.getTxv6().setText(pelicula.getDuracion() + "");
		holder.getTxv7().setText(pelicula.getSala());
	}

	@Override
	public int getItemCount() {
		return 0;
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
			this.imgPortada = itemView.findViewById(R.id.imageView2);
			this.imgPegi = itemView.findViewById(R.id.imageView3);
			this.imgButton = itemView.findViewById(R.id.imageButton2);
			this.txv4 = itemView.findViewById(R.id.textView4);
			this.txv5 = itemView.findViewById(R.id.textView5);
			this.txv6 = itemView.findViewById(R.id.textView6);
			this.txv7 = itemView.findViewById(R.id.textView7);
		}

		public ImageView getImgPortada(){
			return imgPortada;
		}

		public ImageView getImgPegi() {
			return imgPegi;
		}

		public ImageButton getImgButton() {
			return imgButton;
		}

		public TextView getTxv4() {
			return txv4;
		}

		public TextView getTxv5() {
			return txv5;
		}

		public TextView getTxv6() {
			return txv6;
		}

		public TextView getTxv7() {
			return txv7;
		}
	}
}
