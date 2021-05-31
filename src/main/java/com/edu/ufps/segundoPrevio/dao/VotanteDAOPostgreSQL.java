package com.edu.ufps.segundoPrevio.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.edu.ufps.segundoPrevio.idao.IVotanteDAO;
import com.edu.ufps.segundoPrevio.model.Votante;
import com.edu.ufps.segundoPrevio.util.ConexionPostgreSQL;

public class VotanteDAOPostgreSQL implements IVotanteDAO{

	public static final String LISTAR_ALL = "SELECT v.id,v.nombre,v.email,v.documento,td.descripcion,e.nombre, extract(year from fechainicio),extract(year from fechafin),es.descripcion from votante v inner join tipodocumento tp on tp.id=v.tipodocumento inner join eleccion e on e.id=v.eleccion inner join estamento es on es.eleccion = e.id ";
	
	private ConexionPostgreSQL conexion; 
	
	
	 public VotanteDAOPostgreSQL() {
		conexion = ConexionPostgreSQL.getSingletonConexion();
	}
	@Override
	public void insertar(Votante votante) {
		
		
	}

	@Override
	public List<Votante> listarTodo() {

		List<Votante>usuarios=new ArrayList<>();
		try {
			PreparedStatement prStm= this.conexion.getGestor().prepareStatement(LISTAR_ALL);
			prStm.execute();
			ResultSet rs= prStm.getResultSet();			
			while(rs.next()) {
				usuarios.add(new Votante(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return usuarios;
		
		
	}

	@Override
	public void eliminar(Votante votante) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void editar(Votante votante) {
		// TODO Auto-generated method stub
		
	}

	
	
	
}
