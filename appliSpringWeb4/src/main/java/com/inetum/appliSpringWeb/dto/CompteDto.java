package com.inetum.appliSpringWeb.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * DATA TRANSFERT OBJECT
 * CompteDto sera une representation partielle simplifiée et adaptée de entity.Compte
 */

//@Getter @Setter  @ToString
@Data @NoArgsConstructor
public class CompteDto {

	private Long numero;
	private String label;
	private Double solde;
	
	
	public CompteDto(Long numero, String label, Double solde) {
		super();
		this.numero = numero;
		this.label = label;
		this.solde = solde;
	}
	

	
	
}
