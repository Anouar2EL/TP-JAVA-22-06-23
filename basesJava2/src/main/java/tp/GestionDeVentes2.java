package tp;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GestionDeVentes2 {

	private List<Vente> listeVentes= new ArrayList<>();
	
	public void lireFichier(String fileName) {
		Scanner sc = null;
		try {
			sc = new Scanner(Paths.get(fileName)); // permet de lire toute la ligne
			sc.nextLine();
		
			
			String ligne=sc.nextLine();
			while(ligne != null) {
		
				 String[] t = ligne.split(";");
				 Vente p = new Vente(t[0],Integer.parseInt(t[1]),Long.parseLong(t[2]));
				 this.listeVentes.add(p);
				 ligne=sc.hasNextLine()?sc.nextLine():null;
			
		} 
			sc.close();
			
		}
			catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}
	
	public void afficherFichier() {
		System.out.println("liste de ventes de taille = "  + listeVentes.size());
		for (Vente v : listeVentes) 
			System.out.println("   \t" + v);
	
	}
	
	
	public void ecrireeFichier(String fileName) {
		
		long ca_total=0;
		
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
