package tp;

import java.util.ArrayList;

public class Avion {
	
	private String label;
	
	private ArrayList<Bagage> bagages = new ArrayList<>();
	
	private ArrayList<Personne> personnes = new ArrayList<>();
	
	// List personnes
	
	public void addBagages(Bagage b) {
		this.bagages.add(b);
	}

	
	public void retirerBagages(Bagage b) {
		this.bagages.remove(b);
		
	}
 
	
	public double chargeUtile() {
		// calculer et retourner le poids total des éléments mis dans l'avion 
		double poidsTotal = 0.0;
		for(Bagage b : this.bagages)
			poidsTotal += b.getPoids();
		
		// ajouter le poids (moyen ou précis) de toutes les personnes :
		for (Transportable  personneTransportable : this.personnes) 
			poidsTotal += personneTransportable.getPoids();
	
		return poidsTotal;
		}
		
		
	


	public void afficher() {

        System.out.println("Avion.afficher()"+ this.label);
        System.out.println("chargeUtile  " +this.chargeUtile());
        System.out.println("bagages : " );
        for (Bagage b : this.bagages) {
        	// b est ici quellques fois de type Sac et d'autres fois de type valise 
            System.out.println("\t" + b.toString() + " de volume "+ b.getVolume());
            // b.toString() et b.getVolume() déclenche du POLYMORPHISME  
        }
		System.out.println("liste de personnes de taille = "  + personnes.size());
		for (Personne per : personnes) {
			System.out.println("\t" + per.toString() + "employeur = " + per.getEmployeur());		
			Transportable t = per;
			System.out.println("poids de la personne transportable = " +t.getPoids());
		}
    }
	
	// List personnes
	
	public void addPersonnes(Personne per) {
		this.personnes.add(per);
	}
	


	
	

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public ArrayList<Bagage> getBagages() {
		return bagages;
	}

	public void setBagages(ArrayList<Bagage> bagages) {
		this.bagages = bagages;
	}

	
	public ArrayList<Personne> getPersonnes() {
		return personnes;
	}


	public void setPersonnes(ArrayList<Personne> personnes) {
		this.personnes = personnes;
	}


	@Override
	public String toString() {
		return "Avion [label=" + label + ", bagages=" + bagages + ", personnes=" + personnes + ", toString()="
				+ super.toString() + "]";
	}




	
	
}
