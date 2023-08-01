package com.inetum.appliSpring.jpa.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;


@Entity 

@NamedQuery(name="Compte.findComptesOfClient",
query="SELECT c FROM Compte c LEFT JOIN c.clients cli WHERE  cli.numero = ?1")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "typeCompte",discriminatorType = DiscriminatorType.STRING)
public class Compte {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private Long numero;
	
	@Column(name="label", length =64)
	private String label;
	private Double solde;
	
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "compte", cascade = CascadeType.ALL)
	//@OneToMany(fetch = FetchType.EAGER, mappedBy = "compte")
	private List<Operation> operations; 

	public void addOperation(Operation op) {
		if(this.operations == null) this.operations = new ArrayList<>();
		operations.add(op);
	}
	
//	@ManyToOne  // Many compte To one client
//	  @JoinColumn(name = "id_client")
//	private Client client;
	

	@ManyToMany
	@JoinTable(name = "Compte_Client",
			joinColumns = {@JoinColumn(name = "num_compte")},
			inverseJoinColumns = {@JoinColumn(name = "id_client")})
	private List<Client> clients = new ArrayList<>(); //+get +set
	
	@Override
	public String toString() {
		return "Compte [numero=" + numero + ", label=" + label + ", solde=" + solde + "]";
	}
	public Compte() {
		super();
	}
	
//	public Compte(Long numero, String label, Double solde, Client client) {
//		super();
//		this.numero = numero;
//		this.label = label;
//		this.solde = solde;
//		this.client = client;
//	}
	
	public Compte(Long numero, String label, Double solde) {
		super();
		this.numero = numero;
		this.label = label;
		this.solde = solde;
	}
	public Long getNumero() {
		return numero;
	}
	public void setNumero(Long numero) {
		this.numero = numero;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public Double getSolde() {
		return solde;
	}
	
	public void setSolde(Double solde) {
		this.solde = solde;
	}
	
	public List<Operation> getOperations() {
		return operations;
	}
	
	public void setOperations(List<Operation> operations) {
		this.operations = operations;
	}
	
	public List<Client> getClients() {
		return clients;
	}
	
	public void setClients(List<Client> clients) {
		this.clients = clients;
	}
	
//	public Client getClient() {
//		return client;
//	}
//	public void setClient(Client client) {
//		this.client = client;
//	}


	
}
