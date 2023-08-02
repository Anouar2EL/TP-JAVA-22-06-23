package com.inetum.appliSpringWeb.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inetum.appliSpringWeb.dao.DaoCompte;
import com.inetum.appliSpringWeb.dao.DaoCustomer;
import com.inetum.appliSpringWeb.entity.Customer;


@Component 
@Service
@Transactional
public class ServiceCustomerImpl implements ServiceCustomer {

	Logger logger = LoggerFactory.getLogger(ServiceCustomerImpl.class);
	
	@Autowired
	private DaoCustomer daoCustomer; // dao principal
	@Autowired
	private DaoCompte daoCompte;


	@Override
	public boolean checkCustomerPassword(long customerId, String password) {
		Optional<Customer> optionalCustomer = daoCustomer.findById(customerId);
	//	Customer customer = daoCustomer.findById(customerId).get();
		if (optionalCustomer.isPresent()) {
	        Customer customer = optionalCustomer.get();
	        // Utilisez equals() pour comparer des chaînes de manière sûre
	        if (customer.getPassword().equals(password)) {
	            return true;
	        }
	    }
		return false;
	}

	@Override
	public String resetCustomerPassword(long customerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer rechercherCustomerParId(long idCustomer) {
		return daoCustomer.findById(idCustomer).orElse(null);
	}

	@Override
	public Customer rechercherCustomerAvecComptesParNumero(long idCustomer) {
		return daoCustomer.findByIdWithComptes(idCustomer).orElse(null);
	}

	@Override
	public List<Customer> rechercherCustomerSelonPrenomEtNom(String prenom, String nom) {
		return daoCustomer.findByLastnameAndFirstname(prenom, nom);
	}

	@Override
	public Customer sauvegarderCustomer(Customer customer) {
		return daoCustomer.save(customer);
	}

	@Override
	public void supprimerCustomer(long idCustomer) {
		daoCustomer.deleteById(idCustomer);
		
	}

	@Override
	public boolean verifierExistanceCustomer(long idCustomer) {
		return daoCustomer.existsById(idCustomer);
	}
	
	

}
