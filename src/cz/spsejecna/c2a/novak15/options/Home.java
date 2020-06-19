package cz.spsejecna.c2a.novak15.options;

import cz.spsejecna.c2a.novak15.playerStuff.Energy;

public class Home {

	public static void sleep(Energy energy) throws InterruptedException {
		Thread.sleep(250);
		System.out.println("ZzZzZz....");
		Thread.sleep(500);

		if (energy.getEnergie() >= energy.getMaxEnergie()) {
			// energy.setEnergie(energy.getMaxEnergie());
			System.out.println("You already have max energy");
			//Opravení gramatické chyby
		} else {
			System.out.println("You gain: " + energy.getMaxEnergie() / 4 + " energy");
		}
		energy.setEnergie(energy.getEnergie() + energy.getMaxEnergie() / 4);
	}
}
