package kermis;

import java.util.Random;

public class BelastingInspecteur {

	private int inspectieTeller = 0;
	int inspectieMoment = this.bepaalInpectieMoment();

	int bepaalInpectieMoment() {
		Random random = new Random();
		int moment = random.nextInt(3);
		return moment;

	}

	boolean komtDeInspecteur() {
		boolean ikKom = false;
		if (inspectieTeller == inspectieMoment) {
			ikKom = true;
		} else {
			ikKom = false;
		}
		if (inspectieTeller < 3) {
			inspectieTeller++;
		} else {
			resetBezoekMoment();
		}
		return ikKom;
	}

	int resetBezoekMoment() {
		inspectieMoment = bepaalInpectieMoment();
		this.inspectieTeller = 0;
		return inspectieTeller;
	}

}
