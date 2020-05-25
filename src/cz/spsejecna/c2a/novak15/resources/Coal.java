package cz.spsejecna.c2a.novak15.resources;

import java.util.Random;

import cz.spsejecna.c2a.novak15.*;
import cz.spsejecna.c2a.novak15.playerStuff.Boost;
import cz.spsejecna.c2a.novak15.playerStuff.Inventory;
import cz.spsejecna.c2a.novak15.playerStuff.Player;

public class Coal extends Resource {

	public Coal(String name, int chance, int gold, int xp) {
		super(name, chance, gold, xp);
	}

	public static void getCoal(Player player, Inventory inventory, GameStats stats, Unlucky unlucky, Boost boost)
			throws MyException {
		int saveXp = 0;
		int saveGold = 0;
		Coal coal = new Coal("Coal", 60, 20, 5);
		Random rng = new Random();
		int amount = 0;
		int multiply = 1 + player.getStrength(); // number of resources based on player strength
		for (int i = -1; i < player.getSpeed(); i++) { // number of cycles based on player speed
			int luck = rng.nextInt(100) + 1; // 1-100
			if (luck < coal.getChance() + 8 * player.getEfficiency()) {
				amount++;

			}
		}

		if (amount != 0) {
			// player

			if (boost.getWhatBoost().equals("Experience")) {
				saveXp = 1;
				player.setXp(player.getXp() + Math.round((coal.getXp() * amount) * (1 + boost.getHowMany() / 100)));
			} else {
				player.setXp(player.getXp() + (coal.getXp() * amount));
			}
			if (boost.getBoostName().equals("Money")) {
				saveGold = 1;
				player.setMoney(player.getMoney() + (coal.getCost() * amount));
			} else {
				player.setMoney(
						player.getMoney() + Math.round((coal.getCost() * amount) * (1 + boost.getHowMany() / 100)));
			}
			/// statistic
			stats.setNumberOfAllMinedResources(stats.getNumberOfAllMinedResources() + amount);
			stats.setNumberOfAllGatheredXP(stats.getNumberOfAllGatheredXP()
					+ (Math.round((coal.getXp() * amount) * (1 + saveXp * boost.getHowMany() / 100))));
			stats.setNumberOfAllGatheredMoney(stats.getNumberOfAllGatheredMoney()
					+ (Math.round((coal.getCost() * amount) * (1 + saveGold * boost.getHowMany() / 100))));
			// System.out.println
			System.out.println("You have gain " + amount + " coal, "
					+ (Math.round((coal.getXp() * amount) * (1 + saveXp * boost.getHowMany() / 100))) + " xp,  "
					+ (Math.round((coal.getCost() * amount) * (1 + saveGold * boost.getHowMany() / 100))) + " money");

		} else {
			unlucky.setCoal(false);
		}

		inventory.setCoal(amount * multiply);

	}

}
