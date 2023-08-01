package com.inetum.appliSpring.jpa.entity;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
// bientot import jakarta.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

@Entity
@NamedQuery(name = "Client.findAll", query = "SELECT c FROM Client c")
@NamedQuery(name = "Client.findClientWithcomptesById", 
query = "SELECT c FROM Client c LEFT JOIN FETCH c.comptes cpt WHERE c.numero = ?1")
@DiscriminatorValue(value="Client")
public class Client extends Personne{
	

	
	
	//@OneToMany(fetch = FetchType.LAZY , mappedBy = "client")
	@ManyToMany(fetch = FetchType.LAZY , mappedBy = "clients")
	private List<Compte> comptes;//+get/set
	
	@OneToOne(optional = true, cascade = CascadeType.ALL )
	@JoinColumn(name = "idAdresse", unique = true)
	private Adresse adressePrincipale; // +get / set
	
	
	@Override
	public String toString() {
		return "Client " + super.toString();
	}

	public Client() {
		super();
	}

	public Client(Long numero, String prenom, String nom) {
		super(numero, prenom,nom);

	}
	


	public List<Compte> getComptes() {
		return comptes;
	}

	public void setComptes(List<Compte> comptes) {
		this.comptes = comptes;
	}

	public Adresse getAdressePrincipale() {
		return adressePrincipale;
	}

	public void setAdressePrincipale(Adresse adressePrincipale) {
		this.adressePrincipale = adressePrincipale;
	}

	

}