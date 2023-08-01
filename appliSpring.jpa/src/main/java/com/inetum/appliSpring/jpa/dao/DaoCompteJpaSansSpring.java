package com.inetum.appliSpring.jpa.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.inetum.appliSpring.jpa.entity.Compte;


public class DaoCompteJpaSansSpring implements DaoCompte {
	
	private EntityManager entityManager;
	
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
		
	}

	@Override
	public Compte findById(Long numero) {
		 return entityManager.find(Compte.class, numero);
	}

	@Override
	public List<Compte>findByMini(Double soldeMini) {
	    return entityManager
	            .createQuery("SELECT c FROM Compte c WHERE c.solde > :soldeMini", Compte.class)
	            .setParameter("soldeMini", soldeMini)
	            .getResultList();
	}

	@Override
	public List<Compte>findByMaxi(Double soldeMaxi) {
	    return entityManager
	            .createQuery("SELECT c FROM Compte c WHERE c.solde < :soldeMaxi", Compte.class)
	            .setParameter("soldeMaxi", soldeMaxi)
	            .getResultList();
	}

	@Override
	public Compte insert(Compte comp) {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(comp);
			entityManager.getTransaction().commit();
			} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw new RuntimeException("echec insert(compte)");
			}
			return comp; 
	}

	@Override
	public void update(Compte comp) {
		try {
			entityManager.getTransaction().begin();
			entityManager.merge(comp);
			entityManager.getTransaction().commit();
			} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw new RuntimeException("echec update(compte)");
			}
	}

	@Override
	public void deletById(Long num) {
		try {
			entityManager.getTransaction().begin();
			Compte compAsupprimer = entityManager.find(Compte.class, num);
			entityManager.remove(compAsupprimer);
			entityManager.getTransaction().commit();
			} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw new RuntimeException("echec deletById");
			}
	}

	@Override
	public List<Compte> findAll() {
		return entityManager.createQuery("SELECT c FROM Compte c",Compte.class)
				.getResultList();
	}

	@Override
	public Compte findCompteWithOperationsById(Long numero) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Compte> findComptesOfClient(Long numClient) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void trouverEtDebiter(Long numCompte, double montantDebit) {
		// TODO Auto-generated method stub
		
	}

}
