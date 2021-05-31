package com.edu.ufps.segundoPrevio.model;

import java.io.Serializable;

import lombok.Data;
@Data
public class Voto  implements Serializable{

	
	
	private String uuid;
	private String enlace;
	private Estamento estamento;	
	
	public Voto(String uuid,String enlace,int estamento) {
		this.uuid=uuid;
		this.enlace=enlace;
		this.estamento=new Estamento(estamento);
	}
}
