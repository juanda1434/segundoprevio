package com.edu.ufps.segundoPrevio.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class Eleccion implements Serializable{
	
	private Integer id;
	private String nombre;
	private String fecha;
	private String fechaFin;
	private String cargo;
	
	
	
	
}
