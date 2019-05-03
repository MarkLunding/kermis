package kermis;

import java.util.ArrayList;
import java.util.Scanner;

class Kermis {
	ArrayList<Attractie> attracties = new ArrayList<>();
	Kassa kassa = new Kassa();
	BelastingInspecteur inspecteur = new BelastingInspecteur();
	boolean kermisBezoek = true;
	int welkeAttractie;

	Kermis() {
		this.attracties.add(new Botsauto());
		this.attracties.add(new Spin());
		this.attracties.add(new Spiegelpaleis());
		this.attracties.add(new Spookhuis());
		this.attracties.add(new Hawaii());
		this.attracties.add(new Ladderklimmen());
	}

	void bezoekKermis() {
		while (kermisBezoek) {
			try {
				welkeAttractie = this.watGaanWeDoen();
			} catch (Exception e) {
				System.out.println("De ingevoerde waarde is ongeldig.");
				continue;
			}
			switch (welkeAttractie) {
			case 0:
				kermisBezoek = false;
				break;
			case 1: case 2:	case 3:	case 4: case 5: case 6:
				try {
					kassa.setOmzet(kassa.getOmzet() + attracties.get(welkeAttractie - 1).draaien());
				} catch (Exception e) {
					System.out.println(
							"Deze attractie heeft onderhoud nodig. Dit moet de bediener activeren met de optie m");
					continue;
				}
				attractieBezoekAfhandeling(welkeAttractie);
				break;
			case 20: // 20 is de waarde van k
				printKaartjeInfo();
				break;
			case 22: // 22 is de waarde van m
				onderhoud();
				break;
			case 24: // 24 is de waarde van o
				kassa.printKassaOmzetInfo();
				for (Attractie attractie : attracties) {
					attractie.printAttractieOmzetInfo();
				}
				break;

			}
		}
	}

	void initieer() {
		System.out.println("Welkom op de kermis.");
		System.out.println();
	}

	void attractieVraag() {
		System.out.println("In welke attractie wilt u?");
		System.out.println();
		System.out.print("1: Botsauto's | 2: Spin | 3: Spiegelpaleis | 4: Spookhuis | 5: Hawaii | 6: Ladderklimmen");
		System.out.println();
		System.out.println("0: Stoppen | o: omzet | k: kaartjes | m: monteur");
	}

	int watGaanWeDoen() throws Exception {
		attractieVraag();
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

	void attractieBezoekAfhandeling(int attractieNr) {
		//verkochte kaartjes verwerken
		kassa.setVerkochteKaartjes(kassa.getVerkochteKaartjes() + 1);
		
		//Reserveer kansspelbelasting
		if (attracties.get(attractieNr - 1) instanceof GokAttractie) {
			GokAttractie attractie = (GokAttractie) attracties.get(attractieNr - 1);
			attractie.reserveerBelasting();
		}

		//is inspectie nodig?
		if (inspecteur.komtDeInspecteur()) {
			int welkeAttractie = 0;
			for (Attractie attractie : attracties) {
				if (attractie instanceof GokAttractie) {
					this.belastingInnen(welkeAttractie, attractie.naam);
				}
				welkeAttractie++;
			}
			kassa.setAantalBelastingBezoeken(kassa.getAantalBelastingBezoeken() + 1);

		}
	}

	void belastingInnen(int attractieNr, String attractienaam) {
		GokAttractie gok = (GokAttractie) attracties.get(attractieNr);
		System.out.println("De inspecteur heeft bij " + attractienaam + " kansspelbelasting geint.");
		kassa.setTotaalAfgedragen(kassa.getTotaalAfgedragen() + gok.kansSpelBelastingBetalen());
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
				RisicoRijkeAttracties risicoAttractie = (RisicoRijkeAttracties) attractie;
				if (risicoAttractie.isOnderhoudNodig()) {
					risicoAttractie.onderhoudsKeuring();
				}
			}
		}
	}

}
