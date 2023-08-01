package com.inetum.appliSpring.jpa;

import com.inetum.appliSpring.jpa.dao.DaoCompteJpaSansSpring;
import com.inetum.appliSpring.jpa.dao.DaoEmployeJpaSansSpring;
import com.inetum.appliSpring.jpa.entity.Compte;
import com.inetum.appliSpring.jpa.entity.Employe;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


// classe de démarrage de l'application (sans utiliser spring)
public class TestSansSpringApp {
	
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("appliSpringJpa");
       //NB: appliSpringJpa= name du persistent-unit configuré dans META-INF/persistence.xml
		
		EntityManager entityManager = emf.createEntityManager();
		
		testDaoEmploye(entityManager);
		testDaoCompte(entityManager);
		
		entityManager.close();
		emf.close();
	}
	
	public static void testDaoEmploye(EntityManager entityManager) {
		DaoEmployeJpaSansSpring daoEmployeJpa = new DaoEmployeJpaSansSpring();
		daoEmployeJpa.setEntityManager(entityManager);
		
		Employe emp1 = new Employe(null, "prenom1", "Nom");
		Employe emp1Sauvgarde = daoEmployeJpa.insert(emp1);
		Long numEmp1 = emp1Sauvgarde.getNumero();
		System.err.println("numero auto_incrémenté de emp1Sauvgarde :="+numEmp1);
		
		Employe emp1Relu = daoEmployeJpa.findById(numEmp1);
		System.err.println("emp1Relu="+emp1Relu);
		
		// modif en mémoire
		emp1Relu.setPrenom("nouveau_prenom");
		emp1Relu.setNom("nouveau_nom");
		
		// update en base 
		daoEmployeJpa.update(emp1Relu);
		
		
		Employe emp1ReRelu = daoEmployeJpa.findById(numEmp1);
		System.err.println("emp1ReRelu après le mise a jour = "+ emp1ReRelu);
		
		daoEmployeJpa.deletById(numEmp1);
		Employe emp1ReReReluQuiExistePlus = daoEmployeJpa.findById(numEmp1);
		System.err.println("emp1ReReReluQuiExistePlus après la suppression = "
		+ emp1ReReReluQuiExistePlus);

		
		List<Employe> employes = daoEmployeJpa.findAll();
		for (Employe emp : employes) {
			System.out.println(emp);
		}
		
		
		daoEmployeJpa.insert(new Employe(null, "luc", "skuwalker"));
		daoEmployeJpa.insert(new Employe(null, "luc", "ylucke"));
		
		daoEmployeJpa.insert(new Employe(null, "jean", "Aimare"));
		daoEmployeJpa.insert(new Employe(null, "jean", "Bon"));
		
		List<Employe> employesAyantPrenomJan = daoEmployeJpa.findByPrenom("luc");
		System.err.println("employesAyantPrenomJan  = "
				+ employesAyantPrenomJan);
		
	}
	
	
	
	public static void testDaoCompte(EntityManager entityManager) {
		DaoCompteJpaSansSpring daoCompteJpa = new DaoCompteJpaSansSpring();
		daoCompteJpa.setEntityManager(entityManager);
		
		// compte numero 1
		Compte comp1 = new Compte(null, "Anouar",10000.0);
		Compte comp1Sauvgarde = daoCompteJpa.insert(comp1);
		Long numComp1 = comp1Sauvgarde.getNumero();
		System.err.println("numero auto_incrémenté de comp1Sauvgarde :="+numComp1);	
		
		// compte numero 2
		Compte comp2 = new Compte(null, "Ussef",20000.0);
		Compte comp2Sauvgarde = daoCompteJpa.insert(comp2);
		Long numComp2 = comp2Sauvgarde.getNumero();
		System.err.println("numero auto_incrémenté de comp2Sauvgarde :="+numComp2);		
		
		// compte numero 3
		Compte comp3 = new Compte(null, "Karim",40000.0);
		Compte comp3Sauvgarde = daoCompteJpa.insert(comp3);
		Long numComp3 = comp3Sauvgarde.getNumero();
		System.err.println("numero auto_incrémenté de comp3Sauvgarde :="+numComp3);	
		
	
		Compte comp1Relu = daoCompteJpa.findById(numComp1);
		System.err.println("emp1Relu="+comp1Relu);
		
		Compte comp2Relu = daoCompteJpa.findById(numComp2);
		System.err.println("emp1Relu="+comp2Relu);

		Compte comp3Relu = daoCompteJpa.findById(numComp3);
		System.err.println("emp3Relu="+comp3Relu);
		
		// modif en mémoire
		comp1Relu.setLabel("Axel");
		comp1Relu.setSolde(5000.0);
		
		comp2Relu.setLabel("Anas");
		comp2Relu.setSolde(6000.0);
		
		comp3Relu.setLabel("Aire");
		comp3Relu.setSolde(8000.0);

		// update en base 
		daoCompteJpa.update(comp1Relu);
		daoCompteJpa.update(comp2Relu);
		daoCompteJpa.update(comp3Relu);

		
		Compte comp1ReRelu = daoCompteJpa.findById(numComp1);
		System.err.println("comp1ReRelu après le mise a jour = "+ comp1ReRelu);
		
		Compte comp2ReRelu = daoCompteJpa.findById(numComp2);
		System.err.println("comp2ReRelu après le mise a jour = "+ comp2ReRelu);
		
		Compte comp3ReRelu = daoCompteJpa.findById(numComp3);
		System.err.println("comp3ReRelu après le mise a jour = "+ comp3ReRelu);
		
		
		
		daoCompteJpa.deletById(numComp1);
		Compte comp1ReReReluQuiExistePlus = daoCompteJpa.findById(numComp1);
		System.err.println("comp1ReReReluQuiExistePlus après la suppression = "
		+ comp1ReReReluQuiExistePlus);
		
		
		
		List<Compte> comptes = daoCompteJpa.findAll();
		for (Compte comp : comptes) {
			System.out.println(comp);
		}
		
		daoCompteJpa.insert(new Compte(null, "luc", 400.0));
		daoCompteJpa.insert(new Compte(null, "Antonie", 70000.0));
		
		
		List<Compte> comptesAyantSildeMini = daoCompteJpa.findByMini(400.0);
		System.err.println("comptesAyantSildeMini  = "
				+ comptesAyantSildeMini);
		
		
		List<Compte> comptesAyantSildeMaxi = daoCompteJpa.findByMini(400.0);
		System.err.println("comptesAyantSildeMaxi  = "
				+ comptesAyantSildeMaxi);
		
	}
	

}