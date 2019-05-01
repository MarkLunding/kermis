package kermis;

abstract class Attractie{
	String naam;
	double prijs;
	double oppervlakte;
	double omzet;
	int kaartjes = 0;
	
	double draaien() throws Exception {
		this.omzet += this.prijs;
		this.kaartjes++;
		System.out.println("De atrractie " + this.naam + " draait.");
		return this.prijs;
	}
}
