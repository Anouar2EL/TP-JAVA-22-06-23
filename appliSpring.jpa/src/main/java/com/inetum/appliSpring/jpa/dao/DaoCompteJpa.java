package com.inetum.appliSpring.jpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.inetum.appliSpring.jpa.entity.Compte;

@Repository  // pour cette classe de DAO soit prise en charge par Spring
@Transactional  // pour demander commit/rollback automatiques
public class DaoCompteJpa implements DaoCompte {
	
	

	@Override
	public Compte findCompteWithOperationsById(Long numero) {
		/*
		// solution1 (bidouille) :
		Compte compte = entityManager.find(Compte.class, numero);
		for(Operation op : compte.getOperations()) {
			//boucle for à vide sur les opartions en mode lazy
			//pour que ça déclenche des petits select qui remontent
			//tout de suite les valeurs en mémoire
			//avec la fin de la transaction  et avant entityManager.close() de Spring ou autre
			//===> ça évite LazyInitailisationException
		}
		return compte;
		*/
		
		//solution 2 (avec query spécifique):
		return entityManager
				.createNamedQuery("Compte.findCompteWithOperationsById",Compte.class)
				.setParameter(1,numero)//pour valeur de ?1
				.getSingleResult();
	}
	
	//NB: @PersistenceContext permet d'initialiser l'objet technique
	//entityManager à partir d'une configuration
	// src/main/resources/META-INF/persistence.xml
	// ou bien config spring équivalente dans src/main/resources/application.properties	
	@PersistenceContext
	private EntityManager entityManager;


	
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
			entityManager.persist(comp);
			return comp; 
	}

	@Override
	public void update(Compte comp) {
			entityManager.merge(comp);
	}

	@Override
	public void deletById(Long num) {
			Compte compAsupprimer = entityManager.find(Compte.class, num);
			entityManager.remove(compAsupprimer);
	}

	@Override
	public List<Compte> findAll() {
		return entityManager.createQuery("SELECT c FROM Compte c",Compte.class).getResultList();
	}



	@Override
	public List<Compte> findComptesOfClient(Long numClient) {
		return entityManager
				.createNamedQuery("Compte.findComptesOfClient",Compte.class)
				.setParameter(1,numClient)//pour valeur de ?1
				.getResultList();
	}

	@Override
	public void trouverEtDebiter(Long numCompte, double montantDebit) {
		Compte comptePersistant = entityManager.find(Compte.class, numCompte);
		comptePersistant.setSolde(comptePersistant.getSolde() - 20);
	}


}
