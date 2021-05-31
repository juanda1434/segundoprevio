package com.edu.ufps.segundoPrevio.controller;

import java.io.IOException;
import java.util.List;

import com.edu.ufps.segundoPrevio.daoo.factory.IDAOFactory;
import com.edu.ufps.segundoPrevio.idao.IEstamentoDAO;
import com.edu.ufps.segundoPrevio.idao.ITipoDocumentoDAO;
import com.edu.ufps.segundoPrevio.idao.IVotanteDAO;
import com.edu.ufps.segundoPrevio.model.Estamento;
import com.edu.ufps.segundoPrevio.model.TipoDocumento;
import com.edu.ufps.segundoPrevio.model.Votante;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class VotanteC
 */
@WebServlet("/")
public class VotanteC extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public VotanteC() {
       
    }

    IVotanteDAO votanteDAO;
    IEstamentoDAO estamentoDAO;
    ITipoDocumentoDAO tipoDocumentoDAO;
	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		votanteDAO = IDAOFactory.getFactory("postgresql").getVotanteDAO();
		estamentoDAO = IDAOFactory.getFactory("postgresql").getEstamentoDAO();
		tipoDocumentoDAO=IDAOFactory.getFactory("postgresql").getTipoDocumentoDAO();
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
String path = request.getServletPath();
		
		switch (path) {
		case "/nuevo":
			mostrarFormulario(request, response);
			break;
		case "/insertar":
			insertar(request, response);
			break;
		case "/borrar":
			eliminar(request,response);
			break;
		case "/edicion":
			mostrarFormularioEdicion(request, response);
			break;
		case "/editar":
			editar(request,response);
			break;
		case "/lista":
			listar(request, response);
			break;

		default:
			listar(request, response);
			break;
		}
	}
	
	protected void mostrarFormulario(HttpServletRequest request,HttpServletResponse response)
			throws ServletException, IOException {
		List<Estamento>estamentos=estamentoDAO.listarTodo();
		List<TipoDocumento>tipos=tipoDocumentoDAO.listarTodo();
		request.setAttribute("estamentos", estamentos);
		request.setAttribute("tipos", tipos);
		request.getRequestDispatcher("Votantes.jsp").forward(request, response);
		
		}
	
	protected void mostrarFormularioEdicion(HttpServletRequest request,HttpServletResponse response)
			throws ServletException, IOException {
		Votante votante = new Votante(Integer.parseInt(request.getParameter("id")));
		Votante usuarioActual = votanteDAO.listarVotante(votante);
		List<Estamento>estamentos=estamentoDAO.listarTodo();
		List<TipoDocumento>tipos=tipoDocumentoDAO.listarTodo();
		request.setAttribute("estamentos", estamentos);
		request.setAttribute("tipos", tipos);
		request.setAttribute("user", usuarioActual);
		request.getRequestDispatcher("Votantes.jsp").forward(request, response);
		}
	


	protected void insertar(HttpServletRequest request,HttpServletResponse response)
			throws ServletException, IOException {
		String nombre = request.getParameter("nombre");
		String email = request.getParameter("email");
		String documento = request.getParameter("documento");
		int idTipo= Integer.parseInt(request.getParameter("tipo"));
		int idEleccion= Integer.parseInt(request.getParameter("eleccion"));
		int idEstamento=Integer.parseInt(request.getParameter("estamento"));
		
		Votante votante = new Votante(nombre,email,documento,idTipo,idEleccion,"uuid","enlace",idEstamento);
		votanteDAO.insertar(votante);
		response.sendRedirect("listar");
		}
	
	protected void eliminar(HttpServletRequest request,HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Votante votante = new Votante(id);
		votanteDAO.eliminar(votante);
		response.sendRedirect("listar");
		}
	
	protected void editar(HttpServletRequest request,HttpServletResponse response)
			throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("id"));
		String nombre = request.getParameter("nombre");
		String email = request.getParameter("email");
		String documento = request.getParameter("documento");
		int idTipo= Integer.parseInt(request.getParameter("tipo"));
		//int idEleccion= Integer.parseInt(request.getParameter("eleccion"));
		//int idEstamento=Integer.parseInt(request.getParameter("estamento"));
		
		Votante votante = new Votante(id,nombre,email,documento,idTipo);
		votanteDAO.editar(votante);
		response.sendRedirect("listar");
		}
	
	protected void listar(HttpServletRequest request,HttpServletResponse response)
			throws ServletException, IOException {
				List<Votante> votante= votanteDAO.listarTodo();
				request.setAttribute("listaVotantes", votante);
		request.getRequestDispatcher("listarVotantes.jsp").forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
