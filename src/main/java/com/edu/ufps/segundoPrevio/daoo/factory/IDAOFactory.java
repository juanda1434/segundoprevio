package com.edu.ufps.segundoPrevio.daoo.factory;

import com.edu.ufps.segundoPrevio.idao.IEstamentoDAO;
import com.edu.ufps.segundoPrevio.idao.ITipoDocumentoDAO;
import com.edu.ufps.segundoPrevio.idao.IVotanteDAO;

public interface IDAOFactory {	
	
	
	public IVotanteDAO getVotanteDAO();
	public IEstamentoDAO getEstamentoDAO();
	public ITipoDocumentoDAO getTipoDocumentoDAO();
	
	public static IDAOFactory getFactory(String SGBD) {
		
		IDAOFactory factory = null;		
		switch(SGBD) {
		case "postgresql":
			factory= new PostgreSQLFactory();
			break;
		}
		return factory;
		
	}
}
