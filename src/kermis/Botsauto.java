package kermis;

class Botsauto extends Attractie {
	Botsauto(){
		this.naam = "Botsauto's";
	}
	
	@Override
	void draaien() {
		System.out.println("De atrractie " + this.naam + " draait.");
	}

}
