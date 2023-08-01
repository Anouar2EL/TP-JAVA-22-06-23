package fr.inetum.formation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestConnection {

	public static void main(String[] args) {
		Connection connection = null;
		
		try {
			//1 -> Chargement du driver de la BD
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("DRIVER OK");	
			
			// 2 -> On établit la connection a la BD 
			final String URL = "jdbc:mysql://localhost:3306/inetum_bd";
			final String USER = "root";
			final String PASSWORD = "";
			
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("CONNECTION OK");
		
		
			} catch (ClassNotFoundException e) {
			
				System.out.println("DRIVER NOK");
			} catch (SQLException e) {
				System.out.println("CONNECTION NOK");
			}finally {
			// 3 -> On ferme la connection apres usage 
				if( connection !=null)
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
	}
}
