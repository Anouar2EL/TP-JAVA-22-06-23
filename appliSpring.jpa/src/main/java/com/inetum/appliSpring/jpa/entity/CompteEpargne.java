package com.inetum.appliSpring.jpa.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "CompteEpargne")
public class CompteEpargne extends Compte {

	private Integer tauxInteret;

	
	
	public CompteEpargne(Long numero, String label, Double solde) {
		super(numero, label, solde);
	}
	
	
	public CompteEpargne() {
		super();
	}

	@Override
	public String toString() {
		return "Compte" + super.toString();
	}

	public Integer getTauxInteret() {
		return tauxInteret;
	}

	public void setTauxInteret(Integer tauxInteret) {
		this.tauxInteret = tauxInteret;
	}
	
	
	
	
}
