package tp;

public class Personne implements Transportable {
	
	// déclarer une constante AGE_MAXI pour les personnes avec la valeur 150
	// et l'utiliser dans la méthode getAge()
	
	public static final int AGE_MAXI=150;
	private String prenom;
	private String nom;
	//int age;
	private Integer age;
	
	
	// ajouter un attribut "ageMajorité" en static (partagé par toutes les instances de personne) en int
	
	private static int ageMajorite = 18;
	
	
	
	public String getEmployeur() {
		return null;
	}
	
	public Personne(String prenom, String nom, Integer age) {
		super();
		this.prenom = prenom;
		this.nom = nom;
		this.age = age;
	}



	public String majoriteAsString() {
		// retourner "je suis majeur" ou bien "je suis mineur"
		
		if (this.age != null && this.age  >  ageMajorite ) return " je suis majeur";
		
		else return " Je suis mineur";
		
	}
	
	

	public static void setAgeMajorite(int ageMajorite) {
		Personne.ageMajorite = ageMajorite;
	}
	
	


	public static int getAgeMajorite() {
		return ageMajorite;
	}



	public Personne() {
		super();
	}


	public void setAge(Integer age) {
		if (age > 0 && age <AGE_MAXI)
			this.age = age;
		else System.out.println("erreur");
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	@Override
	public String toString() {
		return "Personne [prenom=" + prenom + ", nom=" + nom + ", age=" + age + "]";
	}
	

	public void incrementerAge(){
		//un an de plus (ça modifie l'age interne de l'objet personne, main pas de return)
		if(age != null)
			this.age++;
	}
	public String nomComplet(){
		// retourner la concaténation de prenom et du nom
		// valeur de retour de type string
		return this.prenom + this.nom;
	}

	private static final double POIDS_MOYEN = 70.0;
	private static final double VOLUME_MOYEN = 70.0;
	
	@Override
	public double getPoids() {
		return POIDS_MOYEN;
	}

	@Override
	public double getVolume() {
		return VOLUME_MOYEN;
	}
}
