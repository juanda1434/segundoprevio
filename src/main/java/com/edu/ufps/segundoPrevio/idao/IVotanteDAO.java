package com.edu.ufps.segundoPrevio.idao;
import java.util.List;

import com.edu.ufps.segundoPrevio.model.Votante;
public interface IVotanteDAO {

	
	public void insertar(Votante votante);
	public List<Votante> listarTodo();
	public void eliminar(Votante votante);
	public void editar(Votante votante);
	
}
