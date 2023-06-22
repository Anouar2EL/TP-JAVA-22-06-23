package tp;

public class Calcul {
	
	public double racineCaree(double x) throws MyException2{
		//...
		if (x > 0)
		return Math.sqrt(x);
		else 
			//throw new RuntimeException("racine carée prévue seulement pour x positif ");
			// throw new IllegalArgumentException("racine carée prévue seulement pour x positif");
			throw new MyException2("racine carée prévue seulement pour x positif");
	}
	
	public int division(int a, int b) {

		if(b==0)

			//throw new IllegalArgumentException("divisin par zéro interdite");
			throw new MyException2("divisin par zéro interdite");

		 else

			 return a/b;

		    }
	

}
