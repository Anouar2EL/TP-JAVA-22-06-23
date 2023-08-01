package fr.inetum.tp.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String mdp = request.getParameter("mdp");
		List<String> erreurs = new ArrayList<>();
		
		if(email.equalsIgnoreCase("stagiaire@inetum.fr") && mdp.equals("123")) {
			// LE USER EST RECONNU, IL PEUT ACCEDER A LA PAGE liste.jsp			
			response.sendRedirect("liste");
		}else {
			erreurs.add("Login et/ou mdp incorrect(s)");
			request.setAttribute("erreurs", erreurs);
			// ICI, LE USER EST REDIRIGER SUR LA PAGE DE LOGIN
			response.sendRedirect("login");
		}
	}
}
