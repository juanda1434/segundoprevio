package com.edu.ufps.segundoPrevio.controller;

import java.io.IOException;
import java.util.List;

import com.edu.ufps.segundoPrevio.daoo.factory.IDAOFactory;
import com.edu.ufps.segundoPrevio.idao.IVotanteDAO;
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
	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		votanteDAO = IDAOFactory.getFactory("postgresql").getVotanteDAO();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
String path = request.getServletPath();
		
		switch (path) {
		case "/nuevo":
			//mostrarFormulario(request, response);
			break;
		case "/insertar":
			//insertar(request, response);
			break;
		case "/borrar":
			//eliminar(request,response);
			break;
		case "/edicion":
			//mostrarFormularioEdicion(request, response);
			break;
		case "/editar":
			//editar(request,response);
			break;
		case "/lista":
			//listar(request, response);
			break;

		default:
			listar(request, response);
			break;
		}
	}

	/*protected void mostrarFormulario(HttpServletRequest request,HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("usuario.jsp").forward(request, response);
		}
	
	protected void mostrarFormularioEdicion(HttpServletRequest request,HttpServletResponse response)
			throws ServletException, IOException {
		Usuario usuarioDTO = new Usuario(Integer.parseInt(request.getParameter("id")));
		Usuario usuarioActual = usuarioDAO.usuarioActual(usuarioDTO);
		
		request.setAttribute("user", usuarioActual);
		request.getRequestDispatcher("usuario.jsp").forward(request, response);
		}
	
	protected void insertar(HttpServletRequest request,HttpServletResponse response)
			throws ServletException, IOException {
		String nombre = request.getParameter("nombre");
		String email = request.getParameter("email");
		String pais = request.getParameter("pais");
		Usuario usuarioDTO = new Usuario(nombre, email, pais);
		usuarioDAO.insert(usuarioDTO);
		String mensaje = "Hola "+nombre+" eres de "+pais+" bienvenido";
		mail.enviarEmail(email, "Bienvenida", mensaje);
		response.sendRedirect("listar");
		}
	
	protected void editar(HttpServletRequest request,HttpServletResponse response)
			throws ServletException, IOException {
		String nombre = request.getParameter("nombre");
		String email = request.getParameter("email");
		String pais = request.getParameter("pais");
		Integer id = Integer.parseInt(request.getParameter("id"));
		Usuario usuarioDTO = new Usuario(id,nombre, email, pais);
		usuarioDAO.edit(usuarioDTO);
		response.sendRedirect("listar");
		}
	protected void eliminar(HttpServletRequest request,HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Usuario usuarioDTO = new Usuario(id);
		usuarioDAO.delete(usuarioDTO);
		response.sendRedirect("listar");
		}
	
	
	*/
	protected void listar(HttpServletRequest request,HttpServletResponse response)
			throws ServletException, IOException {
				List<Votante> votante= votanteDAO.listarTodo();
				request.setAttribute("listaVotante", votante);
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
