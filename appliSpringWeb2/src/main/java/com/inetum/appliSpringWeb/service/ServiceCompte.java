package com.inetum.appliSpringWeb.service;

import java.util.List;

import com.inetum.appliSpringWeb.entity.Compte;
import com.inetum.appliSpringWeb.entity.Operation;
import com.inetum.appliSpringWeb.exception.BankException;

// Busnisses Service // service de metier 
public interface ServiceCompte {
	// void spécifique au métier de la banque 
	void debiterCompte(long numeroCompte, double montant, String message);
	void crediterCompte(long numeroCompte, double montant, String message);
	void transferer(double montant, long numCptDeb, long numCptCred) throws BankException;
	// ...
	
	// méthodes déléguées aux DAOs 
	Compte rechercherCompteParNumero(long numeroCompte);
	Compte rechercherCompteAvecOperationsParNumero(long numeroCompte);
	List<Operation> operationsDuCompteQueJaime(long numeroCompte);
	List<Compte> rechercherComptesDuClient(long numeroCompte);
	//...
	Compte sauvgarderCompte(Compte compte);
	void supprimerCompte(long numeroCompte);
	boolean verefierExistanceCompte(long numeroCompte);
	
	}
