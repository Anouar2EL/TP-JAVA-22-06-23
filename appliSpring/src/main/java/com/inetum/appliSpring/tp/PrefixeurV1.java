package com.inetum.appliSpring.tp;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

//@Lazy // très rare 
//@Component  // pour que cette classe soit prise en charge par spring
//@Scope("singleton")
@Component
@Profile("V1")
public class PrefixeurV1 implements Prefixeur{

	private String prefixe="**";
	
	@Override
	public String prefixer(String chaine) {	
		return prefixe + chaine;
	}

	@Override
	public String prefixerMaj(String chaine) {
		return prefixe + chaine.toUpperCase();
	}

}
