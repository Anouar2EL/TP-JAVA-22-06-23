package com.inetum.appliSpringWeb.init;

import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.inetum.appliSpringWeb.dao.DaoCompte;
import com.inetum.appliSpringWeb.dao.DaoOperation;
import com.inetum.appliSpringWeb.entity.Compte;
import com.inetum.appliSpringWeb.entity.Customer;
import com.inetum.appliSpringWeb.entity.Operation;
import com.inetum.appliSpringWeb.service.ServiceCompte;
import com.inetum.appliSpringWeb.service.ServiceCustomer;



@Component
@Profile("init")
public class InitDataSet {

	@Autowired
	private DaoCompte daoCompteJpa;
	
	@Autowired
	private ServiceCompte serviceCompte;
	
	@Autowired
	private ServiceCustomer serviceCustomer;
	
	@Autowired
	private DaoOperation daoOperationJp;
	
	
	@PostConstruct
	public void initData() {
		
		// comptes
		Compte compteAa = daoCompteJpa.save(new Compte(null,"compte_Aa" , 70.0));
		
		Operation op1CompteA = daoOperationJp.save(
	    		new Operation(null,-3.2 , "achat bonbons" , new Date() , compteAa));
		
		daoCompteJpa.save(new Compte(null, "BNP",50.0));
		daoCompteJpa.save(new Compte(null, "LCL",80.0));
		daoCompteJpa.save(new Compte(null, "HCK",-20.0));
		daoCompteJpa.save(new Compte(null, "RAM",-100.0));
		daoCompteJpa.save(new Compte(null, "BNP",100.0));
		
		
		// Customers
		
		Customer c1 = serviceCustomer.saveOrUpdate(
				new Customer(null,"prenom1" , "nom1" , "pwd1"));
		Customer c2 = serviceCustomer.saveOrUpdate(
				new Customer(null,"prenom2" , "nom2" , "pwd2"));
		
		Compte compteAdeC1 = new Compte(null,"compteAdeC1" , 70.0);
		compteAdeC1.setCustomer(c1);
		Compte compteBdeC1 = new Compte(null,"compteBdeC1" , 80.0);
		compteBdeC1.setCustomer(c1);
		
		compteAdeC1 = serviceCompte.saveOrUpdate(compteAdeC1);
		compteBdeC1 = serviceCompte.saveOrUpdate(compteBdeC1);
		
		Compte compte1deC2 = new Compte(null,"compte1deC2" , 40.0);
		compte1deC2.setCustomer(c2);
		compte1deC2 = serviceCompte.saveOrUpdate(compte1deC2);
		
		
	}
	

}
