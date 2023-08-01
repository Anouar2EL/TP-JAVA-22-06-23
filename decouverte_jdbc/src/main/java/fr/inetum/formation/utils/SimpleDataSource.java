package fr.inetum.formation.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class SimpleDataSource {

	static String driver;
	static String url;
	static String username;
	static String password;

	/**
	 * permet de charger les parametres de connection à la BDD depuis le fichier de
	 * proprites
	 * 
	 * @param nomFichier le nom du fichier de proprietes contenant les params de
	 *                   connexion
	 * 
	 * @throws ClassNotFoundException si le driver de la BDD est introuvable
	 */
	public static void init(String nomFichier) throws ClassNotFoundException {
		ResourceBundle props = ResourceBundle.getBundle(nomFichier);

		driver = props.getString("mysql.driver");
		Class.forName(driver);

		url = props.getString("mysql.url");
		username = props.getString("mysql.username");
		password = props.getString("mysql.password");
	}

	/**
	 * Permet d'etablir une connection à la BDD à partir des parametres de connexion
	 * 
	 * @return la connexion java.sql
	 * @throws SQLException
	 */

	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, username, password);
	}
}
