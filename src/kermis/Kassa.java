package kermis;

 class Kassa {
	private double omzet;
	private int verkochteKaartjes = 0;
	private int aantalBelastingBezoeken = 0;
	private double totaalAfgedragenBelasting = 0;

	public double getOmzet() {
		return omzet;
	}

	public void setOmzet(double omzet) {
		this.omzet = omzet;
	}

	public int getVerkochteKaartjes() {
		return verkochteKaartjes;
	}

	public void setVerkochteKaartjes(int verkochteKaartjes) {
		this.verkochteKaartjes = verkochteKaartjes;
	}

	public int getAantalBelastingBezoeken() {
		return aantalBelastingBezoeken;
	}

	public void setAantalBelastingBezoeken(int aantalBelastingBezoeken) {
		this.aantalBelastingBezoeken = aantalBelastingBezoeken;
	}

	public double getTotaalAfgedragenBelasting() {
		return totaalAfgedragenBelasting;
	}

	public void setTotaalAfgedragenBelasting(double totaalAfgedragenBelasting) {
		this.totaalAfgedragenBelasting = totaalAfgedragenBelasting;
	}
	
	void printKassaOmzetInfo() {
		System.out.println("De totale kermis omzet is: " + this.getOmzet());
		System.out.println("===============");
//		for (Attractie attractie : attracties) {
//			System.out.println("Omzet van: " + attractie.naam + " is:" + attractie.omzet);
//		}
		System.out.println();
		System.out.println("Totaal betaalde kansspelbelasting: " + this.getTotaalAfgedragenBelasting());
		System.out.println("Totaal aantal bezoeken van inspecteur: " + this.getAantalBelastingBezoeken());
	}

}
