package com.edu.ufps.segundoPrevio.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class Estamento implements Serializable {

	private int id;
	private Eleccion eleccion;
	private String descripcion;
	
	
	public Estamento(String descripcion) {
		this.descripcion=descripcion;
	}
	
	
}
