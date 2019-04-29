package kermis;

class Ladderklimmen extends Attractie implements GokAttractie{
	double kansSpelBelasting;
	double belastingSindsLaatsteAfdracht;
	
	
	Ladderklimmen() {
		this.naam = "Ladderklimmen";
		this.prijs = 5.00;
	}

	@Override
	double draaien() {
		this.omzet += this.prijs;
		this.belastingSindsLaatsteAfdracht+= this.prijs * 0.3;
		kansSpelBelastingBetalen();
		this.kaartjes++;
		System.out.println("De atrractie " + this.naam + " draait.");
		return this.prijs;
	}
		
	@Override
	public void kansSpelBelastingBetalen() {
		// TODO Auto-generated method stub
		//pas nodig in doelstelling 4
//		this.resetOmzetVoorAfdracht();
	}

	@Override
	public void resetOmzetVoorAfdracht() {
		this.belastingSindsLaatsteAfdracht = 0;
		
	}

}
