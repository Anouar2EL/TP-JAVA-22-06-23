package tp;
/**
 * 
 * @author Anouar
 *
 */
public abstract class Bagage implements Transportable {
	

	private String label;
	private String couleur;
	private double poids;
	protected String typeBagage;
	
	public abstract double getVolume();
	
	public Bagage() {
		super();
	}



	public Bagage(String label, String couleur, double poids) {
		super();
		this.label = label;
		this.couleur = couleur;
		this.poids = poids;
	}





	@Override
	public String toString() {
		return "Bagage [label=" + label + ", couleur=" + couleur + ", poids=" + poids + "]";
	}





	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}


	public String getCouleur() {
		return couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}



	public double getPoids() {
		return poids;
	}

	public void setPoids(double poids) {
		this.poids = poids;
	}



}
