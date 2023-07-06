package fr.inetum.formation.mvc;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/autre")
public class AutreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Je suis dans le doGet de AutreServlet").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String prenom = request.getParameter("prenom");
		request.setAttribute("prenom", prenom);
		
		String age =request.getParameter("age");
		request.setAttribute("age", age);
		
		/*
		response.getWriter()
		.append("Je suis dans le doPost de AutreServlet")
		.append("\n Mon prenom est " + prenom)
		.append("\n Mon age est " + age + "ans");*/
		
		request.getRequestDispatcher("/WEB-INF/pages/autre.jsp").forward(request, response);
		
	}

}
