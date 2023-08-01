package fr.inetum.formation;

import java.sql.Connection;
import java.sql.SQLException;

import fr.inetum.formation.utils.SimpleDataSource;

public class TestSimpleDataSource {

	public static void main(String[] args) {
		try {
            SimpleDataSource.init("dbparams");
            System.out.println("DRIVER OK");
            
            try(Connection connection = SimpleDataSource.getConnection()) {
                System.out.println("connexion ok");
            } catch (SQLException e) {
                System.out.println("connexion nok");
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            System.out.println("DRIVER NOK");       
        }
      }
	}


