package com.inetum.appliSpring.jpa.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.inetum.appliSpring.jpa.entity.Adresse;
import com.inetum.appliSpring.jpa.entity.Client;
import com.inetum.appliSpring.jpa.entity.Compte;
import com.inetum.appliSpring.jpa.entity.Personne;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@SpringBootTest  // classe interprétée par JUnit et SpringBoot
public class TestClientDao {
	
	Logger logger =  LoggerFactory.getLogger(TestClientDao.class);
	
	@Autowired // pour intialisation DaoCompte
	private DaoCompte daoCompteJpa;
	
	@Autowired // pour intialisation DaoCompte
	private DaoClient daoClientJpa;
	
	@Autowired 
	private DaoPersonne daoPersonneJpa;

	
	
	@Test
	public void testClientEtCompte(){
		
		Personne pers1 = daoPersonneJpa.insert(new Personne(null,"luc" , "SkyWalker"  ));
		logger.debug("pers1=" + pers1);

		Client Cl1 = new Client(null,"Anouar","EL KADIOUI");
		Cl1.setEtat(Personne.EtatPersonne.ENDORMIE);
		Cl1.setAdressePrincipale(new Adresse(null,"12 rue Aile" , "75012" , "Paris"));
		Cl1 = daoClientJpa.insert(Cl1);
		
		Client Cl2 = new Client(null,"Rabiae","EL KADIOUI");
		Cl2.setAdressePrincipale(new Adresse(null,"95 rue manin" , "75019" , "Paris"));
		Cl2 = daoClientJpa.insert(Cl2);
		
		
		
		Compte comp1 = new Compte(null, "A",10000.0); 
		comp1.getClients().add(Cl1);
		comp1 = daoCompteJpa.insert(comp1);
		Compte comp2 = new Compte(null, "B",2000.0);	
		comp2.getClients().add(Cl1);
		comp2 = daoCompteJpa.insert(comp2);
		
//		comp1.setClients(Cl1);
//		comp2.setClients(Cl1);
		Compte comp3 = new Compte(null, "C",1000.0);
		comp3.getClients().add(Cl2);
		comp3.getClients().add(Cl1);
		comp3 = daoCompteJpa.insert(comp3);
		Compte comp4 = new Compte(null, "D",4000.0);	
		comp4.getClients().add(Cl2);
		comp4.getClients().add(Cl1);
		comp4 = daoCompteJpa.insert(comp4);
//		comp3.setClients(Cl2);
//		comp4.setClients(Cl2);
		
		Client Cl1Relu = daoClientJpa.findClientWithcomptesById(Cl1.getNumero());
		logger.debug("Cl1Relu :=" + Cl1Relu);
		logger.debug("comptes de Cl1Relu =" + Cl1Relu.getComptes());
		assertTrue(Cl1Relu.getComptes().size()==4);
		assertEquals("75012",Cl1Relu.getAdressePrincipale().getCodePostal());
		
    	//V2: Si relation uni-directionnelle (codée que dans le sens principal: @ManyToOne ):
		
    	Client Cl1ReluV2 = daoClientJpa.findById(Cl1.getNumero());
    	logger.debug("Cl1ReluV2="+Cl1ReluV2);
    	assertEquals("Anouar" ,Cl1ReluV2.getPrenom() );
    
    	List<Compte> comptesDuCl1 = daoCompteJpa.findComptesOfClient(Cl1ReluV2.getNumero());
    	logger.debug("comptesDuCl1="+comptesDuCl1);
    	assertTrue(comptesDuCl1.size()==4);
    	
    	
    	Client Cl2Relu = daoClientJpa.findClientWithcomptesById(Cl2.getNumero());
    	logger.debug("Cl2Relu="+Cl2Relu);
    	assertEquals("Rabiae" ,Cl2Relu.getPrenom() );
    	logger.debug("comptes de Cl2Relu="+Cl2Relu.getComptes());
    	assertTrue(Cl2Relu.getComptes().size()==2);
    	
	}
}
