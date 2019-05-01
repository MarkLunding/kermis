package kermis;

class Spin extends RisicoRijkeAttracties implements GokAttractie {
	int onderhoudsTeller = 5;
	private double kansSpelBelasting;
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

	public double getKansSpelBelasting() {
		return kansSpelBelasting;
	}

	public void setKansSpelBelasting(double kansSpelBelasting) {
		this.kansSpelBelasting = kansSpelBelasting;
	}

	public double getBelastingSindsLaatsteAfdracht() {
		return belastingSindsLaatsteAfdracht;
	}

	public void setBelastingSindsLaatsteAfdracht(double belastingSindsLaatsteAfdracht) {
		this.belastingSindsLaatsteAfdracht = belastingSindsLaatsteAfdracht;
	}

}
