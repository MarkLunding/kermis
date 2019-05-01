package kermis;

import java.util.ArrayList;
import java.util.Scanner;

class Kermis {
	ArrayList<Attractie> attracties = new ArrayList<>();
	Kassa kassa = new Kassa();

	Kermis() {
		System.out.println("Welkom op de kermis.");
		System.out.println();
		this.attracties.add(new Botsauto());
		this.attracties.add(new Spin());
		this.attracties.add(new Spiegelpaleis());
		this.attracties.add(new Spookhuis());
		this.attracties.add(new Hawaii());
		this.attracties.add(new Ladderklimmen());
		System.out.println();
		initKermis();

	}

	void bezoekKermis() {
		boolean bezoekKermis = true;
		belastingInspecteur inspecteur = new belastingInspecteur();
		boolean[] inspectieMoment = inspecteur.bepaalBezoekMoment();
		int inspectieTeller = 0;
		while (bezoekKermis) {
			int bezoekAttractie;
			try {
				bezoekAttractie = this.startKermis();
			} catch (Exception e) {
				System.out.println("De ingevoerde waarde is ongeldig.");
				continue;
			}
			switch (bezoekAttractie) {
			case 0:
				bezoekKermis = false;
				break;
			case 1:
			case 2:
			case 3:
			case 4:
			case 5:
			case 6:

				kassa.setOmzet(kassa.getOmzet() + attracties.get(bezoekAttractie - 1).draaien());
				kassa.setVerkochteKaartjes(kassa.getVerkochteKaartjes() + 1);
				if (attracties.get(bezoekAttractie - 1) instanceof GokAttractie) {
					GokAttractie attractie = (GokAttractie) attracties.get(bezoekAttractie - 1);
					attractie.reserveerBelasting();
				}

				if (inspectieMoment[inspectieTeller]) {
					for(Attractie attractie : attracties) {
						if (attractie instanceof GokAttractie) {
							GokAttractie gok = (GokAttractie) attracties.get(bezoekAttractie - 1);
							System.out.println("De inspecteur heeft bij " + attractie.naam + " kansspelbelasting geint.");
							kassa.setTotaalAfgedragenBelasting(kassa.getTotaalAfgedragenBelasting() + gok.kansSpelBelastingBetalen());
							//ik verhoog nu dus het aantal bezoeken per attractie en niet per ronde
							//de inspecteur is bij meerdere attracties op bezoek geweest als er meer dan 1 gok attractie is.
							kassa.setAantalBelastingBezoeken(kassa.getAantalBelastingBezoeken()+1);
						}
					}
					

				}
				inspectieTeller++;
				if (inspectieTeller == 15) {
					inspectieMoment = inspecteur.bepaalBezoekMoment();
					inspectieTeller = 0;
				}
				break;
			case 20: // 20 is de waarde van k
				System.out.println("Het totaal aantalverkochte kaartjes is: " + kassa.getVerkochteKaartjes());
				break;
			case 24: // 24 is de waarde van o
				System.out.println("De totale kermis omzet is: " + kassa.getOmzet());
				System.out.println("Totaal betaalde kansspelbelasting: " + kassa.getTotaalAfgedragenBelasting());
				System.out.println("Totaal aantal bezoeken van inspecteur: " + kassa.getAantalBelastingBezoeken());
				break;

			}
		}
	}

	void initKermis() {
		System.out.println("In welke attractie wilt u?");
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
