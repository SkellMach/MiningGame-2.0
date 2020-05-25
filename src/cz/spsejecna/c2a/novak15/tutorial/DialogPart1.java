package cz.spsejecna.c2a.novak15.tutorial;

import java.util.Scanner;

import cz.spsejecna.c2a.novak15.MyException;
import cz.spsejecna.c2a.novak15.SecretOptions;

public class DialogPart1 {

	public static int Menu(SecretOptions secrets) throws InterruptedException {

		Thread.sleep(500);
		System.out.println("Where do you want to go?");
		Thread.sleep(250);
		System.out.println("1... Cave");
		Thread.sleep(250);
		System.out.println("2... Shop");
		Thread.sleep(250);
		System.out.println("3... Home");
		Thread.sleep(250);
		System.out.println("4... Player Stats");
		Thread.sleep(250);
		// case 5
		// nahrat z notepadu called "Secret" --> vytvorit load atd...
		if (secrets.isSecretShop() == true) {
			System.out.println("5... Secret Shop");
			Thread.sleep(250);
		}
		// asdasdas
		System.out.println("0... Do nothing");
		int option = 0;
		// secret

		Scanner sc = new Scanner(System.in);
		try {
			sc = new Scanner(System.in);
			option = sc.nextInt();

			switch (option) {
			case 1:
				System.out.println("*you go to the cave*");
				break;
			case 2:
				System.out.println("*you go shopping*");
				break;
			case 3:
				System.out.println("*you go home*");
				break;
			case 4:// nothing
				break;
			case 5:
				if (secrets.isSecretShop() == false) {
					throw new MyException("Next time, write number 0 - 4 ");
				}
				break;
			case 0:
				System.out.println("*you do nothing...*");
				break;
			default:
				option = 0;
				System.out.println("you did nothing");
				if (secrets.isSecretShop() == true) {
					throw new MyException("Next time, write number 0 - 5 ");
				} else {
					throw new MyException("Next time, write number 0 - 4 ");
				}
			}
		} catch (MyException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			if (secrets.isSecretShop() == true) {
				System.err.println("0||1||2||3||4||5");
			} else {
				System.err.println("0||1||2||3||4");
			}
		}

		return option;

	}

}
