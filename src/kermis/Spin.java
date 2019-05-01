package kermis;

class Spin extends RisicoRijkeAttracties implements GokAttractie {
	private int onderhoudsTeller = 5;
	private double belastingSindsLaatsteAfdracht;
	private double belastingBedrag;

	Spin() {
		this.naam = "Spin";
		this.prijs = 2.25;
		opstellingsKeuring();
		this.belastingBedrag = this.prijs * belastingtarief;
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
		this.onderhoudsTeller = 5;

	}

	@Override
	public void reserveerBelasting() {
		this.omzet -= this.belastingBedrag;
		this.setBelastingSindsLaatsteAfdracht(this.getBelastingSindsLaatsteAfdracht() + this.belastingBedrag);
	}

	@Override
	public double kansSpelBelastingBetalen() {
		double teBelaten = this.getBelastingSindsLaatsteAfdracht();
		this.setBelastingSindsLaatsteAfdracht(0.0);
		return teBelaten;
	}

	public double getBelastingSindsLaatsteAfdracht() {
		return belastingSindsLaatsteAfdracht;
	}

	public void setBelastingSindsLaatsteAfdracht(double belastingSindsLaatsteAfdracht) {
		this.belastingSindsLaatsteAfdracht = belastingSindsLaatsteAfdracht;
	}

	@Override
	boolean isOnderhoudNodig() {
		boolean onderhoudNodig = false;
		if (this.onderhoudsTeller < 1) { //kleiner dan 1, omdat je ook onder 0 komt komen als je niet meteen onderhoud kiest.
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
