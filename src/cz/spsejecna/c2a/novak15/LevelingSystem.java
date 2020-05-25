package cz.spsejecna.c2a.novak15;

import java.util.Scanner;

import cz.spsejecna.c2a.novak15.playerStuff.Player;
import cz.spsejecna.c2a.novak15.resources.*;

public class LevelingSystem {

	public static void LevelUp(Player player) throws InterruptedException, MyException {
		int xpForLevel = 1000 * (player.getLvl() + 1);
		if (xpForLevel < player.getXp()) {
			player.setXp(player.getXp() - xpForLevel);
			player.setLvl(player.getLvl() + 1);
			System.out.println();
			Thread.sleep(200);
			System.out.println("LEVEL UP!!!");
			Thread.sleep(500);
			System.out.println("your lvl is now " + player.getLvl());
			Thread.sleep(200);
			System.out.println("you gain 1 skillpoint!");
			Thread.sleep(200);
			SkillPoint(player);
		}
	}

	public static void SkillPoint(Player player) throws InterruptedException {
		System.out.println();
		System.out.println("Choose one, what you want to upgrade:");
		Thread.sleep(1000);
		System.out.println("1... speed");
		Thread.sleep(200);
		System.out.println("2... efficiency");
		Thread.sleep(200);
		System.out.println("3... strength");
		Thread.sleep(200);
		int option = 0;
		do {
			try {
				Scanner sc = new Scanner(System.in);
				option = sc.nextInt();
				switch (option) {
				case 1:
					player.setSpeed(player.getSpeed() + 1);
					System.out.println("*you feel be faster than before*");
					System.out.println("Your currrent speed lvl: " + player.getSpeed());
					break;
				case 2:
					player.setEfficiency(player.getEfficiency() + 1); // efficiency(coal, diamond, emerald, gold, iron, kobalt, magnetit, uran);
					System.out.println("*you feel be luckier than before*");
					System.out.println("Your currrent efficiency lvl: " + player.getEfficiency());
					break;
				case 3:
					player.setStrength(player.getStrength() + 1);
					System.out.println("*you feel be stronger than before*");
					System.out.println("Your currrent strength lvl: " + player.getStrength());
					break;
				default:
					throw new MyException("Wrong number, write 1-3 ");

				}
			} catch (MyException e) {
				System.out.println(e.getMessage());
			} catch (Exception e) {
				System.err.println("1||2||3");
			}

		} while (option != 1 && option != 2 && option != 3);

	}

}
