package fr.inetum.tp.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Set;

import fr.inetum.tp.entites.Stagiaire;
import fr.inetum.tp.services.IStagiaireService;
import fr.inetum.tp.services.StagiaireService;



@WebServlet("/liste")
public class ListeStagiaireServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private IStagiaireService service;

	@Override
	public void init() throws ServletException {
		service = new StagiaireService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Set<Stagiaire> listeStagiaires;
		try {
			listeStagiaires = service.allStagiaires();
	        request.setAttribute("listeStagiaires", listeStagiaires);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}



		request.getRequestDispatcher("/WEB-INF/jsp/liste.jsp").forward(request, response);
	
}
}
