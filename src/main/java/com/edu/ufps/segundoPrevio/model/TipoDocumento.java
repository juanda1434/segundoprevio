package com.edu.ufps.segundoPrevio.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class TipoDocumento implements Serializable{

	
	private Integer id;
	private String descripcion;
	
	public TipoDocumento(String descripcion) {
		this.descripcion=descripcion;
	}
	
	public TipoDocumento(int id) {
		this.id=id;
	}
	
	public TipoDocumento(int id,String descripcion) {
		this.id=id;
		this.descripcion=descripcion;
	}
	
}
