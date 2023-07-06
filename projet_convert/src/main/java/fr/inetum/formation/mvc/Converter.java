package fr.inetum.formation.mvc;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/converter")
public class Converter extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/pages/converter.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String celsius = request.getParameter("tempu");
		System.out.println(celsius);
		try {
			Double tempu =Double.parseDouble(celsius);
			tempu = (tempu * 9/5) + 32;
			request.setAttribute("tempu", tempu);
			
		} catch (NumberFormatException e) {
			request.setAttribute("erreur","attention à votre saisie");
		}
	 	
		request.getRequestDispatcher("/WEB-INF/pages/converter.jsp").forward(request, response);
		
	}
	
	

}
