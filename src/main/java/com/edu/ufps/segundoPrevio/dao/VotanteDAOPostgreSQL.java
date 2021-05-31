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

	public static final String LISTAR_ALL = "SELECT v.id,v.nombre,v.email,v.documento,tp.descripcion,e.nombre, extract(year from fechainicio),extract(year from fechafin),es.descripcion from votante v inner join tipodocumento tp on tp.id=v.tipodocumento inner join eleccion e on e.id=v.eleccion inner join estamento es on es.eleccion = e.id";
	
	public static final String INSERT_VOTANTE = "INSERT INTO votante (nombre,email,documento,tipodocumento,eleccion) values(?,?,?,?,?)";
	
	public static final String DELETE_VOTANTE="DELETE FROM votante where id=?";
	
	public static final String DELETE_VOTO = "DELETE FROM voto where votante=?";
	
	public static final String LIST_VOTANTE = "SELECT v.id,v.nombre,v.email,v.documento,v.tipodocumento,e.id,v.eleccion FROM votante v inner join estamento e on e.eleccion = v.eleccion where v.id=?";
	
	private ConexionPostgreSQL conexion; 
	
	
	 public VotanteDAOPostgreSQL() {
		conexion = ConexionPostgreSQL.getSingletonConexion();
	}
	@Override
	public void insertar(Votante votante) {
		
		try {
			PreparedStatement prStm= this.conexion.getGestor().prepareStatement(INSERT_VOTANTE);
			prStm.setString(1, votante.getNombre());
			prStm.setString(2, votante.getEmail());
			prStm.setString(3, votante.getDocumento());
			prStm.setInt(4, votante.getTipoDocumento().getId());
			prStm.setInt(5, votante.getEleccion().getId());
			prStm.execute();
			System.out.println(prStm.getMaxRows());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
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
		System.out.println(usuarios.size());
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
	@Override
	public Votante listarVotante(Votante votante) {
Votante v  = null;
		try {
			PreparedStatement prStm= this.conexion.getGestor().prepareStatement(LIST_VOTANTE);
			prStm.execute();
			ResultSet rs= prStm.getResultSet();			
			while(rs.next()) {
				v=new Votante(rs.getInt(0),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getInt(6),rs.getInt(7));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return v;
		
		
	}

	
	
	
}
