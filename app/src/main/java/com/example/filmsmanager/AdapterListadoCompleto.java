package com.example.filmsmanager;

import android.content.Intent;
import android.util.Log;
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

public class AdapterListadoCompleto extends RecyclerView.Adapter<AdapterListadoCompleto.ViewHolder> {
	ArrayList<Pelicula> peliculas;

	public AdapterListadoCompleto(ArrayList<Pelicula> peliculas) {
		this.peliculas = peliculas;
	}

	@NonNull
	@Override
	public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		View elemento = LayoutInflater.from(parent.getContext()).inflate(R.layout.celda_listado_completo, parent, false);
		ViewHolder vh = new ViewHolder(elemento);
		return vh;
	}

	@Override
	public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
		Pelicula pelicula = this.peliculas.get(position);
		holder.getImgPortada().setImageResource(pelicula.getPortada());
		holder.getImgPegi().setImageResource(pelicula.getClasi());
		holder.getImgButton().setImageResource(R.drawable.g);
		holder.getTxv4().setText(pelicula.getDirector());
		holder.getTxv5().setText(pelicula.getFecha().toString());
		holder.getTxv6().setText(pelicula.getDuracion() + "");
		holder.getTxv7().setText(pelicula.getSala());
	}

	@Override
	public int getItemCount() { // TODO IMPORTANTE!
		return peliculas.size();
	}

	public class ViewHolder extends RecyclerView.ViewHolder {
		ImageView imgPortada, imgPegi;
		ImageButton imgButton;
		TextView txv4, txv5, txv6, txv7;

		public ViewHolder(@NonNull View itemView) {
			super(itemView);
			this.imgPortada = itemView.findViewById(R.id.imageView2);
			this.imgPegi = itemView.findViewById(R.id.imageView3);
			this.imgButton = itemView.findViewById(R.id.imageButton2);
			this.txv4 = itemView.findViewById(R.id.textView4);
			this.txv5 = itemView.findViewById(R.id.textView5);
			this.txv6 = itemView.findViewById(R.id.textView6);
			this.txv7 = itemView.findViewById(R.id.textView7);
			itemView.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					int posPulsada=getAdapterPosition();
					setSelectedPos(posPulsada);
					if (selectedPos>RecyclerView.NO_POSITION){
						//Intent intent = new Intent(DescriptionActivity.class);
					}
				}
			});
		}

		public ImageView getImgPortada() {
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

		int selectedPos = RecyclerView.NO_POSITION;

		public int getSelectedPos() {
			return selectedPos;
		}

		public void setSelectedPos(int nuevaPos) {
			if (nuevaPos == this.selectedPos) {
				this.selectedPos = RecyclerView.NO_POSITION;
				notifyItemChanged(nuevaPos);
			} else {
				if (this.selectedPos >= 0) {
					notifyItemChanged(this.selectedPos);
				}
				this.selectedPos = nuevaPos;
				notifyItemChanged(nuevaPos);
			}
		}
	}
}
