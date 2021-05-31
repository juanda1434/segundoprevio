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
	
	
	public Votante(int id,String nombre,String email, String documento, String descripcionDocumento, String nombreEleccion, String fechaInicio,String fechaFin, String descripcionEstamento) {
		this.nombre=nombre;
		this.email=email;
		this.documento=documento;
		this.tipoDocumento=new TipoDocumento(descripcionDocumento);
		this.eleccion=new Eleccion(nombreEleccion,fechaInicio,fechaFin);
		this.eleccion.addEstamento(descripcionEstamento);
		
		
	}
	
}
