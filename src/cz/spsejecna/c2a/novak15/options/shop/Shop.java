package cz.spsejecna.c2a.novak15.options.shop;

import java.util.Scanner;

import cz.spsejecna.c2a.novak15.MyException;
import cz.spsejecna.c2a.novak15.playerStuff.Boost;
import cz.spsejecna.c2a.novak15.playerStuff.Energy;
import cz.spsejecna.c2a.novak15.playerStuff.Player;

public class Shop {

	public static void shoppping(Boost boost, Player player, Energy energy) throws InterruptedException {
		int option = 0;
		int choose = 0;
		Boost food = new Boost(null, null, 0, 0, false);
		int foodCost = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("Greetings traveler");
		Thread.sleep(250);
		System.out.println("Welcome to my little shop, here you can upgrade your pickaxe, or buy some fresh food :)");
		Thread.sleep(1000);
		System.out.println("Shop menu:");
		Thread.sleep(250);
		System.out.println("1... Upgrade pickaxe");
		Thread.sleep(100);
		System.out.println("2... Junk food");
		Thread.sleep(100);
		System.out.println("3... Average food");
		Thread.sleep(100);
		System.out.println("4... Good food");
		Thread.sleep(100);
		System.out.println("5... Awesome food");
		Thread.sleep(100);
		System.out.println("6... Delicious food");
		Thread.sleep(100);
		System.out.println("7... Titans food");
		Thread.sleep(100);
		System.out.println("8... Godly  food");
		Thread.sleep(100);
		System.out.println("9... @#!$?&$");
		Thread.sleep(200);
		System.out.println("0...  Leave shop");
		Thread.sleep(500);
		System.out.println("Warning: if you already have an active boost, you will lose your current boost!!!");
		//Oprava gramatiky
		Thread.sleep(250);

		do {
			sc = new Scanner(System.in);
			System.out.println("Current money: " + player.getMoney()+ " $");
			try {
				option = sc.nextInt();
				switch (option) {
				case 1:

					try {
						System.out.println("Current pickaxe lvl: " + player.getPickaxe());
						Thread.sleep(100);
						System.out.println("Upgrade your pickaxe for " + player.getPickaxe() * 2500);
						Thread.sleep(100);
						System.out.println("1... Yes");
						System.out.println("0... No");
						choose = sc.nextInt();
						if (choose != 1 && choose != 0) {
							throw new MyException("Wrong number, write 0 or 1 ");
						}
						if (choose == 1) {
							if (player.getMoney() >= player.getPickaxe() * 2500) {
								System.out.println("your pickaxe lvl increase by 1");
								Thread.sleep(100);
								System.out.println("Your Max energy increase by 20!");
								Thread.sleep(100);
								energy.setMaxEnegie(energy.getMaxEnergie()+20);
								System.out.println("Your max energy is now " + energy.getMaxEnergie());
								player.setPickaxe(player.getPickaxe() + 1);
								player.setMoney(player.getMoney() - player.getPickaxe() * 2500);
								
							} else {
								System.out.println("Not enough gold");
							}
						}
						if (choose == 0) {
							break;
						}

					} catch (MyException e) {
						System.out.println(e.getLocalizedMessage());
					} catch (Exception err) {
						System.err.println("Error");
					}

					break;
				case 2:
					food = new Boost("Junk food", "Experience", 1000, 14, true);
					foodCost = 500;
					ShoppingFood(foodCost, food, player, boost);
					break;
				case 3:
					food = new Boost("Average food", "Gold", 20, 14, true);
					foodCost = 1000;
					ShoppingFood(foodCost, food, player, boost);
					break;
				case 4:
					food = new Boost("Good food", "Experience", 50, 7, true);
					foodCost = 3333;
					ShoppingFood(foodCost, food, player, boost);
					break;
				case 5:
					food = new Boost("Awesome food", "Experience", 100, 7, true);
					foodCost = 5750;
					ShoppingFood(foodCost, food, player, boost);
					break;
				case 6:
					food = new Boost("Delicious food", "Gold", 150, 7, true);
					foodCost = 12000;
					ShoppingFood(foodCost, food, player, boost);
					break;
				case 7:
					food = new Boost("Titans food", "Gold", 250, 7, true);
					foodCost = 28000;
					ShoppingFood(foodCost, food, player, boost);
					break;
				case 8:
					food = new Boost("Godly food", "Experience", 1000, 7, true);
					foodCost = 56750;
					ShoppingFood(foodCost, food, player, boost);
					break;
				case 9:
					food = new Boost("@#!$?&$ food", "Gold & Experience", 5000, 3, true);
					foodCost = 666666;
					ShoppingFood(foodCost, food, player, boost);
					break;
				case 0:
					System.out.println("*you leave a shop*");
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

	public static void ShoppingFood(int foodCost, Boost food, Player player, Boost boost) {
		Scanner sc = new Scanner(System.in);
		int choose = 0;
		try {
			System.out.println(food.getBoostName() + ", boosts: " + food.getWhatBoost() + ", by: " + food.getHowMany()
					+ "% , for: " + food.getHowLong() + " days");
			System.out.println("Cost: " + foodCost);
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
				if (player.getMoney() >= foodCost) {
					System.out.println("You bought " + food.getBoostName());
					boost.setBoostName(food.getBoostName());
					boost.setWhatBoost(food.getWhatBoost());
					boost.setHowMany(food.getHowMany());
					boost.setHowLong(food.getHowLong());
					boost.setIsActivate(true);

					player.setMoney(player.getMoney() - foodCost);

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
