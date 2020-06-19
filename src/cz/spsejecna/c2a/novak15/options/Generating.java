package cz.spsejecna.c2a.novak15.options;



import cz.spsejecna.c2a.novak15.GameStats;
import cz.spsejecna.c2a.novak15.player.items.PlayerInventoryItem;
import cz.spsejecna.c2a.novak15.playerStuff.Player;

public class Generating {
	public static void GenerateEssence(PlayerInventoryItem array, Player player , GameStats stats) {
		int essence = 0;
		/// 1. if
		if (array.getIndex(0) == true) {
			// Items item = new Items("Ring", "Essence", 3, 50000);
			essence += 3;
		}
		/// 2. if
		if (array.getIndex(1) == true) {
			// Items item = new Items("Amulet", "Essence", 5, 150000);
			essence += 5;
		}
		/// 3. if
		if (array.getIndex(2) == true) {
			//	Items item = new Items("Talisman", "Essence", 4, 88000);
			essence += 4;
		}
		/// 4. if
		if (array.getIndex(3) == true) {
			// Items item = new Items("Bracelet", "Essence", 1, 25000);
			essence += 1;
		}
		/// 5. if
		if (array.getIndex(4) == true) {
			// Items item = new Items("Glove", "Essence", 3, 75000);
			essence += 3;
		}
		/// 6. if
		if (array.getIndex(5) == true) {
			//Items item = new Items("Necklace", "Essence", 8, 250000);
			essence += 8;
		}
		/// 7. if
		if (array.getIndex(6) == true) {
			// Items item = new Items("Crown", "Essence", 25, 1500000);
			essence += 25;
		}
		/// 8. if
		if (array.getIndex(7) == true) {
			// Items item = new Items("Shoulders", "Essence", 12, 375000);
			essence += 12;
		}
		/// 9. if
		if (array.getIndex(8) == true) {
			//Items item = new Items("Boots", "Essence", 6, 98000);
			essence += 6;
		}
		if(essence != 0) {
		System.out.println("You generate "+ essence + " essence");
		player.setEssence(player.getEssence()+essence);
		stats.setNumberOfAllEssence(stats.getNumberOfAllEssence()+essence);
		}
	}
}

