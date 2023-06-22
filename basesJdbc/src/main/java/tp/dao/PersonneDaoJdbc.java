package tp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import tp.entity.Personne;

public class PersonneDaoJdbc implements PersonneDAO {

	
	public Connection etablirConnection() {
		Connection cn = null;
		try {
			ResourceBundle ressources = ResourceBundle.getBundle("paramDB") ; // paramDB.properties
			 String driver = ressources.getString("driver");
			 String chUrl = ressources.getString("url");
			 String username = ressources.getString("username"); 
			 String password = ressources.getString("password");
			 Class.forName(driver); cn = DriverManager.getConnection(chUrl,username,password) ;
		} catch (ClassNotFoundException e) {
			System.err.println("le drivr jdbc ne peut pas etre chargé en mémoire, erreur de nom ou bien oubli dans ");
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return cn;
	}
	
	@Override
	public Personne createPersonne(Personne p) {
		Connection cn = this.etablirConnection();
		try {
			/*
			Statement st = cn.createStatement();
			String reqSql = "INSERT INTO personne(prenom,nom) VALUES(' "
								+ p.getPrenom() + "','" + p.getNom() + "')";
			int nblignesAffectees = st.executeUpdate(reqSql);
			*/
			PreparedStatement st = cn.prepareStatement("INSERT INTO personne(prenom,nom) VALUES(?,?)",
					Statement.RETURN_GENERATED_KEYS);
			st.setString(1, p.getPrenom());
			st.setString(2, p.getNom());
			int nblignesAffectees = st.executeUpdate();
			Integer AutoIncremente = recupValeurAutoIncrPk(st);
			p.setId(AutoIncremente);
			//System.out.println("nb lignes inserees: " + nblignesAffectees);
			st.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
	}

		Integer recupValeurAutoIncrPk(PreparedStatement pst){
		Integer pk=null;
		try {
		 ResultSet rsKeys = pst.getGeneratedKeys();
		 if(rsKeys.next()){ pk= rsKeys.getInt(1) ;  }
		} catch (SQLException e) { e.printStackTrace(); }
		 return pk;
		}


	@Override
	public Personne rechercherPersonneParId(Integer idPers) {
		return null;
	    }

	@Override
	public List<Personne> rechercherToutesPersonnes() {
		List<Personne> listePersonnes = new ArrayList<>();
        try ( Connection cn = this.etablirConnection()) {
            Statement st = cn.createStatement();
            String reqsql = "SELECT * FROM personne";
            ResultSet rs = st.executeQuery(reqsql);
            while(rs.next())  {
                Integer id = rs.getInt("id");
                String nom = rs.getString("nom"); // récupérer la valeur du champ "NOM"   
                String prenom = rs.getString("prenom");
                Personne p = new Personne(id, prenom, nom);
                listePersonnes.add(p);

                }
            rs.close();
            st.close();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return listePersonnes;
	}

	@Override
	public void updatePersonne(Personne p) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deletePersonne(Integer idPers) {
		// TODO Auto-generated method stub

	}

}
