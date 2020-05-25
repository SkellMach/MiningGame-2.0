package cz.spsejecna.c2a.novak15;

import java.io.File;

import cz.spsejecna.c2a.novak15.*;
import cz.spsejecna.c2a.novak15.options.Cave;
import cz.spsejecna.c2a.novak15.options.Generating;
import cz.spsejecna.c2a.novak15.options.Home;
import cz.spsejecna.c2a.novak15.options.shop.SecretShop;
import cz.spsejecna.c2a.novak15.options.shop.Shop;
import cz.spsejecna.c2a.novak15.player.items.PlayerInventoryItem;
import cz.spsejecna.c2a.novak15.playerStuff.Boost;
import cz.spsejecna.c2a.novak15.playerStuff.Energy;
import cz.spsejecna.c2a.novak15.playerStuff.Inventory;
import cz.spsejecna.c2a.novak15.playerStuff.Player;
import cz.spsejecna.c2a.novak15.resources.*;
import cz.spsejecna.c2a.novak15.tutorial.DialogPart1;
import cz.spsejecna.c2a.novak15.tutorial.DialogPart2;
import cz.spsejecna.c2a.novak15.tutorial.Tutorial;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
///////////player statistic//////////////////////////
		SecretOptions secrets = new SecretOptions(false);
		Inventory inventory = new Inventory(0, 0, 0, 0, 0, 0, 0, 0);
		Player player = new Player(null, 0, 0, 0, 0, 0, 0, 0, 0);
		GameStats stats = new GameStats(1, 0, 0, 0, 0);
		Boost boost = new Boost(null, null, 0, 0, false);
		Energy energy = new Energy(100, 100);
		/// inventory items
		boolean[] fieldArray = new boolean[9];

		PlayerInventoryItem playerInventoryItems = new PlayerInventoryItem(fieldArray);
		//////////////////// ore chance//////////////////////
		/*
		 * Coal coal = new Coal("Coal", 60, 20, 5); // name, chance, gold from it,
		 * experience from it Iron iron = new Iron("Iron", 36, 36, 15); Kobalt kobalt =
		 * new Kobalt("Kobalt", 20, 54, 31); Magnetit magnetit = new
		 * Magnetit("Magnetit", 9, 100, 50); Gold gold = new Gold("Gold", 3, 500, 320);
		 * Emerald emerald = new Emerald("Emerald", -1, 1000, 520); Diamond diamond =
		 * new Diamond("Diamond", -2, 2500, 1000); Uran uran = new Uran("Uran", -3,
		 * 5000, 2500);
		 */
		////////////////////////////////////////////////////////

		File f1 = new File("Progress.txt");
		File f2 = new File("GameStats.txt");
		File f3 = new File("Secret.txt");
		if (f1.exists() == false || f2.exists() == false || f3.exists() == false) {

			// beginning
			try {
				String name = Tutorial.Tutorial();
				player.name = name;
				SavingProgress.NewFile();
				SavingProgress.Save(player, inventory, stats, boost, energy, secrets, playerInventoryItems);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		} else {
			try {
				SavingProgress.Load(player, inventory, stats, boost, energy, secrets, playerInventoryItems);
			} catch (MyException e) {
				System.out.println(e.getMessage());
			}
		}
		///////// game ////////////////////////

		while (true) {
			// day
			System.out.println("Day: " + stats.day);
			Generating.GenerateEssence(playerInventoryItems, player, stats);
			// boost
			if (boost.getHowLong() > 0) {
				boost.setHowLong(boost.getHowLong() - 1);
				if (boost.getHowLong() == 0) {
					System.out.println("You have no longer active boost");

				}
			}
			if (boost.getHowLong() == 0) {
				boost.setIsActivate(false);
				boost.setBoostName("nope");
				boost.setHowLong(0);
				boost.setWhatBoost("nope");
				boost.setHowMany(0);
				SavingProgress.Save(player, inventory, stats, boost, energy, secrets, playerInventoryItems);
			}
			if (boost.getHowLong() > 0) {
				boost.setIsActivate(true);
			}
			Thread.sleep(250);
			if (boost.isIsActivate() == true) {
				System.out.println(boost);
			}
			///////////////////////////////////////////
			// energy
			System.out.println(energy);
			Thread.sleep(250);
			/// essence

			if (stats.day == 100) {
				secrets.setSecretShop(true);
				DialogPart2.MysteriousSpeech();
			}
			int menu = DialogPart1.Menu(secrets);
			switch (menu) {
			case 1:
				if (energy.getEnergie() <= 0) {
					System.out.println("Not enough energy");
					break;
				}
				energy.setEnergie(energy.getEnergie() - 10);
				Cave.mine(player, inventory, stats, boost);
				break;

			case 2:
				Shop.shoppping(boost, player, energy);
				break;
			case 3:
				Home.sleep(energy);
				break;
			case 4:
				System.out.println(
						"-------------------------------------------------------------------------------------------------------------------------------------");
				System.out.println(player);
				System.out.println(
						"-------------------------------------------------------------------------------------------------------------------------------------");
				stats.day--;
				break;
			// secret shop [STILL IN ALPHA]!!!
			case 5:

				if (secrets.isSecretShop() == true) {
					SecretShop.shopping(boost, player, energy, inventory, playerInventoryItems);
				}
				break;
			case 0:
				System.out.println("*intensive nothing*");
				break;
			default:
				//stats.day--;
				System.out.println("*intensive nothing*");
				break;
			}

			stats.day += 1;
			SavingProgress.Save(player, inventory, stats, boost, energy, secrets, playerInventoryItems);
			//////// end of game //////////
		}
	}

}
