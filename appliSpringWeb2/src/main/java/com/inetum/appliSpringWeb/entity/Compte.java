package com.inetum.appliSpringWeb.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NamedQuery(name = "Compte.findAll", query = "SELECT c FROM Compte c")
@NamedQuery(name = "Compte.findBySoldeMini", 
            query = "SELECT c FROM Compte c WHERE c.solde>= ?1")
@NamedQuery(name = "Compte.findBySoldeMaxi", 
            query = "SELECT c FROM Compte c WHERE c.solde<= ?1")

@NamedQuery(name = "Compte.findByIdWithOperations",
			query = "SELECT c FROM Compte c LEFT JOIN FETCH c.operations WHERE c.numero = ?1")
        
@Getter @Setter @NoArgsConstructor
public class Compte {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long numero;
	
	private String label;
	
	private Double solde;
	
	@JsonIgnore 
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "compte", cascade = CascadeType.ALL)
	//@OneToMany(fetch = FetchType.EAGER, mappedBy = "compte")
	private List<Operation> operations; 
	
	
	@ManyToOne  // Many operation To one Compte
	@JoinColumn(name = "id_customer")
	private Customer customer;

	public Compte(Long numero, String label, Double solde) {
		super();
		this.numero = numero;
		this.label = label;
		this.solde = solde;
	}



	@Override
	public String toString() {
		return "Compte [numero=" + numero + ", label=" + label + ", solde=" + solde + "]";
	}
	
	
	

}