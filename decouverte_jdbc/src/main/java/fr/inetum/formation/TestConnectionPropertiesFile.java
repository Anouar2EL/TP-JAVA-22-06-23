package fr.inetum.formation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class TestConnectionPropertiesFile {

	
	static String driver;
	static String url;
	static String username;
	static String password; 
	
	public static void main(String[] args) {
		// Chargement du fichier de proprétiés
		ResourceBundle props = ResourceBundle.getBundle("dbparams");
		
		// Recupération des valeurs des clés du fichier de proprétiés
		driver = props.getString("mysql.driver");
		url = props.getString("mysql.url");
		username = props.getString("mysql.username");
		password = props.getString("mysql.password");
		
		try {
			Class.forName(driver);
			System.out.println("DRIVER OK");
			
			try(Connection connection = DriverManager.getConnection(url, username, password)){
				System.out.println("CONNECTION OK");
			} catch (SQLException e) {
				System.out.println("CONNECTION NOK");
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			System.out.println("DRIVER NOK");
		}

	}

}
