package kermis;

class Spiegelpaleis extends Attractie {
	Spiegelpaleis(){
		this.naam = "Spiegelpaleis";
	}
	
	@Override
	void draaien() {
		System.out.println("Het " + this.naam + " draait.");
	}

}
