package com.inetum.appliSpring.tp1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("Drole")
public class GenerateurBlagueDrole implements GenerateurBlague {

	private List<String> Blague;
	@Override
	public String nouvelleBlague() {	
		
		// Initialisation de la liste de blagues
		Blague = new ArrayList<>();
		Blague.add("Pourquoi les plongeurs plongent-ils toujours en arrière ? Parce que sinon ils tombent dans le bateau !");
		Blague.add("Qu'est-ce qu'un rat avec une épée ? Un souris-samouraï !");
		Blague.add("Qu'est-ce qu'un octogone ? Un octogone a 8 angles, et toi t'as aucun ami !");
		Blague.add("Comment appelle-t-on un chat tombé dans un pot de peinture le jour de Noël ? Un chat peint de Noël !");
        // Ajoutez d'autres blagues ici...
		
		Random random = new Random();
        int randomIndex = random.nextInt(Blague.size());
        return Blague.get(randomIndex);
				
	}

}
