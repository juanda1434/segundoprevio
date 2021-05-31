package com.edu.ufps.segundoPrevio.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.edu.ufps.segundoPrevio.idao.IEstamentoDAO;
import com.edu.ufps.segundoPrevio.model.Estamento;
import com.edu.ufps.segundoPrevio.model.Votante;
import com.edu.ufps.segundoPrevio.util.ConexionPostgreSQL;

public class EstamentoDAOPostgreSQL implements IEstamentoDAO{

	public static final String LISTAR_ALL= "SELECT e.id,e.descripcion,el.id,el.nombre from estamento inner join eleccion el on el.id=e.eleccion";
	
	private ConexionPostgreSQL conexion;
	public EstamentoDAOPostgreSQL() {
		
		conexion= ConexionPostgreSQL.getSingletonConexion();
		
	}

	@Override
	public List<Estamento> listarTodo() {


		List<Estamento>estamentos=new ArrayList<>();
		try {
			PreparedStatement prStm= this.conexion.getGestor().prepareStatement(LISTAR_ALL);
			prStm.execute();
			ResultSet rs= prStm.getResultSet();			
			while(rs.next()) {
				estamentos.add(new Estamento(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(estamentos.size());
		return estamentos;
	}
}
