package com.inetum.appliSpringWeb.service;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inetum.appliSpringWeb.dao.DaoCompte;
import com.inetum.appliSpringWeb.dao.DaoOperation;
import com.inetum.appliSpringWeb.entity.Compte;
import com.inetum.appliSpringWeb.entity.Operation;
import com.inetum.appliSpringWeb.exception.BankException;


@Component // pour que la classe soit prise en compte par Spring
@Service
@Transactional
public class ServiceCompteImpl implements ServiceCompte {

	Logger logger = LoggerFactory.getLogger(ServiceCompteImpl.class);
	
	@Autowired
	private DaoCompte daoCompte; // dao principal
	
	@Autowired
	private DaoOperation daoOperation; // dao secondaire
	
	@Override
	//@Transactional(propagation = Propagation.REQUIRED) // par défaut
	//@Transactional() // maintenat au dessus de la classe entière
	public void transferer(double montant, long numCptDeb, long numCptCred) throws BankException {
		try {
			/*
			Compte compteDeb =  daoCompte.findById(numCptDeb).get();
			compteDeb.setSolde(compteDeb.getSolde() - montant);
			daoCompte.save(compteDeb);
			*/
			this.debiterCompte(numCptDeb, montant, "debit suite au virement vers le compte" + numCptCred);
			/*
			Compte compteCred =  daoCompte.findById(numCptCred).get();
			compteCred.setSolde(compteCred.getSolde() + montant);
			daoCompte.save(compteCred);
			*/
			this.crediterCompte(numCptCred, montant, "credit suite au virement vers le compte" + numCptDeb);
		} catch (Exception e) {
			//logger.error(" echec virement",e);
			logger.error(" echec virement" + e.getMessage());
			throw new BankException(" echec virement",e);
			//e.printStackTrace();
			
		}
	}

	@Override
	public void debiterCompte(long numeroCompte, double montant, String message) {
		Compte compteDeb =  daoCompte.findById(numeroCompte).get();
		double nouveauSoldeTheoriqueApresDebit = compteDeb.getSolde() - montant;
		if(nouveauSoldeTheoriqueApresDebit >= Compte.getDecouvertAutorise()) {
		compteDeb.setSolde(compteDeb.getSolde() - montant);
		daoCompte.save(compteDeb); // facultatif
		
		Operation opDebit = daoOperation.save(
	    		new Operation(null,-montant , message , new Date() , compteDeb));
		}else {
			throw new BankException("solde insiffusant vis à vis du découvertAutorise =" + 
		Compte.getDecouvertAutorise()+ " pour effectuer un débit de "+ montant);
		}
	}

	@Override
	public void crediterCompte(long numeroCompte, double montant, String message) {
		Compte compteCred =  daoCompte.findById(numeroCompte).get();
		compteCred.setSolde(compteCred.getSolde() + montant);
		daoCompte.save(compteCred); // facultatif
		
		Operation opCredit = daoOperation.save(
	    		new Operation(null, montant , message , new Date() , compteCred));
		
	}
	
	@Override
	public Compte rechercherCompteParNumero(long numeroCompte) {	
		return daoCompte.findById(numeroCompte).orElse(null);
	}

	@Override
	public List<Compte> rechercherComptesDuClient(long numeroCompte) {
		
		return daoCompte.findByCustomerId(numeroCompte);
	}

	@Override
	public Compte sauvgarderCompte(Compte compte) {
		return daoCompte.save(compte);
	}

	@Override
	public void supprimerCompte(long numeroCompte) {
		daoCompte.deleteById(numeroCompte);
	}

	@Override
	public boolean verefierExistanceCompte(long numeroCompte) {
		return daoCompte.existsById(numeroCompte);
	}

	@Override
	public Compte rechercherCompteAvecOperationsParNumero(long numeroCompte) {
		return daoCompte.findByIdWithOperations(numeroCompte).orElse(null);
	}

	@Override
	public List<Operation> operationsDuCompteQueJaime(long numeroCompte) {
		Compte cpt = daoCompte.findByIdWithOperations(numeroCompte).get();
		return cpt.getOperations();
	}

	@Override
	public List<Compte> rechercherTout() {
		return daoCompte.findAll();
	}

	@Override
	public List<Compte> TrouverParSoldeMin(Double soldeMini) {
		return daoCompte.findBySoldeGreaterThanEqual(soldeMini);
	}




}
