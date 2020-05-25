package cz.spsejecna.c2a.novak15.resources;

import java.util.Random;

import cz.spsejecna.c2a.novak15.GameStats;
import cz.spsejecna.c2a.novak15.MyException;
import cz.spsejecna.c2a.novak15.playerStuff.Boost;
import cz.spsejecna.c2a.novak15.playerStuff.Inventory;
import cz.spsejecna.c2a.novak15.playerStuff.Player;

public class Kobalt extends Resource {

	public Kobalt(String name, int chance, int gold, int xp) {
		super(name, chance, gold, xp);
		// TODO Auto-generated constructor stub
	}

	public static void getKobalt(Player player, Inventory inventory, GameStats stats, Unlucky unlucky, Boost boost)
			throws MyException {
		int saveXp = 0;
		int saveGold = 0;
		Kobalt kobalt = new Kobalt("Kobalt", 20, 54, 31);
		Random rng = new Random();
		int amount = 0;
		int multiply = 1 + player.getStrength(); // number of resources based on player strength
		for (int i = -1; i < player.getSpeed(); i++) { // number of cycles based on player speed
			int luck = rng.nextInt(100) + 1; // 1-100
			if (luck < kobalt.getChance() + 5 * player.getEfficiency()) {
				amount++;
			}
		}
		inventory.setKobalt(amount * multiply);
		if (amount != 0) {
			if (boost.getWhatBoost().equals("Experience")) {
				saveXp = 0;
				player.setXp(player.getXp() + Math.round((kobalt.getXp() * amount) * (1 + boost.getHowMany() / 100)));
			} else {
				player.setXp(player.getXp() + (kobalt.getXp() * amount));
			}
			if (boost.getBoostName().equals("Money")) {
				saveGold = 1;
				player.setMoney(player.getMoney() + (kobalt.getCost() * amount));
			} else {
				player.setMoney(
						player.getMoney() + Math.round((kobalt.getCost() * amount) * (1 + boost.getHowMany() / 100)));
			}
			/// statistic
			stats.setNumberOfAllMinedResources(stats.getNumberOfAllMinedResources() + amount);
			stats.setNumberOfAllGatheredXP(stats.getNumberOfAllGatheredXP()
					+ (Math.round((kobalt.getXp() * amount) * (1 + saveXp * boost.getHowMany() / 100))));
			stats.setNumberOfAllGatheredMoney(stats.getNumberOfAllGatheredMoney()
					+ (Math.round((kobalt.getCost() * amount) * (1 + saveGold * boost.getHowMany() / 100))));
			// System.out.println
			System.out.println("You have gain " + amount + " kobalt, "
					+ (Math.round((kobalt.getXp() * amount) * (1 + saveXp * boost.getHowMany() / 100))) + " xp,  "
					+ (Math.round((kobalt.getCost() * amount) * (1 + saveGold * boost.getHowMany() / 100))) + " money");
		} else {
			unlucky.setKobalt(false);
		}

	}

}