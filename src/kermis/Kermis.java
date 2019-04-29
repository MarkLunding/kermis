package kermis;

import java.util.ArrayList;
import java.util.Scanner;

class Kermis {
	ArrayList<Attractie> attracties = new ArrayList<>();
	Kassa kassa = new Kassa();

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
			System.out.println(bezoekAttractie);
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
				kassa.omzet += attracties.get(bezoekAttractie - 1).draaien();
				kassa.verkochteKaartjes++;
				break;
			case 20: // 20 is de waarde van k
				System.out.println("Het totaal aantalverkochte kaartjes is: " + kassa.verkochteKaartjes);
				break;
			case 24: // 24 is de waarde van o
				System.out.println("De totale kermis omzet is: " + kassa.omzet);
				break;

			}
		}
	}

	void initKermis() {
		System.out.println("Welkom op de kermis. In welke attractie wilt u?");
		System.out.println();
		System.out.print("1: Botsauto's | 2: Spin | 3: Spiegelpaleis | 4: Spookhuis | 5: Hawaii | 6: Ladderklimmen");
		System.out.println();
		System.out.println("0: Stoppen | o: omzet | k: kaartjes");
	}

	int startKermis() throws Exception {

		Scanner sc = new Scanner(System.in);
		String attractieInvoer = sc.nextLine();
		int eersteLetter = Character.getNumericValue(attractieInvoer.charAt(0));

		if (eersteLetter > 6) {
			char letterInvoer = attractieInvoer.charAt(0);
			if (letterInvoer != 'o' && letterInvoer != 'k') {
				throw new Exception();
			}
		}
		return eersteLetter;
	}
}
