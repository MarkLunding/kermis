package kermis;

class Hawaii extends Attractie {
	Hawaii(){
		this.naam = "Hawaii";
	}
	
	@Override
	void draaien() {
		System.out.println("De attractie " + this.naam + " draait.");
	}

}
