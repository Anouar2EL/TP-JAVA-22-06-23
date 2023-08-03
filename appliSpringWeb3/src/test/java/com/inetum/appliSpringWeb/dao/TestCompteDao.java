package com.inetum.appliSpringWeb.dao;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.inetum.appliSpringWeb.entity.Compte;
import com.inetum.appliSpringWeb.entity.Customer;
import com.inetum.appliSpringWeb.entity.Operation;

@SpringBootTest // classe interprétée par JUnit et SpringBoot
@ActiveProfiles("oracle")
public class TestCompteDao {
	
	Logger logger = LoggerFactory.getLogger(TestCompteDao.class);
	
	@Autowired //pour initialisation daoCompte
	//qui va référencer un composant Spring existant compatible
	//avec l'interface DaoCompte (DaoCompteJpa avec@Repository)
	private DaoCompte daoCompteJpa;
	
	@Autowired 
	private DaoOperation daoOperationJpa;
	
	@Autowired
	private DaoCustomer doCustomerJpa;
	@Test 
	public void testCompteAvecOperations() {
		
		Compte compteAa = daoCompteJpa.save(new Compte(null,"compte_Aa" , 70.0));
		
		Operation op1CompteAa = daoOperationJpa.save(
	    		new Operation(null,-3.2 , "achat bonbons" , new Date() , compteAa));
		
		Compte compteBb = daoCompteJpa.save(new Compte(null,"compte_Bb" , 3000.0));
		
		Operation op1CompteBb = daoOperationJpa.save(
	    		new Operation(null,-1150.0 , "achat d'ordinateur" , new Date() , compteBb));
		
		Compte compteCc = daoCompteJpa.save(new Compte(null,"compte_Cc" , 700.0));
		
		Operation op1CompteCc = daoOperationJpa.save(
	    		new Operation(null,-35.55 , "achat de livres" , new Date() , compteCc));
		
		Compte compteDd = daoCompteJpa.save(new Compte(null,"compte_Dd" , 1000.0));
		
		Operation op1CompteDd = daoOperationJpa.save(
	    		new Operation(null,-150.0 , "achat DDR" , new Date() , compteDd));
			
		Compte compteAaRelu = daoCompteJpa.findByIdWithOperations(compteAa.getNumero()).orElse(null);	
		logger.trace("compteAaRelu="+compteAaRelu);
		
		logger.trace("Operations du compteARelu :");
		for(Operation op : compteAaRelu.getOperations()) {
			logger.trace("\t"+op.toString());
		}
		
		Customer customer1 = doCustomerJpa.save(new Customer(null,"Anouar","EL IDRISSI","123"));
		compteAa.setCustomer(customer1);
		compteAa=daoCompteJpa.save(compteAa);
		compteBb.setCustomer(customer1);
		compteBb=daoCompteJpa.save(compteBb);
		
		Customer customer2 = doCustomerJpa.save(new Customer(null,"Julien","DEBOIT","321"));
		compteCc.setCustomer(customer2);
		compteCc=daoCompteJpa.save(compteCc);
		compteDd.setCustomer(customer2);
		compteDd=daoCompteJpa.save(compteDd);
		
		
		List<Compte> customer1Relu = daoCompteJpa.findByCustomerId(customer1.getId());
		logger.trace("customer1Relu="+customer1Relu);
		List<Compte> customer2Relu = daoCompteJpa.findByCustomerId(customer2.getId());
		logger.trace("customer2Relu="+customer2Relu);
	}
	
	
	
	@Test
	public void testQueries() {
		daoCompteJpa.save(new Compte(null,"compte_A" , 50.0));
    	daoCompteJpa.save(new Compte(null,"compte_B" , 80.0));
    	daoCompteJpa.save(new Compte(null,"compte_C" , 250.0));
    	daoCompteJpa.save(new Compte(null,"compte_D" , 540.0));    			
		//List<Compte> comptesAvecSoldeMini100 = daoCompteJpa.findBySoldeGreaterThanEqual(100.0);
		List<Compte> comptesAvecSoldeMini100 = daoCompteJpa.findBySoldeMini(100.0);
		assertTrue(comptesAvecSoldeMini100.size()>=2);
		
		logger.trace("comptesAvecSoldeMini100="+comptesAvecSoldeMini100);
		
		List<Compte> comptesAvecSoldeMaxi100 = daoCompteJpa.findBySoldeLessThanEqual(100.0);
		assertTrue(comptesAvecSoldeMaxi100.size()>=2);
		
		logger.trace("comptesAvecSoldeMaxi100="+comptesAvecSoldeMaxi100);
	}

}