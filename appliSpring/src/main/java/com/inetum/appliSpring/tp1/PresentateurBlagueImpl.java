package com.inetum.appliSpring.tp1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class PresentateurBlagueImpl implements PresentateurBlague {

	@Autowired  @Qualifier("Drole")
	private GenerateurBlague generateurBlagueDrole;
	
	@Autowired  @Qualifier("PasDrole")
	private GenerateurBlague generateurBlaguePasDrole;
	
	

	@Override
	public void presenterBlague() {
		//une fois sur 2 blague "Drole" ou "PasDrole" :
		 boolean isDrole = Math.random() < 0.5;
		if(isDrole) {
			System.out.println("Nouvelle blague drole="+ generateurBlagueDrole.nouvelleBlague());
		}else {	
			System.err.println("Nouvelle blague pas drole="+ generateurBlaguePasDrole.nouvelleBlague());
		}
	}
}




