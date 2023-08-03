package com.inetum.appliSpringWeb.service;

import java.util.List;

import com.inetum.appliSpringWeb.entity.Customer;

public interface ServiceCustomer {

	boolean checkCustomerPassword(long customerId, String password);
	String resetCustomerPassword(long customerId);
	//...
	//méthodes déléguées aux DAOs le CRUD:
	Customer rechercherCustomerParId(long idCustomer); 
	Customer rechercherCustomerAvecComptesParNumero(long idCustomer); 
	
	List<Customer> rechercherCustomerSelonPrenomEtNom(String prenom,String nom); 

	//...
	Customer sauvegarderCustomer(Customer customer);
	void supprimerCustomer(long idCustomer);
	boolean verifierExistanceCustomer(long idCustomer);
	
}
