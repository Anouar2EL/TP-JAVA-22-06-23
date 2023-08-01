package com.inetum.appliSpringWeb.dao;
import org.springframework.data.jpa.repository.JpaRepository;

import com.inetum.appliSpringWeb.entity.Customer;

/**
 * DAO = Data Access Object
 * avec méthode CRUD
 *
 */

public interface DaoCustomer extends JpaRepository<Customer,Long> {

}
