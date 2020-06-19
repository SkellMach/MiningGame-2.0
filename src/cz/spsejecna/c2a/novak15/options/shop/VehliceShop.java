package cz.spsejecna.c2a.novak15.options.shop;

public class VehicleShop {
	//upravil jsem jméno tøídy, vydedukoval jsem, že by to mìl být obchod s vozidly
	int option = 0;// helping variable
	int choose = 0;// helping variable
	Scanner sc = new Scanner(System.in);

	System.out.println("Hey... you finally arrived");
	Thread.sleep(250);
	System.out.println("welcome to the Škoda vehicle shop ");
	Thread.sleep(250);
	System.out.println("some items are maybe illegal so, yeah...");
	Thread.sleep(250);
	System.out.println("don't talk about them");
	Thread.sleep(250);
	System.out.println("Shop menu:");
	Thread.sleep(250);
	System.out.println("1... Favorit ");
	Thread.sleep(100);
	System.out.println("2... Felicia ");
	Thread.sleep(100);
	System.out.println("3... Octavia");
	Thread.sleep(100);
	System.out.println("4... Fabia");
	Thread.sleep(100);
	System.out.println("5... Superb");
	Thread.sleep(100);
	System.out.println("0...  Leave shop");
	
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
					Items item = new Items("Favorit", "Money", 3, 50000);
					Item(0, playerInventoryItems, item, player);
				}
				break;
			case 2:
				if (playerInventoryItems.getIndex(1) == true) {
					System.out.println("You already have this item!!!");
				} else {
					Items item = new Items("Felicia", "Money", 5, 150000);
					Item(1, playerInventoryItems, item, player);
				}
				break;
			case 3:
				if (playerInventoryItems.getIndex(2) == true) {
					System.out.println("You already have this item!!!");
				} else {
					Items item = new Items("Octavia", "Money", 4, 88000);
					Item(2, playerInventoryItems, item, player);
				}
				break;
			case 4:
				if (playerInventoryItems.getIndex(3) == true) {
					System.out.println("You already have this item!!!");
				} else {
					Items item = new Items("Fabia", "Money", 1, 25000);
					Item(3, playerInventoryItems, item, player);
				}
				break;
			case 5:
				if (playerInventoryItems.getIndex(4) == true) {
					System.out.println("You already have this item!!!");
				} else {
					Items item = new Items("Superb", "Money", 3, 75000);
					Item(4, playerInventoryItems, item, player);
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

}
