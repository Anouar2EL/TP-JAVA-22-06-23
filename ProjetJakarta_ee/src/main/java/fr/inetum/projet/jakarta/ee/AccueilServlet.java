package fr.inetum.projet.jakarta.ee;

import java.io.IOException;
import java.util.Random;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/accueil")
public class AccueilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Je suis dans le doGet de AccueilServlet").append(request.getContextPath());
		request.getRequestDispatcher("/WEB-INF/pages/Accueil.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre = request.getParameter("nombre");	
		Integer res =Integer.parseInt(nombre);
		System.out.println(nombre);
		
			 Random random = new Random();
		     int randomNumber = random.nextInt(10) + 1;
		     
      if ( res == randomNumber ) {
    	  
    	  request.setAttribute("succes","Vous avez trouvé la bonne valeur");
      }
      else if ( res > randomNumber ) {
    	  request.setAttribute("grand","Le nombre est plus grand");
      }
      else {
    	  request.setAttribute("petit","Le nombre est plus petit");
      }
		
		
		request.getRequestDispatcher("/WEB-INF/pages/Accueil.jsp").forward(request, response);
	}

}
