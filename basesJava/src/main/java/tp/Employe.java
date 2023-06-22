package tp;
/*
 la classe Emloye va hériter de la classe Personne et va ajouter un salaire de type Integer
 
 // avec get/set et constructeur par défaut "zéro paramètre" 
  et avec toStribg() appelant eventuellement  super.toString() en interne
  
 tester via myApp.test_employe() appelé par myApp.main()
 
 test_employe(){
 Empoye emp1 = new Empoye();
 emp1.setnom("Nom1");
 emp1.setSalaire(200.0);
 system.out.println("emp1" + emp1.toString())  */

public class Employe extends Personne {

	private Integer salaire;
	private String Employeur;
	
	
	public Employe() {
		super();
		this.salaire = 0;
	
	}

	public Employe(String prenom, String nom, Integer age, Integer salaire, String employeur) {
		super(prenom, nom, age);
		this.salaire = salaire;
		Employeur = employeur;
	}





	public Integer getSalaire() {
		return salaire;
	}


	public void setSalaire(Integer salaire) {
		this.salaire = salaire;
	}

	

	public String getEmployeur() {
		return Employeur;
	}

	public void setEmployeur(String employeur) {
		Employeur = employeur;
	}

	@Override
	public String toString() {
		return "Employe [salaire=" + salaire + ", Employeur=" + Employeur + ", héritant de " + super.toString() + "]";
	}






	
	
	
}


