package cz.spsejecna.c2a.novak15.options.shop;

import cz.spsejecna.c2a.novak15.player.items.PlayerInventoryItem;
import cz.spsejecna.c2a.novak15.playerStuff.Boost;
import cz.spsejecna.c2a.novak15.playerStuff.Energy;
import cz.spsejecna.c2a.novak15.playerStuff.Inventory;
import cz.spsejecna.c2a.novak15.playerStuff.Player;

public class MagicShop {
	public static void shopping(Boost boost, Player player, Energy energy, Inventory inventory,
			PlayerInventoryItem playerInventoryItems) throws InterruptedException {
		System.out.println("Hey... you finally arrived");
		Thread.sleep(250);
		System.out.println("welcome to magic shop ");
		Thread.sleep(250);
		System.out.println("some scrolls are maybe out of your skill league to use, but you can still buy them for later...");
		Thread.sleep(250);
		System.out.println("Shop menu:");
		Thread.sleep(250);
		System.out.println("1... Fireball ");
		Thread.sleep(100);
		System.out.println("2... Frostbolt ");
		Thread.sleep(100);
		System.out.println("3... Blizzard");
		Thread.sleep(100);
		System.out.println("4... Pyroblast");
		Thread.sleep(100);
		System.out.println("5... Yellow Spike");
		Thread.sleep(100);
		System.out.println("6... Black Hole");
		Thread.sleep(100);
		System.out.println("7... Black Spike");
		Thread.sleep(100);
		System.out.println("8... Polymorph");
		Thread.sleep(100);
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
						Items item = new Items("Fireball", "Essence", 3, 50000);
						Item(0, playerInventoryItems, item, player);
					}
					break;
				case 2:
					if (playerInventoryItems.getIndex(1) == true) {
						System.out.println("You already have this item!!!");
					} else {
						Items item = new Items("Frostbolt", "Essence", 5, 150000);
						Item(1, playerInventoryItems, item, player);
					}
					break;
				case 3:
					if (playerInventoryItems.getIndex(2) == true) {
						System.out.println("You already have this item!!!");
					} else {
						Items item = new Items("Blizzard", "Essence", 4, 88000);
						Item(2, playerInventoryItems, item, player);
					}
					break;
				case 4:
					if (playerInventoryItems.getIndex(3) == true) {
						System.out.println("You already have this item!!!");
					} else {
						Items item = new Items("Pyroblast", "Essence", 1, 25000);
						Item(3, playerInventoryItems, item, player);
					}
					break;
				case 5:
					if (playerInventoryItems.getIndex(4) == true) {
						System.out.println("You already have this item!!!");
					} else {
						Items item = new Items("Yellow Spike", "Essence", 3, 75000);
						Item(4, playerInventoryItems, item, player);
					}
					break;
				case 6:
					if (playerInventoryItems.getIndex(5) == true) {
						System.out.println("You already have this item!!!");
					} else {
						Items item = new Items("Black Hole", "Essence", 8, 250000);
						Item(5, playerInventoryItems, item, player);
					}
					break;
				case 7:
					if (playerInventoryItems.getIndex(6) == true) {
						System.out.println("You already have this item!!!");
					} else {
						Items item = new Items("Black Spike", "Essence", 25, 1500000);
						Item(6, playerInventoryItems, item, player);
					}
					break;
				case 8:
					if (playerInventoryItems.getIndex(7) == true) {
						System.out.println("You already have this item!!!");
					} else {
						Items item = new Items("Polymorph", "Essence", 12, 375000);
						Item(7, playerInventoryItems, item, player);
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
		//udìlal jsem tøídu pro magický obchod
	}
		}
	}
	
