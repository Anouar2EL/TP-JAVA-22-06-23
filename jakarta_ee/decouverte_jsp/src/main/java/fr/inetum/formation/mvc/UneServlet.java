package fr.inetum.formation.mvc;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.print.attribute.HashPrintRequestAttributeSet;

@WebServlet("/jspserv")
public class UneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("Methode doGet");
		
		
		
	// ON FAIT ICI TOUS LES TRAITEMENTS QUE L'ON SOUHAITE 
		// A LA FIN, ON PASSE LA MAIN A LA JSP
		
		
		String prenom = request.getParameter("prenom");
		request.setAttribute("prenom", prenom);
		
		String msg =" Je suis un message qui provient de la servlet UneSevlet";
		request.setAttribute("msg", msg);
		
		String age =request.getParameter("age");
		request.setAttribute("age", age);
		
		
		LocalDate date = LocalDate.now();
		request.setAttribute("date", date);
		
		LocalDateTime heure = LocalDateTime.now();
		request.setAttribute("heure", heure);
		
		
		
		request.getRequestDispatcher("/WEB-INF/pages/majsp.jsp").forward(request, response);
	}
	
@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String prenom = req.getParameter("prenom");
		String age =req.getParameter("age");
		System.out.println(String.format("prenom : %s, age : %s",prenom, age));
	}
}