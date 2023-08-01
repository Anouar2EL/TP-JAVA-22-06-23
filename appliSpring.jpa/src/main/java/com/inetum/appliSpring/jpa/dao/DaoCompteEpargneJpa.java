package com.inetum.appliSpring.jpa.dao;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;
import com.inetum.appliSpring.jpa.entity.CompteEpargne;


@Repository //pour cette classe de DAO soit prise en charge par Spring
@Transactional //pour demander commit/rollback automatiques
public class DaoCompteEpargneJpa extends DaoGenericJpa<CompteEpargne,Long> implements DaoCompteEpargne {


	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public EntityManager getEntityManager() {
		return this.entityManager;
	}

	public DaoCompteEpargneJpa() {
		super(CompteEpargne.class);
	}
}
