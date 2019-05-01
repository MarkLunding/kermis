package kermis;

class Ladderklimmen extends Attractie implements GokAttractie{
	private double belastingSindsLaatsteAfdracht;
	private double belastingBedrag ;
	
	Ladderklimmen() {
		this.naam = "Ladderklimmen";
		this.prijs = 5.00;
		this.belastingBedrag = this.prijs * belastingtarief;
	}
	
	@Override
	public void reserveerBelasting() {
		this.omzet-= this.belastingBedrag;
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

}
