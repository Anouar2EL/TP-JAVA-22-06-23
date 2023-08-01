package com.inetum.appliSpring.tp;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;


@Component 
@Profile("V1")
public class SuffixeurV1 implements Suffixeur{

	private String suffixe="**";
	
	@Override
	public String suffixer(String chaine) {	
		return   chaine + suffixe;
	}

	@Override
	public String suffixerMaj(String chaine) {
		return chaine.toUpperCase() + suffixe ;
	}

}
