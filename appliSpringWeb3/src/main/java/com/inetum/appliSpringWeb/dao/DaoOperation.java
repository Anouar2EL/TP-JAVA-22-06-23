package com.inetum.appliSpringWeb.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.inetum.appliSpringWeb.entity.Operation;

/**
 * DAO = Data Access Object
 * avec méthode CRUD
 *
 */

public interface DaoOperation extends JpaRepository<Operation,Long> {
	

}
