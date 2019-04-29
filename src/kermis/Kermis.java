package kermis;

import java.util.ArrayList;
import java.util.Scanner;


class Kermis {
	ArrayList<Attractie> attracties = new ArrayList<>();
	Kermis() {
		this.attracties.add(new Botsauto());
		this.attracties.add(new Spin());
		this.attracties.add(new Spiegelpaleis());
		this.attracties.add(new Spookhuis());
		this.attracties.add(new Hawaii());
		this.attracties.add(new Ladderklimmen());
		initKermis();
		
	}

	void bezoekKermis() {
		boolean bezoek = true;
		
		while (bezoek) {
			int bezoekAttractie;
			try {
				bezoekAttractie = this.startKermis();
			} catch (Exception e) {
				System.out.println("De ingevoerde waarde is ongeldig.");
				continue;
			}
			switch (bezoekAttractie) {
			case 0:
				bezoek = false;
				break;
			case 1:
			case 2:
			case 3:
			case 4:
			case 5:
			case 6:
				attracties.get(bezoekAttractie-1).draaien();
				break;
			}
		}
	}
	
	void initKermis() {
		System.out.println("Welkom op de kermis. In welke attractie wilt u?");
		System.out.println("1: Botsauto's");
		System.out.println("2: Spin");
		System.out.println("3: Spiegelpaleis");
		System.out.println("4: Spookhuis");
		System.out.println("5: Hawaii");
		System.out.println("6: Ladderklimmen");
		System.out.println("0: Stoppen");
	}
	

	int startKermis() throws Exception {
		

		Scanner sc = new Scanner(System.in);
		String attractieInvoer = sc.nextLine();
		int eersteLetter = Character.getNumericValue(attractieInvoer.charAt(0));

		if (eersteLetter > 6) {
			throw new Exception();
		}
		return eersteLetter;
	}
}
