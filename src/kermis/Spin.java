package kermis;

class Spin extends Attractie {
	Spin(){
		this.naam = "Spin";
	}
	
	@Override
	void draaien() {
		System.out.println("De " + this.naam + " draait.");
	}

}
