package com.inetum.appliSpringWeb.service;

import java.util.List;

import com.inetum.appliSpringWeb.dto.CustomerDto;
import com.inetum.appliSpringWeb.entity.Customer;

public interface ServiceCustomer extends GenericService<Customer,Long,CustomerDto> {

	boolean checkCustomerPassword(long customerId, String password);
	String resetCustomerPassword(long customerId);
	//...
	//méthodes déléguées aux DAOs le CRUD:
	//Customer searchById(long idCustomer); 
	Customer rechercherCustomerAvecComptesParNumero(long idCustomer); 
	
	List<Customer> rechercherCustomerSelonPrenomEtNom(String prenom,String nom); 

	//...
	//Customer saveOrUpdate(Customer customer);
	//void deleteById(long idCustomer);
	//boolean exsistById(long idCustomer);
	
}
