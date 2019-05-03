package kermis;

 class Kassa {
	private double omzet;
	private int verkochteKaartjes = 0;
	private int aantalBelastingBezoeken = 0;
	private double totaalAfgedragen = 0;

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

	public double getTotaalAfgedragen() {
		return totaalAfgedragen;
	}

	public void setTotaalAfgedragen(double totaalAfgedragen) {
		this.totaalAfgedragen = totaalAfgedragen;
	}
	
	void printKassaOmzetInfo() {
		System.out.println("De totale kermis omzet is: " + this.getOmzet());
		System.out.println("===============");
		System.out.println();
		System.out.println("Totaal betaalde kansspelbelasting: " + this.getTotaalAfgedragen());
		System.out.println("Totaal aantal bezoeken van inspecteur: " + this.getAantalBelastingBezoeken());
	}

}
