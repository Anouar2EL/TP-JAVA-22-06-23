package fr.inetum.formation.mvc;

public class ConverterTemperature {
	

	public String convertir(int tempu , char convert){
		 
		if(convert == 'F'){
			tempu = (tempu * 9/5) + 32;
		}
		else {
			tempu = (tempu - 32) * 5/9;
	 
		}
		return "" + tempu;

	}


}