package com.inetum.appliSpringWeb.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor

@NamedQuery(name = "Customer.findByIdWithComptes",
query = "SELECT c FROM Customer c LEFT JOIN FETCH c.comptes WHERE c.id = ?1")

public class Customer {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String firstname;
	private String lastname;
	private String password;
	
	@JsonIgnore 
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "customer", cascade = CascadeType.ALL)
	private List<Compte> comptes; 
	
	
	
	public Customer(Long id, String firstname, String lastname, String password) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.password = password;
	}





	@Override
	public String toString() {
		return "Customer [id=" + id + ", firtname=" + firstname + ", lastname=" + lastname + ", password=" + password
				+ "]";
	}
	
	
	
	
	
}
