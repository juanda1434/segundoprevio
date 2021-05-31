package com.edu.ufps.segundoPrevio.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class Votante implements Serializable{

	
	private Integer id;
	private String nombre;
	private String email;
	private String documento;
	private TipoDocumento tipoDocumento;
	private Eleccion eleccion;
	
	
	
}
