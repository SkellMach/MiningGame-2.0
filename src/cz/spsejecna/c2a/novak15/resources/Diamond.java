package cz.spsejecna.c2a.novak15.resources;

import java.util.Random;

import cz.spsejecna.c2a.novak15.GameStats;
import cz.spsejecna.c2a.novak15.MyException;
import cz.spsejecna.c2a.novak15.playerStuff.Boost;
import cz.spsejecna.c2a.novak15.playerStuff.Inventory;
import cz.spsejecna.c2a.novak15.playerStuff.Player;

public class Diamond extends Resource {

	public Diamond(String name, int chance, int gold, int xp) {
		super(name, chance, gold, xp);
		// TODO Auto-generated constructor stub
	}

	public static void getDiamond(Player player, Inventory inventory, GameStats stats, Unlucky unlucky, Boost boost)
			throws MyException {
		int saveXp = 0;
		int saveGold = 0;
		Diamond diamond = new Diamond("Diamond", -2, 2500, 1000);
		Random rng = new Random();
		int amount = 0;
		int multiply = 1 + player.getStrength(); // number of resources based on player strength
		for (int i = -1; i < player.getSpeed(); i++) { // number of cycles based on player speed
			int luck = rng.nextInt(100) + 1; // 1-100
			if (luck < diamond.getChance() + 1 * player.getEfficiency()) { // for example, if we had chance 17% to get
																			// //resource, we have 17/100 to get it, so
																			// if luck is smaller than chance (16 for
																			// example),them we will get the resource

				amount++;
			}
		}
		if (amount != 0) {
			if (boost.getWhatBoost().equals("Experience")) {
				saveXp = 1;
				player.setXp(player.getXp() + Math.round((diamond.getXp() * amount) * (1 + boost.getHowMany() / 100)));
			} else {
				player.setXp(player.getXp() + (diamond.getXp() * amount));
			}
			if (boost.getBoostName().equals("Money")) {
				saveGold = 1;
				player.setMoney(player.getMoney() + (diamond.getCost() * amount));
			} else {
				player.setMoney(
						player.getMoney() + Math.round((diamond.getCost() * amount) * (1 + boost.getHowMany() / 100)));
			}

			stats.setNumberOfAllMinedResources(stats.getNumberOfAllMinedResources() + amount);
			stats.setNumberOfAllGatheredXP(stats.getNumberOfAllGatheredXP()
					+ (Math.round((diamond.getXp() * amount) * (1 + saveXp * boost.getHowMany() / 100))));
			stats.setNumberOfAllGatheredMoney(stats.getNumberOfAllGatheredMoney()
					+ (Math.round((diamond.getCost() * amount) * (1 + saveGold * boost.getHowMany() / 100))));

			System.out.println("You have gain " + amount + " diamond, "
					+ (Math.round((diamond.getXp() * amount) * (1 + saveXp * boost.getHowMany() / 100))) + " xp,  "
					+ (Math.round((diamond.getCost() * amount) * (1 + saveGold * boost.getHowMany() / 100)))
					+ " money");
		} else {
			unlucky.setDiamond(false);
		}

		inventory.setDiamond(amount * multiply);

	}

}
