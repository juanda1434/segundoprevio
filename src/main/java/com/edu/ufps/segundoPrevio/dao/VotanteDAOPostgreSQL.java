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

	public static final String LISTAR_ALL = "select votante.id,votante.email,votante.nombre,votante.documento,tipodocumento.descripcion,eleccion.nombre,extract(year from eleccion.fechainicio),extract(year from eleccion.fechafin),estamento.descripcion from votante inner join tipodocumento on votante.tipodocumento=tipodocumento.id inner join eleccion on eleccion.id=votante.eleccion inner join estamento on estamento.eleccion = eleccion.id and votante.eleccion = estamento.eleccion inner join voto on voto.estamento=estamento.id and votante.id = voto.votante";
	
	public static final String INSERT_VOTANTE = "INSERT INTO votante (nombre,email,documento,tipodocumento,eleccion) values(?,?,?,?,?)";
	
	public static final String INSERT_VOTO = "INSERT INTO voto (uuid,enlace,estamento,votante,fechacreacion) values(?,?,?,?,CURRENT_TIMESTAMP)";
	
	public static final String LAST_INSERT_ID = "SELECT MAX(id) from votante";
	
	public static final String DELETE_VOTANTE="DELETE FROM votante where id=?";
	
	public static final String DELETE_VOTO = "DELETE FROM voto where votante=?";
	
	public static final String LIST_VOTANTE = "SELECT v.id,v.nombre,v.email,v.documento,v.tipodocumento,e.id,v.eleccion FROM votante v inner join estamento e on e.eleccion = v.eleccion inner join voto vo on vo.votante=v.id and vo.estamento=e.id where v.id=?";
	
	public static final String UPDATE = "UPDATE votante set nombre=?,email=?,documento=?,tipodocumento=? where id=?";
	private ConexionPostgreSQL conexion; 
	
	
	 public VotanteDAOPostgreSQL() {
		conexion = ConexionPostgreSQL.getSingletonConexion();
	}
	@Override
	public void insertar(Votante votante) {		
		try {
			this.conexion.getGestor().setAutoCommit(false);
			PreparedStatement prStm= this.conexion.getGestor().prepareStatement(INSERT_VOTANTE);
			prStm.setString(1, votante.getNombre());
			prStm.setString(2, votante.getEmail());
			prStm.setString(3, votante.getDocumento());
			prStm.setInt(4, votante.getTipoDocumento().getId());
			prStm.setInt(5, votante.getEleccion().getId());
			prStm.execute();
			PreparedStatement pr2= this.conexion.getGestor().prepareStatement(LAST_INSERT_ID);
			pr2.execute();
			ResultSet rs = pr2.getResultSet();
			int idVotante=-1;
			if(rs.next()) {
				idVotante=rs.getInt(1);
			}
			PreparedStatement pr3= this.conexion.getGestor().prepareStatement(INSERT_VOTO);
			pr3.setString(1, votante.getVotos().get(0).getUuid());
			pr3.setString(2, votante.getVotos().get(0).getEnlace());
			pr3.setInt(3, votante.getVotos().get(0).getEstamento().getId());
			pr3.setInt(4, idVotante);
			pr3.execute();
			this.conexion.getGestor().commit();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				this.conexion.getGestor().rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
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
		
		try {
			this.conexion.getGestor().setAutoCommit(false);
			PreparedStatement pr1 = conexion.getGestor().prepareStatement(DELETE_VOTO);
			pr1.setInt(1, votante.getId());
			pr1.execute();
			
			PreparedStatement pr2 = conexion.getGestor().prepareStatement(DELETE_VOTANTE);
			pr2.setInt(1, votante.getId());
			pr2.execute();
			
			this.conexion.getGestor().commit();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				this.conexion.getGestor().rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}

	@Override
	public void editar(Votante votante) {

		try {
			PreparedStatement pr = this.conexion.getGestor().prepareStatement(UPDATE);
			pr.setString(1, votante.getNombre());
			pr.setString(2, votante.getEmail());
			pr.setString(3, votante.getDocumento());
			pr.setInt(4, votante.getTipoDocumento().getId());
			pr.setInt(5, votante.getId());
			pr.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
	}
	@Override
	public Votante listarVotante(Votante votante) {
Votante v  = null;
		try {
			PreparedStatement prStm= this.conexion.getGestor().prepareStatement(LIST_VOTANTE);
			prStm.setInt(1, votante.getId());
			prStm.execute();
			ResultSet rs= prStm.getResultSet();			
			while(rs.next()) {
				v=new Votante(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getInt(6),rs.getInt(7));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("votante");
		return v;
		
		
	}

	
	
	
}
