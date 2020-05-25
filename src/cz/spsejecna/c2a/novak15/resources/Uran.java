package cz.spsejecna.c2a.novak15.resources;

import java.util.Random;

import cz.spsejecna.c2a.novak15.GameStats;
import cz.spsejecna.c2a.novak15.MyException;
import cz.spsejecna.c2a.novak15.playerStuff.Boost;
import cz.spsejecna.c2a.novak15.playerStuff.Inventory;
import cz.spsejecna.c2a.novak15.playerStuff.Player;

public class Uran extends Resource {

	public Uran(String name, int chance, int gold, int xp) {
		super(name, chance, gold, xp);
		// TODO Auto-generated constructor stub
	}

	public static void getUran(Player player, Inventory inventory, GameStats stats, Unlucky unlucky, Boost boost)
			throws MyException {
		int saveGold = 0;
		int saveXp = 0;
		Uran uran = new Uran("Uran", -3, 5000, 2500);
		Random rng = new Random();
		int amount = 0;
		int multiply = 1 + player.getStrength(); // number of resources based on player strength
		for (int i = -1; i < player.getSpeed(); i++) { // number of cycles based on player speed
			int luck = rng.nextInt(100) + 1; // 1-100
			if (luck < uran.getChance() + 1 * player.getEfficiency()) {
				amount++;
			}
		}
		if (amount != 0) {
			if (boost.getWhatBoost().equals("Experience")) {
				saveXp = 1;
				player.setXp(player.getXp() + Math.round((uran.getXp() * amount) * (1 + boost.getHowMany() / 100)));
			} else {
				player.setXp(player.getXp() + (uran.getXp() * amount));
			}
			if (boost.getBoostName().equals("Money")) {
				saveGold = 1;
				player.setMoney(player.getMoney() + (uran.getCost() * amount));
			} else {
				player.setMoney(
						player.getMoney() + Math.round((uran.getCost() * amount) * (1 + boost.getHowMany() / 100)));
			}
			/// statistic
			stats.setNumberOfAllMinedResources(stats.getNumberOfAllMinedResources() + amount);
			stats.setNumberOfAllGatheredXP(stats.getNumberOfAllGatheredXP()
					+ (Math.round((uran.getXp() * amount) * (1 + saveXp * boost.getHowMany() / 100))));
			stats.setNumberOfAllGatheredMoney(stats.getNumberOfAllGatheredMoney()
					+ (Math.round((uran.getCost() * amount) * (1 + saveGold * boost.getHowMany() / 100))));
			// System.out.println
			System.out.println("You have gain " + amount + " uran, "
					+ (Math.round((uran.getXp() * amount) * (1 + saveXp * boost.getHowMany() / 100))) + " xp,  "
					+ (Math.round((uran.getCost() * amount) * (1 + saveGold * boost.getHowMany() / 100))) + " money");
		} else {
			unlucky.setUran(false);
		}

		inventory.setUran(amount * multiply);
	}
}
