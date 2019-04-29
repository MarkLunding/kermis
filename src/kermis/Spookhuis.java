package kermis;

class Spookhuis extends Attractie {
	Spookhuis(){
		this.naam = "Spookhuis";
	}
	
	@Override
	void draaien() {
		System.out.println("Het " + this.naam + " draait.");
	}

}
