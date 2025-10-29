package com.example.filmsmanager.resources;

import android.media.Image;

import java.util.Date;

public class Film {
	private String title;
	private String directorName;
	private int duration;
	private String salaDeCine;
	private String sinopsis;
	private Date fechaDeEstreno;
	private Image imgPortada;
	private Image clasificationPerAge;

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setDirectorName(String directorName) {
		this.directorName = directorName;
	}

	public String getDirectorName() {
		return directorName;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public int getDuration() {
		return duration;
	}

	public void setSalaDeCine(String salaDeCine) {
		this.salaDeCine = salaDeCine;
	}

	public String getSalaDeCine() {
		return salaDeCine;
	}

	public void setSinopsis(String sinopsis) {
		this.sinopsis = sinopsis;
	}

	public String getSinopsis() {
		return sinopsis;
	}

	public void setFechaDeEstreno(Date fechaDeEstreno) {
		this.fechaDeEstreno = fechaDeEstreno;
	}

	public Date getFechaDeEstreno() {
		return fechaDeEstreno;
	}

	public void setImgPortada(Image imgPortada) {
		this.imgPortada = imgPortada;
	}

	public Image getClasificationPerAge() {
		return clasificationPerAge;
	}

	public void setClasificationPerAge(Image clasificationPerAge) {
		this.clasificationPerAge = clasificationPerAge;
	}

	public Image getImgPortada() {
		return imgPortada;
	}
}
