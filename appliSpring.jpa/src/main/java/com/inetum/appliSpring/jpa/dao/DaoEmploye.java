package com.inetum.appliSpring.jpa.dao;

import java.util.List;

import com.inetum.appliSpring.jpa.entity.Employe;

/**
 * DAO = Data Access Object
 * avec méthode CRUD
 *
 */
public interface DaoEmploye {
	
	Employe findById(Long numero);
	List<Employe> findAll();
	List<Employe> findByPrenom(String prenom);
	//.....
	Employe insert(Employe emp);  // en retour employe avec numero auto_incrémenté
	void update(Employe emp);
	void deletById(long num);
	 
}
