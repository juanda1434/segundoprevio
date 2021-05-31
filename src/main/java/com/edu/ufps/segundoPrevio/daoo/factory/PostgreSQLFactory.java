package com.edu.ufps.segundoPrevio.daoo.factory;

import com.edu.ufps.segundoPrevio.dao.VotanteDAOPostgreSQL;
import com.edu.ufps.segundoPrevio.idao.IVotanteDAO;

public class PostgreSQLFactory implements IDAOFactory{

	@Override
	public IVotanteDAO getVotanteDAO() {
		return new VotanteDAOPostgreSQL();
	}

	
	
	
	
}
