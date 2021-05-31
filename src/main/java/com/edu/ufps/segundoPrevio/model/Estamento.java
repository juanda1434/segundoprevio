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
	
	public Estamento (int id,String descripcion,int idEleccion, String nombreEleccion) {
		this.descripcion=descripcion;
		this.id=id;
		this.eleccion=new Eleccion(idEleccion,nombreEleccion);
	}
	
	public Estamento(int id) {
		this.id=id;
	}
}
