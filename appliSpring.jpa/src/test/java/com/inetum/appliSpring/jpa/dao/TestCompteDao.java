package com.inetum.appliSpring.jpa.dao;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.inetum.appliSpring.jpa.entity.Compte;
import com.inetum.appliSpring.jpa.entity.CompteEpargne;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@SpringBootTest  // classe interprétée par JUnit et SpringBoot
public class TestCompteDao {
	
	Logger logger =  LoggerFactory.getLogger(TestCompteDao.class);
	
	@Autowired // pour intialisation DaoCompte
	private DaoCompte daoCompteJpa;
	
	@Autowired // pour intialisation DaoCompte
	private DaoCompte daoCompteEpargneJpa;
	
	@Test 
	public void exprimentationPersistantDetache(){
	// création d'un compte avec un solde initial = 50
	
	//relire le compte pour modifier auusitot son solde en mémoire avec "-20 euros"
	
	// à l'état détaché et à l'état persistant 
		
		Compte compA1 = daoCompteJpa.insert(new Compte(null, "A1",50.0));
		Compte compA1ReluDetache = daoCompteJpa.findById(compA1.getNumero());
		System.err.println("compA1ReluDetache =:" + compA1ReluDetache);	
		// retirer 20 euros à l'état détaché
		compA1ReluDetache.setSolde(compA1ReluDetache.getSolde()-20); 
		Compte compA1EncoreRelu = daoCompteJpa.findById(compA1.getNumero());
		System.err.println("compA1EncoreRelu =:" + compA1EncoreRelu);	
		
		
		Compte compA2 = daoCompteJpa.insert(new Compte(null, "A2",50.0));
		Compte compA2ReluDetache = daoCompteJpa.findById(compA2.getNumero());
		System.err.println("compA2ReluDetache =:" + compA2ReluDetache);	
		 // retirer 20 euros à l'état persistant 
		daoCompteJpa.trouverEtDebiter(compA2.getNumero(), 20); 
		Compte compA2EncoreRelu = daoCompteJpa.findById(compA2.getNumero());
		System.err.println("compA2EncoreRelu =:" + compA2EncoreRelu);	
	}
	
	@Test
	public void testQueries(){
		
		// compte numero 1
				Compte comp1 = new Compte(null, "Anouar",10000.0);
				
				Compte comp1Sauvgarde = daoCompteJpa.insert(comp1);
				Long numComp1 = comp1Sauvgarde.getNumero();
				logger.trace("numero auto_incrémenté de comp1Sauvgarde :="+numComp1);	
				
				// compte numero 2
				Compte comp2 = new Compte(null, "Ussef",20000.0);
				Compte comp2Sauvgarde = daoCompteJpa.insert(comp2);
				Long numComp2 = comp2Sauvgarde.getNumero();
				logger.trace("numero auto_incrémenté de comp2Sauvgarde :="+numComp2);		
				
				// compte numero 3
				Compte comp3 = new Compte(null, "Karim",40000.0);
				Compte comp3Sauvgarde = daoCompteJpa.insert(comp3);
				Long numComp3 = comp3Sauvgarde.getNumero();
				logger.trace("numero auto_incrémenté de comp3Sauvgarde :="+numComp3);	
				
			
				Compte comp1Relu = daoCompteJpa.findById(numComp1);
				logger.trace("emp1Relu="+comp1Relu);
				
				Compte comp2Relu = daoCompteJpa.findById(numComp2);
				logger.trace("emp1Relu="+comp2Relu);

				Compte comp3Relu = daoCompteJpa.findById(numComp3);
				logger.trace("emp3Relu="+comp3Relu);
				
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
				logger.trace("comp1ReRelu après le mise a jour = "+ comp1ReRelu);
				
				Compte comp2ReRelu = daoCompteJpa.findById(numComp2);
				logger.trace("comp2ReRelu après le mise a jour = "+ comp2ReRelu);
				
				Compte comp3ReRelu = daoCompteJpa.findById(numComp3);
				logger.trace("comp3ReRelu après le mise a jour = "+ comp3ReRelu);
				
				
				
				daoCompteJpa.deletById(numComp1);
				Compte comp1ReReReluQuiExistePlus = daoCompteJpa.findById(numComp1);
				logger.trace("comp1ReReReluQuiExistePlus après la suppression = "
				+ comp1ReReReluQuiExistePlus);
				
				
				
				List<Compte> comptes = daoCompteJpa.findAll();
				for (Compte comp : comptes) {
					logger.trace("liste de comptes :" + comp);
				}
				
				daoCompteJpa.insert(new Compte(null, "luc", 400.0));
				daoCompteJpa.insert(new Compte(null, "Antonie", 70000.0));
				
				
				List<Compte> comptesAyantSildeMini = daoCompteJpa.findByMini(400.0);
				assertTrue(comptesAyantSildeMini.size()>=2);
				logger.trace("comptesAyantSildeMini  = "+ comptesAyantSildeMini);
				
				
				List<Compte> comptesAyantSildeMaxi = daoCompteJpa.findByMaxi( 8000.0);
				assertTrue(comptesAyantSildeMaxi.size()>=2);
				logger.trace("comptesAyantSildeMaxi  = "+ comptesAyantSildeMaxi);
				
				// compte epargne
				
//				CompteEpargne CE1 = new CompteEpargne(null, "Anouar",10000.0);
//				CE1.setTauxInteret(5);
//				Compte CE1Sauvgarde = daoCompteJpa.insert(CE1);
//				Long numCE1 = CE1Sauvgarde.getNumero();
//				logger.trace("numCE1 :="+numCE1);		
				
	}

}
