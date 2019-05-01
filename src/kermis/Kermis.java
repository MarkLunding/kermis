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
				// draai de attractie en controleer of onderhoud exceptie optreedt
				try {
					kassa.setOmzet(kassa.getOmzet() + attracties.get(bezoekAttractie - 1).draaien());
				} catch (Exception e) {
					System.out.println(
							"Deze attractie heeft onderhoud nodig. Dit moet de bediener activeren met de optie m");
					continue;
				}
				this.verhoogKaartjes();
				this.reserveerKansspelBelasting(bezoekAttractie);

				// kansspelbelasting betalen indien het moment er is (inspectitemoment)
				// maar natuurlijk alleen voor de attracties die als gokken bekend zijn.
				if (inspectieMoment[inspectieTeller]) {
					int welkeAttractie = 0;
					for (Attractie attractie : attracties) {
						if (attractie instanceof GokAttractie) {
							this.belastingInnen(welkeAttractie, attractie.naam);
						}
						welkeAttractie++;
					}
					kassa.setAantalBelastingBezoeken(kassa.getAantalBelastingBezoeken() + 1);

				}

				inspectieTeller++;
				if (inspectieTeller == 15) {
					inspectieMoment = inspecteur.bepaalBezoekMoment();
					inspectieTeller = 0;
				}
				break;
			case 20: // 20 is de waarde van k
				this.printKaartjeInfo();
				break;
			case 22: // 22 is de waarde van m
				this.onderhoud();
				break;
			case 24: // 24 is de waarde van o
				this.printOmzetInfo();
				break;

			}
		}
	}

	void initKermis() {
		System.out.println("In welke attractie wilt u?");
		System.out.println();
		System.out.print("1: Botsauto's | 2: Spin | 3: Spiegelpaleis | 4: Spookhuis | 5: Hawaii | 6: Ladderklimmen");
		System.out.println();
		System.out.println("0: Stoppen | o: omzet | k: kaartjes | m: monteur");
	}

	int startKermis() throws Exception {
		Scanner sc = new Scanner(System.in);
		String attractieInvoer = sc.nextLine();
		int eersteLetter = Character.getNumericValue(attractieInvoer.charAt(0));

		if (eersteLetter > 6) {
			char letterInvoer = attractieInvoer.charAt(0);
			if (letterInvoer != 'o' && letterInvoer != 'k' && letterInvoer != 'm') {
				throw new Exception();
			}
		}
		return eersteLetter;
	}

	void verhoogKaartjes() {
		kassa.setVerkochteKaartjes(kassa.getVerkochteKaartjes() + 1);

	}

	void reserveerKansspelBelasting(int attractieNr) {
		if (attracties.get(attractieNr - 1) instanceof GokAttractie) {
			GokAttractie attractie = (GokAttractie) attracties.get(attractieNr - 1);
			attractie.reserveerBelasting();
		}
	}

	void belastingInnen(int attractieNr, String attractienaam) {
		GokAttractie gok = (GokAttractie) attracties.get(attractieNr);
		System.out.println("De inspecteur heeft bij " + attractienaam + " kansspelbelasting geint.");
		kassa.setTotaalAfgedragenBelasting(kassa.getTotaalAfgedragenBelasting() + gok.kansSpelBelastingBetalen());
	}

	void printKaartjeInfo() {
		System.out.println("Het totaal aantalverkochte kaartjes is: " + kassa.getVerkochteKaartjes());
		System.out.println("===============");
		for (Attractie attractie : attracties) {
			System.out.println("Verkochte kaartje van: " + attractie.naam + " is:" + attractie.kaartjes);
		}
	}

	void onderhoud() {

		for (Attractie attractie : attracties) {
			if (attractie instanceof RisicoRijkeAttracties) {

				if (((RisicoRijkeAttracties) attractie).isOnderhoudNodig()) {
					((RisicoRijkeAttracties) attractie).onderhoudsKeuring();
				}
			}
		}
	}

	void printOmzetInfo() {
		System.out.println("De totale kermis omzet is: " + kassa.getOmzet());
		System.out.println("===============");
		for (Attractie attractie : attracties) {
			System.out.println("Omzet van: " + attractie.naam + " is:" + attractie.omzet);
		}
		System.out.println();
		System.out.println("Totaal betaalde kansspelbelasting: " + kassa.getTotaalAfgedragenBelasting());
		System.out.println("Totaal aantal bezoeken van inspecteur: " + kassa.getAantalBelastingBezoeken());
	}

}
