package com.edu.ufps.segundoPrevio.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class ConexionPostgreSQL {

	private static final String url = "jdbc:postgresql://queenie.db.elephantsql.com:5432/";
	private static final String dbName="mnjgxshj";
	private static final String driver= "org.postgresql.Driver";
	private static final String user= "mnjgxshj";
	private static final String pass= "Uzjqo00sxV0W9OzPEB1q3wpoVvGMbbUV";
	
	private Connection gestor;	
	
	private static ConexionPostgreSQL singletonConexion;
	
	private ConexionPostgreSQL () {	
		
		try {
			Class.forName(driver).newInstance();
			gestor = DriverManager.getConnection(url+dbName,user,pass);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	public static ConexionPostgreSQL getSingletonConexion() {
		if(singletonConexion==null) {
			singletonConexion=new ConexionPostgreSQL();
		}
		return singletonConexion ;
	}
	
	
	public Connection getGestor() {
		return this.gestor;
	}
	
	
	public static void main(String[] args) {
		ConexionPostgreSQL conexion = ConexionPostgreSQL.getSingletonConexion();
		
		Connection gestor  = conexion.getGestor();
		
		try {
			PreparedStatement pr= gestor.prepareStatement("insert into usuario(nombre,email) values('hola','hola@hola.com')");
			pr.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
