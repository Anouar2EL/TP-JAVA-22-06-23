package com.inetum.appliSpringWeb.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.inetum.appliSpringWeb.entity.Compte;
import com.inetum.appliSpringWeb.entity.Operation;
import com.inetum.appliSpringWeb.exception.BankException;


@SpringBootTest // classe interprétée par JUnit et SpringBoot
//@ActiveProfiles("oracle")
public class TestServiceCompte {

	Logger logger = LoggerFactory.getLogger(TestServiceCompte.class);
	
	@Autowired
	private ServiceCompte serviceCompte; 
	
	
	@Test
	public void testTransfertAnnuleSiPasAssezArgent() {
			Compte cptA = serviceCompte.sauvgarderCompte(new Compte(null,"compteA",500.0));
			Compte cptB = serviceCompte.sauvgarderCompte(new Compte(null,"compteB",1000.0));
			logger.trace("avant bon virement: cptA = " + cptA.getSolde() + " et cptB = " + cptB.getSolde());
			
			try {
				serviceCompte.transferer(2000, cptA.getNumero(), cptB.getNumero());
			} catch (BankException e) {
				logger.trace("exception normale en cas de virement annulé "
					     + e.getMessage());
			}		
			Compte cptA_apres = serviceCompte.rechercherCompteParNumero(cptA.getNumero());
			Compte cptB_apres = serviceCompte.rechercherCompteParNumero(cptB.getNumero());
			logger.trace("apres bon virement: cptA_apres = " + cptA_apres.getSolde() + " et cptB_apres = " + cptB_apres.getSolde());
			assertEquals(cptA.getSolde()  , cptA_apres.getSolde() , 0.0001);
			assertEquals(cptB.getSolde()  , cptB_apres.getSolde() , 0.0001);		
			
		
	}
	@Test
	public void testBonTransfert() {

			Compte cptA = serviceCompte.sauvgarderCompte(new Compte(null,"compteA",500.0));
			Compte cptB = serviceCompte.sauvgarderCompte(new Compte(null,"compteB",1000.0));
			logger.trace("avant bon virement: cptA = " + cptA.getSolde() + " et cptB = " + cptB.getSolde());
			serviceCompte.transferer(150, cptA.getNumero(), cptB.getNumero());
			Compte cptA_apres = serviceCompte.rechercherCompteAvecOperationsParNumero(cptA.getNumero());
			Compte cptB_apres = serviceCompte.rechercherCompteAvecOperationsParNumero(cptB.getNumero());
//			Compte cptA_apres = serviceCompte.rechercherCompteParNumero(cptA.getNumero());
//			Compte cptB_apres = serviceCompte.rechercherCompteParNumero(cptB.getNumero());
			logger.trace("apres bon virement: cptA_apres = " + cptA_apres.getSolde() + " et cptB_apres = " + cptB_apres.getSolde());
			assertEquals(cptA.getSolde() - 150 , cptA_apres.getSolde() , 0.0001);
			assertEquals(cptB.getSolde() + 150 , cptB_apres.getSolde() , 0.0001);
					
			logger.trace("listes des opérations du cptA_Apres :" );
			for(Operation op : cptA_apres.getOperations()) {
				logger.trace("\t" + op.toString());
			}

	}
	
	@Test
	public void testMauvaisTransfert() {
		Compte cptA = serviceCompte.sauvgarderCompte(new Compte(null,"compteAa",200.0));
		Compte cptB = serviceCompte.sauvgarderCompte(new Compte(null,"compteBb",4000.0));
		logger.trace("avant mauvais virement: cptA = " + cptA.getSolde() + " et cptB = " + cptB.getSolde());
		
		try {
			serviceCompte.transferer(20, cptA.getNumero(), -2);
			// -2 numero d'un compte à créditer qui n'existe pas 
		} catch (Exception e) {
			logger.trace("exeption normale en cas de mauvais virement"+e.getMessage());
		}
		
		Compte cptA_apres = serviceCompte.rechercherCompteParNumero(cptA.getNumero());
		Compte cptB_apres = serviceCompte.rechercherCompteParNumero(cptB.getNumero());
		logger.trace("apres mauvais virement: cptA_apres = " + cptA_apres.getSolde() + " et cptB_apres = " + cptB_apres.getSolde());
		assertEquals(cptA.getSolde() , cptA_apres.getSolde() , 0.0001);
		assertEquals(cptB.getSolde() , cptB_apres.getSolde() , 0.0001);
		
	}
	
	
}
