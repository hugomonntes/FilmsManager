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
