package com.inetum.appliSpring.jpa.dao;

import java.util.List;

import com.inetum.appliSpring.jpa.entity.Compte;


/**
 * DAO = Data Access Object
 * avec méthode CRUD
 *
 */

public interface DaoCompte {
	
	Compte findById(Long numero);
	Compte findCompteWithOperationsById(Long numero);
	List<Compte> findComptesOfClient(Long numClient);
	List<Compte> findAll();
	List<Compte> findByMini(Double soldeMini);
	List<Compte> findByMaxi(Double soldeMaxi);
	Compte insert(Compte comp);  // en retour Compte avec numero auto_incrémenté
	void update(Compte comp);
	void deletById(Long num);
	void trouverEtDebiter(Long numCompte, double montantDebit);
	 

}
