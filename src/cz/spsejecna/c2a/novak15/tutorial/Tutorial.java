package cz.spsejecna.c2a.novak15.tutorial;

import java.util.Scanner;

import cz.spsejecna.c2a.novak15.*;
import cz.spsejecna.c2a.novak15.resources.Coal;

public class Tutorial {

	public static String Tutorial() throws InterruptedException {
		String name = "";
		try {

			System.out.println("Greeting's traveler");
			Thread.sleep(1000);
			System.out.println("What's your name my friend?");
			Thread.sleep(1000);
			Scanner sc = new Scanner(System.in);
			name = sc.nextLine();

			System.out.println("huh... interesting name...");
			Thread.sleep(1000);
			System.out.println("anyway, " + name + " welcome to the \"MineCave\", your goal is... ");
			Thread.sleep(1000);
			System.out.println("well, just mine, mine and mine");
			Thread.sleep(1000);
			System.out.println("there are a lot of different resources you can get");
			Thread.sleep(1000);
			System.out.println("so... Enjoy");
			Thread.sleep(1000);
			System.out.println("[STILL IN ALFA]");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return name;
	}

}
