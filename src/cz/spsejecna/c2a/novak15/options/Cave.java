package cz.spsejecna.c2a.novak15.options;

import cz.spsejecna.c2a.novak15.GameStats;
import cz.spsejecna.c2a.novak15.LevelingSystem;
import cz.spsejecna.c2a.novak15.MyException;
import cz.spsejecna.c2a.novak15.playerStuff.Boost;
import cz.spsejecna.c2a.novak15.playerStuff.Inventory;
import cz.spsejecna.c2a.novak15.playerStuff.Player;
import cz.spsejecna.c2a.novak15.resources.Coal;
import cz.spsejecna.c2a.novak15.resources.Diamond;
import cz.spsejecna.c2a.novak15.resources.Emerald;
import cz.spsejecna.c2a.novak15.resources.Gold;
import cz.spsejecna.c2a.novak15.resources.Iron;
import cz.spsejecna.c2a.novak15.resources.Kobalt;
import cz.spsejecna.c2a.novak15.resources.Magnetit;
import cz.spsejecna.c2a.novak15.resources.Unlucky;
import cz.spsejecna.c2a.novak15.resources.Uran;

public class Cave {

	public static void mine(Player player, Inventory inventory, GameStats stats, Boost boost)
			throws InterruptedException {
		try {
			Unlucky unlucky = new Unlucky(true, true, true, true, true, true, true, true);
			Coal.getCoal(player, inventory, stats, unlucky, boost);
			Thread.sleep(200);
			Iron.getIron(player, inventory, stats, unlucky, boost);
			Thread.sleep(200);
			Kobalt.getKobalt(player, inventory, stats, unlucky, boost);
			Thread.sleep(200);
			Magnetit.getMagnetit(player, inventory, stats, unlucky, boost);
			Thread.sleep(200);
			Gold.getGold(player, inventory, stats, unlucky, boost);
			Thread.sleep(200);
			Emerald.getEmerald(player, inventory, stats, unlucky, boost);
			Thread.sleep(200);
			Diamond.getDiamond(player, inventory, stats, unlucky, boost);
			Thread.sleep(200);
			Uran.getUran(player, inventory, stats, unlucky, boost);
			Thread.sleep(200);
			System.out.println(unlucky);
			//////////// lvl up system
			LevelingSystem.LevelUp(player);

		} catch (MyException e) {
			System.out.println(e.getMessage());
		}
	}

}

