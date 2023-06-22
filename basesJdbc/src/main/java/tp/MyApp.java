package tp;

import java.util.List;

import tp.dao.PersonneDAO;
import tp.dao.PersonneDaoJdbc;
import tp.dao.PersonneDaoSimu;
import tp.entity.Personne;

public class MyApp {
	
	
	public static void main(String[] args) {
		//testCrud();
		//testConnectionJdbc();
		testCrudJdbc();
	}

	
	public static void testCrudJdbc() {
		PersonneDAO personneDAO = new PersonneDaoJdbc();
		Personne p1 = new Personne(null,"jean", "Bon");
		Personne savedP1 = personneDAO.createPersonne(p1);
		System.out.println("savdP1 = " + savedP1.toString());
		
		List<Personne> personnes = personneDAO.rechercherToutesPersonnes();
		System.out.println("personnes : ");
		for (Personne personne : personnes) {
			System.out.println("\n" + personne);
		}
		
	}
	

	public static void testConnectionJdbc() {
		PersonneDaoJdbc personneDaoJdbc = new PersonneDaoJdbc();
		System.out.println("Connection établie = " + personneDaoJdbc.etablirConnection());
		
	}
	
	public static void testCrud() {
		PersonneDAO personneDAO = new PersonneDaoSimu();
		Personne p1 = new Personne(null,"jean", "Bon");
		Personne savedP1 = personneDAO.createPersonne(p1);
		System.out.println("savdP1 = " + savedP1.toString());
		
		
		Personne p2 = personneDAO.createPersonne(new Personne(null,"Axelle", "Aire"));
		System.out.println("savdP2 = " + p2.toString());
		
		// chengement des valeurs de p2 en mémoire
		p2.setPrenom("sandrine");
		
		// enregistrement des changements en base de données
		personneDAO.updatePersonne(p2);
		
		// recherche des enregistrements modifiés pour vérifier :
		
		Personne pMisAJour= personneDAO.rechercherPersonneParId(p2.getId());
        System.out.println("p2MisAJour=" + pMisAJour.toString());;

        // supprimer
        personneDAO.deletePersonne(p2.getId());

        // cherchrer toutes les personnes 
        List<Personne> personnes = personneDAO.rechercherToutesPersonnes();
        System.out.println("personnes");
        for (Personne personne : personnes) 
            System.out.println("\t" +personne);
	}
	
}
