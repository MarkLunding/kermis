package kermis;

class Hawaii extends RisicoRijkeAttracties {
	int onderhoudsTeller = 10;
	
	Hawaii() {
		this.naam = "Hawaii";
		this.prijs = 2.90;
		opstellingsKeuring();
	}
	
	@Override
	void opstellingsKeuring() {
		System.out.println("De opstelling van atrractie " + this.naam + " is goedgekeurd.");
		
	}
	
	@Override
	double draaien() throws Exception{
		if (--this.onderhoudsTeller < 1) {
			throw new Exception(this.naam);
		}
		this.omzet += this.prijs;
		this.kaartjes++;
		System.out.println("De atrractie " + this.naam + " draait.");
		
		return this.prijs;
	}

	@Override
	void onderhoudReset() {
		this.onderhoudsTeller = 10;
		
	}
	
	@Override
	boolean isOnderhoudNodig() {
		boolean onderhoudNodig = false;
		if (this.onderhoudsTeller == 0) {
			onderhoudNodig = true;
		}
		return onderhoudNodig;
	}

	@Override
	void onderhoudsKeuring() {
		System.out.println("De onderhoudskeuring van atrractie " + this.naam + " is uitgevoerd.");
		this.onderhoudReset();
	}
	
	
}
