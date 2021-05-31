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
		this.id=id;
		this.nombre=nombre;
		this.email=email;
		this.documento=documento;
		this.tipoDocumento=new TipoDocumento(descripcionDocumento);
		this.eleccion=new Eleccion(nombreEleccion,fechaInicio,fechaFin);
		this.eleccion.addEstamento(descripcionEstamento);
		
		
	}
	public Votante(int id,String nombre,String email, String documento, int idtipoDocumento,int ideleccion,int idestamento) {
		this.id=id;
		this.nombre=nombre;
		this.email=email;
		this.documento=documento;
		this.tipoDocumento=new TipoDocumento(idtipoDocumento);
		this.eleccion=new Eleccion(ideleccion,idestamento);
	}
	
	public Votante(int id ) {
		this.id=id;
	}
	
	public Votante(String nombre,String email,String documento,int tipo,int eleccion) {
		this.nombre=nombre;
		this.email=email;
		this.documento=documento;
		this.tipoDocumento=new TipoDocumento(tipo);
		this.eleccion=new Eleccion(eleccion);
	}
}
