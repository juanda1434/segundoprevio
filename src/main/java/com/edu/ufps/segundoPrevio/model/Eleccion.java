package com.edu.ufps.segundoPrevio.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class Eleccion implements Serializable{
	
	private Integer id;
	private String nombre;
	private String fechaInicio;
	private String fechaFin;
	private String cargo;
	private List<Estamento>estamentos;
	
	public Eleccion(String nombre, String fechaInicio,String fechaFin) {
		this.nombre=nombre;
		this.fechaFin=fechaFin;
		this.fechaInicio=fechaInicio;
		this.estamentos=new ArrayList<Estamento>();
	}
	
	public void addEstamento(String descripcion) {
		estamentos.add(new Estamento(descripcion));
		
	}
	
	public Eleccion (int id, String nombre) {
		this.id=id;
		this.nombre=nombre;
	}
}
