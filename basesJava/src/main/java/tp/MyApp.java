
package tp;

import java.util.ArrayList;
public class MyApp {
	
	public static final int TAILLE_MAX=24;

	public static void main(String[] args) {
		System.out.println("Hello world");
		// à lancer sous eclips avec Run as / java application
		//test_types();
		//test_personne();
		//test_String();
		//test_Tableaux();
		//test_Collection();
		//test_employe();
		//test_bagages();
		//test_Avion( );
		test_Afficheur( );
		
	}
	
	 public static void test_Afficheur( ) {
		 
		 AfficheurInteractif affinteractif = null; 
		 affinteractif = new AfficheurInteractifDialog();
		 
		 String age = affinteractif.saisirReponse(" quel est votre age");
		 affinteractif.afficher("votre age est " + age);
		 
		 String nom = affinteractif.saisirReponse(" quel est votre nom");
		 affinteractif.afficher("votre nom est " + nom);
		 		

	 }
    public static void test_Avion( ) {

        Avion a1 = new Avion();
        a1.setLabel("avion A320");
        a1.addBagages(new Sac("sac1", "rouge",12.0,15.0));
        a1.addBagages(new Valise("valise1", "bleu", 32.0,10.0,20.0,25.0));
        a1.addPersonnes(new Personne("Theo", "HERNANDEZ",27));
        a1.addPersonnes(new Personne("Bernard", "LOUDIERE",31));
        a1.addPersonnes(new Employe("Anouar", "EL IDRISSI",27,5000,"Transavia"));
        a1.addPersonnes(new Employe("Rabiae", "EL KADIOUI",24,4000,"Transavia"));
        a1.afficher();

    }
	
	public static void test_bagages(){
		Bagage b = null;
		b = new Sac("sac1","rouge", 12.0,15.0);
		System.out.println(" b  = " + b.toString());
		System.out.println(" volume en litres de b  = " + b.getVolume());
		
		b= new Valise("valise", "bleu" , 32.0 ,10.0, 20.0 , 30.0);
		System.out.println(" b  = " + b.toString());
		System.out.println(" volume en litres de b  = " + b.getVolume());
		
		
	}
	
	public static void test_employe(){
		 Employe emp1 = new Employe();
		 emp1.setPrenom("Anouar"); emp1.setNom("ELKADIOUI");  emp1.setAge(26);
		 emp1.setSalaire(2000);
		 emp1.incrementerAge();
		 System.out.println("emp1 = " + emp1.toString());
		 
		 Employe emp2 = new Employe("Anouar", "EL IDRISSI",27,5000,"Transavia");
		 emp2.incrementerAge();
		 System.out.println("emp2 = " + emp2.toString());
		 
		 Personne p = null; 
		 p = new Personne("luc", "skywalker", 25);
		 System.out.println("p = " + p.toString());
		 
		
		 
		 
	}
		 
		 
	/*
	public static void test_Collection(){
	
		String[] tabJours = new String[7];
		tabJours[0]="Lundi";
		tabJours[1]="Mardi";
		for (int i = 0 ; i < 7 ;i++ ) 
			System.out.println(tabJours[i]);
	
		
		
		// Avec collection :
		ArrayList<String> listeJours = new ArrayList<String>() ;
		listeJours.add("Lundi"); listeJours.add("Mardi");
		System.out.println("nombre de jours = " + listeJours.size()); 
		
		System.out.println("parcours 1 via for() avec indice i");
		for (int i = 0 ; i < listeJours.size() ;i++ ) 
			System.out.println(listeJours.get(i));
		
		System.out.println("\nparcours 2 via for() au sens forEach");
		for (String jour : listeJours) 
			System.out.println(jour + " ");
		
		ArrayList<Personne> listePersonnes = new ArrayList<Personne>() ;
		listePersonnes.add(new Personne("Theo", "HERNANDEZ",27) );
		listePersonnes.add(new Personne("Bernard", "LOUDIERE",31));
		
		System.out.println("liste de personnes de taille = "  + listePersonnes.size());
		for (Personne per : listePersonnes) 
			System.out.println("\t" + per);
		
	}
	
	*/
	
	/*
	public static void test_Tableaux(){
		// déclarer une référence sur un tableau de double
		double Tab[];	
		
		// créer le tableau d'une taille de 24
		Tab = new double [TAILLE_MAX] ; 
		
		// effectuer une boucle for et placer en position i laracine carrée de i : math.sqrt'i)
    
        
        for (int i = 0 ; i < Tab.length ;i++ ) 
            Tab[i] =  Math.sqrt(i);            
         
		// afficher en boucle toutes les valeurs du tableau 
        System.out.println("Votre tableau est : " + Arrays.toString(Tab));

		
	}
	*/
	/*
	public static void test_String() {
		StringBuilder buffer = new StringBuilder(1024);
		buffer.append("1");
		for(int i=2;i<=64;i++) {
			buffer.append(",");
			buffer.append(i);
		}
		String ch = buffer.toString();
		System.out.println(ch);
			

	}
	*/
	/*
	public static void test_personne() {
		//Personne p1 = new Personne("Theo", "HERNANDEZ",27);
		Personne p1 = new Personne();
		//p1.prenom = "Theo"; // impossible depuis que prenom privé 
		p1.setPrenom("Théo");
		p1.setNom("HERNANDEZ");
		p1.setAge(27);
		Personne.setAgeMajorite(18);
		System.out.println("Age majorité est  " + Personne.getAgeMajorite() );
		System.out.println("pour p1  " + p1.majoriteAsString() );
		p1.incrementerAge();
		System.out.println("p1="+p1.toString());
		
		//Personne p2 = new Personne("Bernard", "LOUDIERE",31);
		Personne p2 = new Personne();
		p2.setPrenom("Bernard");
		p2.setNom("LOUDIERE");
		p2.setAge(31);
		Personne.setAgeMajorite(21);
		System.out.println("Age majorité est  " +  Personne.getAgeMajorite());
		System.out.println("pour p2  " + p2.majoriteAsString() );
		System.out.println("nom complet de p2 " + p2.nomComplet() );
		p2.incrementerAge();
		System.out.println("p2="+p2.toString());

		
	}
	*/

	/*
	public static void test_types() {
		int a=5;
		System.out.println("a="+a);
		String s1="15" , s2="3"; // s1 et s2 comportent des valeurs que l'on aurait pu saisir au clavier dan sune page htm ou autre
		
		// on souhaite calculer er afficher le résultat d'une addition des ces 2 valeurs 
		
		// concaténation
		System.out.println("la concaténation de s1 et s2 vaut : " + s1+s2);
		// addition
		int S1 = Integer.parseInt(s1); 
		int S2 = Integer.parseInt(s2); 
		int somme = S1 + S2 ;
		Integer objsomme = somme; // fait automatiquement = new Integer(somme);
		System.out.println("objsomme = " + objsomme);
		System.out.println("la somme de s1 et s2 vaut : " + somme);
	
		}
		*/
}
