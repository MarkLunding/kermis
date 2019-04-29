package kermis;

class Ladderklimmen extends Attractie {
	Ladderklimmen(){
		this.naam = "Ladderklimmen";
	}
	
	@Override
	void draaien() {
		System.out.println("De attractie " + this.naam + " draait.");
	}

}
