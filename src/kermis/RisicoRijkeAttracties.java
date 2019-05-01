package kermis;

public abstract class RisicoRijkeAttracties extends Attractie  {
	abstract void opstellingsKeuring();

	abstract void onderhoudsKeuring() ;

	abstract void onderhoudReset();
	
	abstract boolean isOnderhoudNodig();

}
