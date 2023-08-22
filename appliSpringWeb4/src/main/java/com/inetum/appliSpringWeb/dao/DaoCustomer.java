package com.inetum.appliSpringWeb.dao;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inetum.appliSpringWeb.entity.Customer;

/**
 * DAO = Data Access Object
 * avec méthode CRUD
 *
 */

public interface DaoCustomer extends JpaRepository<Customer,Long> {
	Optional<Customer> findByIdWithComptes(Long customerId);
	List<Customer> findByFirstnameAndLastname(String firstName, String lastName);
}