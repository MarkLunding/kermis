package kermis;

class Spin extends RisicoRijkeAttracties {
	int onderhoudsTeller = 5;

	Spin() {
		this.naam = "Spin";
		this.prijs = 2.25;
		opstellingsKeuring();
	}

	@Override
	void opstellingsKeuring() {
		System.out.println("De opstelling van atrractie " + this.naam + " is goedgekeurd.");

	}

	@Override
	double draaien() {
		this.omzet += this.prijs;
		this.kaartjes++;
		System.out.println("De atrractie " + this.naam + " draait.");
		if (--this.onderhoudsTeller < 1) {
			onderhoudsKeuring();
		}
		return this.prijs;
	}
	
	@Override
	void onderhoudReset() {
		this.onderhoudsTeller = 5;
		
	}

}
