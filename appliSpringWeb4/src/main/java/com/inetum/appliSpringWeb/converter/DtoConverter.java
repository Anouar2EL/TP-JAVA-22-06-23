package com.inetum.appliSpringWeb.converter;

import java.util.List;

import com.inetum.appliSpringWeb.dto.CompteDto;
import com.inetum.appliSpringWeb.dto.CustomerDto;
import com.inetum.appliSpringWeb.entity.Compte;
import com.inetum.appliSpringWeb.entity.Customer;

public class DtoConverter {

	public  /*static*/List<CompteDto> compteToCompteDto(List<Compte>  entityList) {
		return entityList.stream().map(entity->compteToCompteDto(entity)).toList();
	}
	public /*static*/ CompteDto compteToCompteDto(Compte entity) {
		return new CompteDto(entity.getNumero(),entity.getLabel(), entity.getSolde());
	}

	public /*static*/ Compte compteDtoToCompte(CompteDto dto) {
		return new Compte(dto.getNumero(),dto.getLabel(), dto.getSolde());
	}
	
	public /*static*/ CustomerDto customerToCustomerDto(Customer entity) {
		return new CustomerDto(entity.getId(),entity.getFirstname(),entity.getLastname(),entity.getPassword());
	}
	
	public /*static*/ Customer customerDtoToCustomer(CustomerDto dto) {
		return new Customer(dto.getId(),dto.getFirstname(),dto.getLastname(),dto.getPassword());
	}
	
	
}
