package fr.inetum.formation;

import java.sql.Connection;
import java.sql.SQLException;

import fr.inetum.formation.utils.SimpleDataSource;

/*
* Permet de récupérer l'instance unique de la classe
* @return l'unique instance de la classe
* @throws ClassNotFoundException si le driver de bdd est ins
* @throws SQLEXception si un pb de connexion
*/
public class MaConnexion {
    private static MaConnexion instance;
    private Connection connection;
    private MaConnexion() throws ClassNotFoundException, SQLException{
        SimpleDataSource.init("dbparams");
        connection = SimpleDataSource.getConnection();
    }
    public static synchronized MaConnexion getInstance() throws SQLException, ClassNotFoundException{
        if(instance == null) {
            instance = new MaConnexion();
        }
        return instance;
       }
    public Connection getConnection( ) {
        return connection;
    }
    /*
     * permet de recupérer une connexion java.sql
     */
    public static void main(String[] args) {

    }
}

 
