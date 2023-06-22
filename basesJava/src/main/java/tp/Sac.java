package tp;

public class Sac extends Bagage {
	private double volume;
	
	
	public Sac() {
		super();
		this.volume = 10;
	}
	
	
	public Sac(String label, String couleur, double poids, double volume) {
		super(label, couleur, poids);
		this.volume = volume;
	}



	public void setVolume(double volume) {
		this.volume = volume;
	}

	@Override
	public double getVolume() {
		return this.volume;
	}


	@Override
	public String toString() {
		return "Sac [volume=" + volume + ", héritant de " + super.toString() + "]";
	}



	

}
