package kermis;

import java.util.Random;

class belastingInspecteur {

	boolean []bepaalBezoekMoment() {
		Random random = new Random();
		int moment = random.nextInt(15);
		boolean [] bezoekMoment = new boolean[15];
		for (int i = 0; i < bezoekMoment.length; i++) {
			if (moment != i) {
				bezoekMoment[i] = false;
			} else {
				bezoekMoment[i] = true;
			}
		}
		return bezoekMoment;
		
	}
}
