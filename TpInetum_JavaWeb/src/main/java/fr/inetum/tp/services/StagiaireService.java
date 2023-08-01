package fr.inetum.tp.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import fr.inetum.tp.entites.Adresse;
import fr.inetum.tp.entites.Stagiaire;
import fr.inetum.tp.jdbc.outils.MaConnexion;

public class StagiaireService implements IStagiaireService{

	
	
	
	  public StagiaireService() {
		  
	  }
	  public StagiaireService(Connection connection,IAdresseService iAdresseService) {
		  
	  }
	  public StagiaireService(Connection connection) {
		  
	  }
	
	
	  
	@Override
	public Set<Stagiaire> allStagiaires() throws ClassNotFoundException, SQLException {
		Set<Stagiaire> stagiaires = new HashSet<>();
		String requete = "SELECT * FROM Stagiaire";
		Connection connection = MaConnexion.getInstance().getConnection();
		PreparedStatement stmt = connection.prepareStatement(requete);
		ResultSet rs = stmt.executeQuery();
		
		while(rs.next()) {		
			String prenom = rs.getString("prenom");
			String email = rs.getString("email");
			String mdp = rs.getString("mdp");
			int adresseId = rs.getInt("adresseId");
			LocalDate ddn = rs.getDate("ddn").toLocalDate();
			String role = rs.getString("role");
			int id = rs.getInt("id");
			Stagiaire stagiaire = new Stagiaire(prenom, email, mdp,adresseId,ddn,role,id);
			stagiaires.add(stagiaire);
		}
		
		
		return stagiaires;
	}
	@Override
	public Set<Stagiaire> allStagiaires(Adresse adresse) throws SQLException, ClassNotFoundException {
	/*	String requete = "SELECT FROM Stagiaire(prenom, email, mdp,adresseId,ddn,role,id) VALUES (?, ?, ?, ?,?,?,?) "
				+ "WHERE id = ?";
		
		Connection connection = MaConnexion.getInstance().getConnection();
		PreparedStatement stmt = connection.prepareStatement(requete);*/
		return null;
	}
	@Override
	public void removeStagiaire(Stagiaire stagiaire) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void addStagiaire(Stagiaire stagiaire, Adresse adresse) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Stagiaire getStagiaire(String login, String mdp) throws ClassNotFoundException, SQLException {
		String requete = "SELECT * FROM Stagiaire WHERE login = ? AND mdp = ? ";
		Connection connection = MaConnexion.getInstance().getConnection();
		PreparedStatement stmt = connection.prepareStatement(requete);		
		ResultSet rs = stmt.executeQuery();
		Stagiaire stagiaire = new Stagiaire();
		return stagiaire;
	}
	@Override
	public Stagiaire getStagiaire(Integer id) throws ClassNotFoundException, SQLException {
		String requete = "SELECT * FROM Stagiaire WHERE id = ? ";
		Connection connection = MaConnexion.getInstance().getConnection();
		PreparedStatement stmt = connection.prepareStatement(requete);		
		ResultSet rs = stmt.executeQuery();		
		Stagiaire stagiaire = new Stagiaire();
		return stagiaire;

	}



}
