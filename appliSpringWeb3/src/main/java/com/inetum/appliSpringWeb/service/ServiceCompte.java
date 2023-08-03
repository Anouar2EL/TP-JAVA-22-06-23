package com.inetum.appliSpringWeb.service;

import java.util.List;

import com.inetum.appliSpringWeb.dto.CompteDto;
import com.inetum.appliSpringWeb.entity.Compte;
import com.inetum.appliSpringWeb.entity.Operation;
import com.inetum.appliSpringWeb.exception.BankException;

// Busnisses Service // service de metier 
public interface ServiceCompte extends GenericService<Compte,Long,CompteDto> {
	// void spécifique au métier de la banque 
	void debiterCompte(long numeroCompte, double montant, String message);
	void crediterCompte(long numeroCompte, double montant, String message);
	void transferer(double montant, long numCptDeb, long numCptCred) throws BankException;
	// ...
	
	// méthodes déléguées aux DAOs 
	// Compte searchById(long numeroCompte); //  hérité de GenericService
	Compte rechercherCompteAvecOperationsParNumero(long numeroCompte);
	List<Operation> operationsDuCompteQueJaime(long numeroCompte);
	List<Compte> rechercherComptesDuClient(long numeroCompte);
	//...
	//Compte saveOrUpdate(Compte compte);//  hérité de GenericService
	//void deleteById(long numeroCompte);//  hérité de GenericService
	//boolean exsistById(long numeroCompte);//  hérité de GenericService
	//List<Compte> searchAll();//  hérité de GenericService
	List<Compte> TrouverParSoldeMin(Double soldeMini);
	}
