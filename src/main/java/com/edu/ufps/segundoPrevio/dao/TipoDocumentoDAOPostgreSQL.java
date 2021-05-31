package com.edu.ufps.segundoPrevio.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.edu.ufps.segundoPrevio.idao.ITipoDocumentoDAO;
import com.edu.ufps.segundoPrevio.model.Estamento;
import com.edu.ufps.segundoPrevio.model.TipoDocumento;
import com.edu.ufps.segundoPrevio.util.ConexionPostgreSQL;

public class TipoDocumentoDAOPostgreSQL implements ITipoDocumentoDAO{

	
	public static final String LISTAR_ALL= "SELECT id,descripcion from tipodocumento";
	public ConexionPostgreSQL conexion ;
	
	 public TipoDocumentoDAOPostgreSQL() {
	this.conexion=ConexionPostgreSQL.getSingletonConexion();
	}
	
	
	@Override
	public List<TipoDocumento> listarTodo() {

		List<TipoDocumento>tipos=new ArrayList<>();
		try {
			PreparedStatement prStm= this.conexion.getGestor().prepareStatement(LISTAR_ALL);
			prStm.execute();
			ResultSet rs= prStm.getResultSet();			
			while(rs.next()) {
				tipos.add(new TipoDocumento(rs.getInt(1), rs.getString(2)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(tipos.size() );
		return tipos;
	}

	
	
}
