package fr.inetum.filters;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.annotation.WebServlet;

@WebFilter("/trois")
public class MonFiltre implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		System.out.println("Je suis dans le filtre MonFiltre");
		if(true) {
			// tout est ok pour laisser passer la requete
			chain.doFilter(request, response); }
		else  {
			// ici on redirige le user vers une autre ressource 
			System.out.println("vous n'etes pas habilité our cette requette");
		}
	}

}
