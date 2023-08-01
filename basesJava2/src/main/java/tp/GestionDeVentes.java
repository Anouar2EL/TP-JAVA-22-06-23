package tp;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GestionDeVentes {

	private List<Vente> listeVentes= new ArrayList<>();
	
	public void lireFichier(String fileName) {

		try {
			// permet de lire toute la ligne
			FileInputStream fis = new FileInputStream(fileName);
			BufferedReader br = new BufferedReader(new InputStreamReader(fis));
			br.readLine();
		
			
			String ligne=br.readLine();
			while(ligne != null) {
		
				 String[] t = ligne.split(";");
				 Vente p = new Vente(t[0],Integer.parseInt(t[1]),Long.parseLong(t[2]));
				 this.listeVentes.add(p);
				 ligne=br.readLine();
			
		} 
			br.close();
			fis.close();
		}
			catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	// avec lambda 
	
	public void afficherFichierv2() {
		

		
		Collections.sort(this.listeVentes, (o1,o2) ->  (int)(o1.getCa()- o2.getCa() ) );
		
		System.out.println("Ventes par ca croissants : ");
		for (Vente v : listeVentes) 
			System.out.println("   \t" + v); //toString() implicite
		
		
		Collections.sort(this.listeVentes,
				(Vente o1 , Vente o2) -> { return o1.getDomaine().compareToIgnoreCase(o2.getDomaine());});

		System.out.println("Ventes par domaine croissants : ");
		for (Vente v : listeVentes) 
			System.out.println("   \t" + v); //toString() implicite
		
	}
	
	// avec streams
	
	public void afficherFichierv3() {
		
		System.out.println("Ventes : ");
		
		//this.listeVentes.stream()
						//	.forEach((v) -> { System.out.println("   \t" + v); } ) ;
		
	      /*

        this.listeVentes.stream()

                            .sorted((o1,o2) -> (int) (o1.getCa() - o2.getCa() ))

                            .forEach( (v)-> {System.out.println("\t" + v);} );

        */

        

        List<Vente>listeVentesTriesParCa=
                this.listeVentes.stream()
                		.filter((v) -> v.getDomaine().equalsIgnoreCase("audio"))
                		.sorted((o1,o2) -> (int) (o1.getCa() - o2.getCa()))
                		.collect(Collectors.toList());

        for (Vente vente : listeVentesTriesParCa) {
            System.out.println("\t" + vente);

        }
			
		}
	
	
	public void afficherFichier() {
		// tp, trier la liste de ventes par ca
		
			
			Collections.sort(this.listeVentes,new ComparateurDeVentes());
			
			System.out.println("liste de ventes de taille = "  + listeVentes.size());
			for (Vente v : listeVentes) 
				System.out.println("   \t" + v);
			
			
		
		}
		
		
	
	
	public void ecrireeFichier(String fileName) {
		
		long ca_total=0;
		
		Map<String,List<Vente>> mapVentesParDomaine = new HashMap<>();
		for (Vente v : listeVentes) {
			String domaine = v.getDomaine();
			List<Vente> sousListe = mapVentesParDomaine.get(domaine);
			}
		
		try {
			FileOutputStream of = new FileOutputStream("stats.csv.txt");
			PrintStream ps = new PrintStream(of);
			ps.println("domaine;ca_total");
			
			for (Vente i : listeVentes) 
				ca_total = ca_total + i.getCa();
			ps.println("all ; " + ca_total );
			ps.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}