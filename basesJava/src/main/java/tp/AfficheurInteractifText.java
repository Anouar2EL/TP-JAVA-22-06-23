package tp;

import java.util.Scanner;

public class AfficheurInteractifText extends AfficheurText implements AfficheurInteractif {

	@Override
	public String saisirReponse(String question) {
		Scanner sc = new Scanner(System.in);
		System.out.println(question);
		return sc.nextLine();
	}



}
