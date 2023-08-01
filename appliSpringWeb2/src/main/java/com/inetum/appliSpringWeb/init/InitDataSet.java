package com.inetum.appliSpringWeb.init;

import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.inetum.appliSpringWeb.dao.DaoCompte;
import com.inetum.appliSpringWeb.dao.DaoOperation;
import com.inetum.appliSpringWeb.entity.Compte;
import com.inetum.appliSpringWeb.entity.Operation;



@Component
@Profile("init")
public class InitDataSet {

	@Autowired
	private DaoCompte daoCompteJpa;
	
	@Autowired
	private DaoOperation daoOperationJp;
	
	@PostConstruct
	public void initData() {
		
		Compte compteAa = daoCompteJpa.save(new Compte(null,"compte_Aa" , 70.0));
		
		Operation op1CompteA = daoOperationJp.save(
	    		new Operation(null,-3.2 , "achat bonbons" , new Date() , compteAa));
		
		daoCompteJpa.save(new Compte(null, "BNP",50.0));
		daoCompteJpa.save(new Compte(null, "LCL",80.0));
		daoCompteJpa.save(new Compte(null, "HCK",-20.0));
		daoCompteJpa.save(new Compte(null, "RAM",-100.0));
		daoCompteJpa.save(new Compte(null, "BNP",100.0));
	}
}
