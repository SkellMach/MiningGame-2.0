package cz.spsejecna.c2a.novak15.options.shop;

import java.util.Scanner;

import cz.spsejecna.c2a.novak15.MyException;
import cz.spsejecna.c2a.novak15.player.items.Items;
import cz.spsejecna.c2a.novak15.player.items.PlayerInventoryItem;
import cz.spsejecna.c2a.novak15.playerStuff.Boost;
import cz.spsejecna.c2a.novak15.playerStuff.Energy;
import cz.spsejecna.c2a.novak15.playerStuff.Inventory;
import cz.spsejecna.c2a.novak15.playerStuff.Player;

public class SecretShop {

	public static void shopping(Boost boost, Player player, Energy energy, Inventory inventory,
			PlayerInventoryItem playerInventoryItems) throws InterruptedException {
		int option = 0;// helping variable
		int choose = 0;// helping variable
		Scanner sc = new Scanner(System.in);

		System.out.println("Hey... you finally arrived");
		Thread.sleep(250);
		System.out.println("welcome to secret shop ");
		Thread.sleep(250);
		System.out.println("some items are maybe illegal so, yeah...");
		Thread.sleep(250);
		System.out.println("don't talk about them");
		//mala uprava
		Thread.sleep(250);
		/////////////////////// shop menu IN ALPHA!!!!
		System.out.println("Shop menu:");
		Thread.sleep(250);
		System.out.println("1... Ring ");
		Thread.sleep(100);
		System.out.println("2... Amulet ");
		Thread.sleep(100);
		System.out.println("3... Talisman");
		Thread.sleep(100);
		System.out.println("4... Bracelet");
		Thread.sleep(100);
		System.out.println("5... Glove");
		Thread.sleep(100);
		System.out.println("6... Necklace");
		Thread.sleep(100);
		System.out.println("7... Crown");
		Thread.sleep(100);
		System.out.println("8... Shoulders");
		Thread.sleep(100);
		System.out.println("9... Boots");
		Thread.sleep(200);
		System.out.println("0...  Leave shop");
		/////////////////////// shop menu
		do {
			sc = new Scanner(System.in);
			System.out.println("Current money: " + player.getMoney()+ " $");
			try {
				option = sc.nextInt();
				switch (option) {
				case 1:
					if (playerInventoryItems.getIndex(0) == true) {
						System.out.println("You already have this item!!!");
					} else {
						Items item = new Items("Ring", "Essence", 3, 50000);
						Item(0, playerInventoryItems, item, player);
					}
					break;
				case 2:
					if (playerInventoryItems.getIndex(1) == true) {
						System.out.println("You already have this item!!!");
					} else {
						Items item = new Items("Amulet", "Essence", 5, 150000);
						Item(1, playerInventoryItems, item, player);
					}
					break;
				case 3:
					if (playerInventoryItems.getIndex(2) == true) {
						System.out.println("You already have this item!!!");
					} else {
						Items item = new Items("Talisman", "Essence", 4, 88000);
						Item(2, playerInventoryItems, item, player);
					}
					break;
				case 4:
					if (playerInventoryItems.getIndex(3) == true) {
						System.out.println("You already have this item!!!");
					} else {
						Items item = new Items("Bracelet", "Essence", 1, 25000);
						Item(3, playerInventoryItems, item, player);
					}
					break;
				case 5:
					if (playerInventoryItems.getIndex(4) == true) {
						System.out.println("You already have this item!!!");
					} else {
						Items item = new Items("Glove", "Essence", 3, 75000);
						Item(4, playerInventoryItems, item, player);
					}
					break;
				case 6:
					if (playerInventoryItems.getIndex(5) == true) {
						System.out.println("You already have this item!!!");
					} else {
						Items item = new Items("Necklace", "Essence", 8, 250000);
						Item(5, playerInventoryItems, item, player);
					}
					break;
				case 7:
					if (playerInventoryItems.getIndex(6) == true) {
						System.out.println("You already have this item!!!");
					} else {
						Items item = new Items("Crown", "Essence", 25, 1500000);
						Item(6, playerInventoryItems, item, player);
					}
					break;
				case 8:
					if (playerInventoryItems.getIndex(7) == true) {
						System.out.println("You already have this item!!!");
					} else {
						Items item = new Items("Shoulders", "Essence", 12, 375000);
						Item(7, playerInventoryItems, item, player);
					}
					break;
				case 9:
					if (playerInventoryItems.getIndex(8) == true) {
						System.out.println("You already have this item!!!");
					} else {
						Items item = new Items("Boots", "Essence", 6, 98000);
						Item(8, playerInventoryItems, item, player);
					}
					break;
				case 0:
					break;
				default:
					throw new MyException("Wrong number, write 0 - 9 ");
				}

			} catch (MyException e) {
				System.out.println(e.getLocalizedMessage());
			} catch (Exception err) {
				System.err.println("Write number!!!");
				option = -1;
			}
		} while (option != 0);

	}

	public static void Item(int x, PlayerInventoryItem array, Items item, Player player) {

		Scanner sc = new Scanner(System.in);
		int choose = 0;
		try {

			System.out.println(item);
			System.out.println("Cost: " + item.getCost());
			Thread.sleep(100);
			System.out.println("Do you wanna buy it?");
			Thread.sleep(100);
			System.out.println("1... Yes");
			System.out.println("0... No");
			choose = sc.nextInt();
			if (choose != 1 && choose != 0) {

				throw new MyException("Wrong number, write 0 or 1 ");
			}
			if (choose == 1) {
				if (player.getMoney() >= item.getCost()) {
					System.out.println("You bought " + item.getName());
					array.setIndex(x, true);

					player.setMoney(player.getMoney() - item.getCost());

				} else {
					System.out.println("Not enough gold");
				}
			}
			if (choose == 0) {
				return;
			}

		} catch (MyException e) {
			System.out.println(e.getLocalizedMessage());

		} catch (Exception err) {
			sc = new Scanner(System.in);
			System.err.println("Error");

		}
	}
}

