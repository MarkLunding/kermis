package kermis;

public abstract class RisicoRijkeAttracties extends Attractie {
	abstract void opstellingsKeuring();

	void onderhoudsKeuring() {
		System.out.println("De onderhoudskeuring van atrractie " + this.naam + " is uitgevoerd.");
		this.onderhoudReset();
	}

	abstract void onderhoudReset();

}
