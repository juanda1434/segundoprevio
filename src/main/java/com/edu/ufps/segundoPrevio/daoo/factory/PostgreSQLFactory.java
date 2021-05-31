package com.edu.ufps.segundoPrevio.daoo.factory;

import com.edu.ufps.segundoPrevio.dao.EstamentoDAOPostgreSQL;
import com.edu.ufps.segundoPrevio.dao.TipoDocumentoDAOPostgreSQL;
import com.edu.ufps.segundoPrevio.dao.VotanteDAOPostgreSQL;
import com.edu.ufps.segundoPrevio.idao.IEstamentoDAO;
import com.edu.ufps.segundoPrevio.idao.ITipoDocumentoDAO;
import com.edu.ufps.segundoPrevio.idao.IVotanteDAO;

public class PostgreSQLFactory implements IDAOFactory{

	@Override
	public IVotanteDAO getVotanteDAO() {
		return new VotanteDAOPostgreSQL();
	}

	@Override
	public IEstamentoDAO getEstamentoDAO() {
		return new EstamentoDAOPostgreSQL();
	}

	@Override
	public ITipoDocumentoDAO getTipoDocumentoDAO() {
		return new TipoDocumentoDAOPostgreSQL();
	}

	
	
	
	
}
