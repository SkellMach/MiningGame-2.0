package cz.spsejecna.c2a.novak15;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import cz.spsejecna.c2a.novak15.player.items.PlayerInventoryItem;
import cz.spsejecna.c2a.novak15.playerStuff.Boost;
import cz.spsejecna.c2a.novak15.playerStuff.Energy;
import cz.spsejecna.c2a.novak15.playerStuff.Inventory;
import cz.spsejecna.c2a.novak15.playerStuff.Player;
import cz.spsejecna.c2a.novak15.resources.Coal;
import cz.spsejecna.c2a.novak15.resources.Diamond;
import cz.spsejecna.c2a.novak15.resources.Emerald;
import cz.spsejecna.c2a.novak15.resources.Gold;
import cz.spsejecna.c2a.novak15.resources.Iron;
import cz.spsejecna.c2a.novak15.resources.Kobalt;
import cz.spsejecna.c2a.novak15.resources.Magnetit;
import cz.spsejecna.c2a.novak15.resources.Uran;

public class SavingProgress {

	public static void Save(Player player, Inventory inventory, GameStats stats, Boost boost, Energy energy,
			SecretOptions secrets, PlayerInventoryItem playerInventoryItems) { // every time, when
		// player will finish i
		// cycle of
		// mining, the game will save his progress
		// (items, gold, experience, etc...)
/////////////////////////// different file ///////////////////////////////
		try (BufferedWriter bw = new BufferedWriter(new FileWriter("Progress.txt"))) {
			bw.write(player.toString() + System.lineSeparator()+ System.lineSeparator());
			bw.write(inventory.toString() + System.lineSeparator()+ System.lineSeparator());
			if (boost.isIsActivate() == true) {
				bw.write(boost.toString() + System.lineSeparator()+ System.lineSeparator());
			} else {
				bw.write("You don't have any boost active" + System.lineSeparator()+ System.lineSeparator());
			}
			bw.write(energy.toString() + System.lineSeparator()+ System.lineSeparator());

			bw.write(playerInventoryItems.toString() + System.lineSeparator()+ System.lineSeparator());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
/////////////////////////// different file ///////////////////////////////
		try (BufferedWriter bw = new BufferedWriter(new FileWriter("GameStats.txt"))) {
			bw.write(stats.toString()+ System.lineSeparator());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
/////////////////////////// different file ///////////////////////////////
		try (BufferedWriter bw = new BufferedWriter(new FileWriter("Secret.txt"))) {
			bw.write(secrets.toString()+ System.lineSeparator());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void Load(Player player, Inventory inventory, GameStats stats, Boost boost, Energy energy,
			SecretOptions secrets, PlayerInventoryItem playerInventoryItems) throws MyException { // every time, when
		// player will start the
		// Game/program, the program will try find his
		// progress in computer, if directory is not
		// found, program will create new one.
		try (BufferedReader fileInput = new BufferedReader(new FileReader(new File("Progress.txt")))) {
			// Regexs for finding the data in player
			Pattern playerName = Pattern.compile("Player name: (\\S*),");
			Pattern playerLVL = Pattern.compile("level: (\\d*),");
			Pattern playerSpeed = Pattern.compile("speed: (\\d*),");
			Pattern playerEfficiency = Pattern.compile("efficiency: (\\d*),");
			Pattern playerStrength = Pattern.compile("strength: (\\d*),");
			Pattern playerPickaxeLVL = Pattern.compile("pickaxe lvl: (\\d*),");
			Pattern playerMoney = Pattern.compile("money: (\\d*),");
			Pattern playerXP = Pattern.compile("xp: (\\d*),");
			Pattern playerEssence = Pattern.compile("essence: (\\d*)");
			// Regexs for finding the data of Inventory
			Pattern inventoryCoal = Pattern.compile("coal: (\\d*),");
			Pattern inventoryDiamond = Pattern.compile("diamond: (\\d*),");
			Pattern inventoryEmerald = Pattern.compile("emerald: (\\d*),");
			Pattern inventoryGold = Pattern.compile("gold: (\\d*),");
			Pattern inventoryIron = Pattern.compile("iron: (\\d*),");
			Pattern inventoryKobalt = Pattern.compile("kobalt: (\\d*),");
			Pattern inventoryMagnetit = Pattern.compile("magnetit: (\\d*),");
			Pattern inventoryUran = Pattern.compile("uran: (\\d*)");
			// regexs for finding the data of resources;
			Pattern boostName = Pattern.compile("You have activate boost called: (\\w*|\\@\\#\\!\\$\\?\\&\\$) food,");
			Pattern boostWhatBoost = Pattern.compile("it's boosting (\\w*) ");
			Pattern boostHowMany = Pattern.compile("by (\\d*) %,");
			Pattern boostHowLong = Pattern.compile("for (\\d*) day.");
			///// booost
			Pattern energyPlayer = Pattern.compile("energy: (\\d*)");
			Pattern maxEnergyPlayer = Pattern.compile("\\/(\\d*)");
			///// player item inventory
			Pattern itemRing = Pattern.compile("Ring: (true|false)");
			Pattern itemAmulet = Pattern.compile("Amulet: (true|false)");
			Pattern itemTalisman = Pattern.compile("Talisman: (true|false)");
			Pattern itemBracelet = Pattern.compile("Bracelet: (true|false)");
			Pattern itemGlove = Pattern.compile("Glove: (true|false)");
			Pattern itemNecklace = Pattern.compile("Necklace: (true|false)");
			Pattern itemCrown = Pattern.compile("Crown: (true|false)");
			Pattern itemShoulders = Pattern.compile("Shoulders: (true|false)");
			Pattern itemBoots = Pattern.compile("Boots: (true|false)");

			/////////////////////////////////////
			String progress = fileInput.readLine();
			while (progress != null) {
				// matchers player
				Matcher m1 = playerName.matcher(progress);
				Matcher m2 = playerLVL.matcher(progress);
				Matcher m3 = playerSpeed.matcher(progress);
				Matcher m4 = playerEfficiency.matcher(progress);
				Matcher m5 = playerStrength.matcher(progress);
				Matcher m6 = playerPickaxeLVL.matcher(progress);
				Matcher m7 = playerMoney.matcher(progress);
				Matcher m8 = playerXP.matcher(progress);
				Matcher m9 = playerEssence.matcher(progress);
				// matcher inventory
				Matcher n1 = inventoryCoal.matcher(progress);
				Matcher n2 = inventoryDiamond.matcher(progress);
				Matcher n3 = inventoryEmerald.matcher(progress);
				Matcher n4 = inventoryGold.matcher(progress);
				Matcher n5 = inventoryIron.matcher(progress);
				Matcher n6 = inventoryKobalt.matcher(progress);
				Matcher n7 = inventoryMagnetit.matcher(progress);
				Matcher n8 = inventoryUran.matcher(progress);
				//// matcher booost
				Matcher b1 = boostName.matcher(progress);
				Matcher b2 = boostWhatBoost.matcher(progress);
				Matcher b3 = boostHowMany.matcher(progress);
				Matcher b4 = boostHowLong.matcher(progress);
				/// energy
				Matcher e1 = energyPlayer.matcher(progress);
				Matcher e2 = maxEnergyPlayer.matcher(progress);
				// player item inventory
				Matcher i1 = itemRing.matcher(progress);
				Matcher i2 = itemAmulet.matcher(progress);
				Matcher i3 = itemTalisman.matcher(progress);
				Matcher i4 = itemBracelet.matcher(progress);
				Matcher i5 = itemGlove.matcher(progress);
				Matcher i6 = itemNecklace.matcher(progress);
				Matcher i7 = itemCrown.matcher(progress);
				Matcher i8 = itemShoulders.matcher(progress);
				Matcher i9 = itemBoots.matcher(progress);

				// find() methods player
				if (m1.find()) {
					player.name = m1.group(1);
				}
				if (m2.find()) {
					Integer x = Integer.valueOf(m2.group(1));
					player.setLvl(x);
				}
				if (m3.find()) {
					Integer x = Integer.valueOf(m3.group(1));
					player.setSpeed(x);
				}
				if (m4.find()) {
					Integer x = Integer.valueOf(m4.group(1));
					player.setEfficiency(x);
				}
				if (m5.find()) {
					Integer x = Integer.valueOf(m5.group(1));
					player.setStrength(x);
				}
				if (m6.find()) {
					Integer x = Integer.valueOf(m6.group(1));
					player.setPickaxe(x);
				}
				if (m7.find()) {
					Integer x = Integer.valueOf(m7.group(1));
					player.setMoney(x);
				}
				if (m8.find()) {
					Integer x = Integer.valueOf(m8.group(1));
					player.setXp(x);
				}
				if (m9.find()) {
					Integer x = Integer.valueOf(m9.group(1));
					player.setEssence(x);
				}
				// find() methods inventory
				if (n1.find()) {
					Integer x = Integer.valueOf(n1.group(1));
					inventory.setCoal(x);
				}
				if (n2.find()) {
					Integer x = Integer.valueOf(n2.group(1));
					inventory.setDiamond(x);
				}
				if (n3.find()) {
					Integer x = Integer.valueOf(n3.group(1));
					inventory.setEmerald(x);
				}
				if (n4.find()) {
					Integer x = Integer.valueOf(n4.group(1));
					inventory.setGold(x);
				}
				if (n5.find()) {
					Integer x = Integer.valueOf(n5.group(1));
					inventory.setIron(x);
				}
				if (n6.find()) {
					Integer x = Integer.valueOf(n6.group(1));
					inventory.setKobalt(x);
				}
				if (n7.find()) {
					Integer x = Integer.valueOf(n7.group(1));
					inventory.setMagnetit(x);
				}
				if (n8.find()) {
					Integer x = Integer.valueOf(n8.group(1));
					inventory.setUran(x);
				}
				// find() methods boost
				progress = fileInput.readLine();
				if (b1.find()) {
					boost.setBoostName(b1.group(1) + " food");
				}
				if (b2.find()) {
					boost.setWhatBoost(b2.group(1));
				}
				if (b3.find()) {
					Integer x = Integer.valueOf(b3.group(1));
					boost.setHowMany(x);
				}
				if (b4.find()) {
					Integer x = Integer.valueOf(b4.group(1));
					boost.setHowLong(x);
				}
				/// energy
				if (e1.find()) {
					Integer x = Integer.valueOf(e1.group(1));
					energy.setEnergie(x);
				}
				if (e2.find()) {
					Integer x = Integer.valueOf(e2.group(1));
					energy.setMaxEnergie(x);
				}
				//// player inventory item
				if (i1.find()) {
					// true if
					if (i1.group(1).equals("true")) {
						playerInventoryItems.setIndex(0, true); 
					}
					if (i1.group(1).equals("false")) {
						playerInventoryItems.setIndex(0, false); 
					}

				}
				if (i2.find()) {
					// true if
					if (i2.group(1).equals("true")) {
						playerInventoryItems.setIndex(1, true); 
					}
					if (i2.group(1).equals("false")) {
						playerInventoryItems.setIndex(1, false); 
					}

				}
				if (i3.find()) {
					// true if
					if (i3.group(1).equals("true")) {
						playerInventoryItems.setIndex(2, true); 
					}
					if (i3.group(1).equals("false")) {
						playerInventoryItems.setIndex(2, false); 
					}

				}
				if (i4.find()) {
					// true if
					if (i4.group(1).equals("true")) {
						playerInventoryItems.setIndex(3, true); 
					}
					if (i4.group(1).equals("false")) {
						playerInventoryItems.setIndex(3, false); 
					}

				}
				if (i5.find()) {
					// true if
					if (i5.group(1).equals("true")) {
						playerInventoryItems.setIndex(4, true); 
					}
					if (i5.group(1).equals("false")) {
						playerInventoryItems.setIndex(4, false); 
					}

				}
				if (i6.find()) {
					// true if
					if (i6.group(1).equals("true")) {
						playerInventoryItems.setIndex(5, true); 
					}
					if (i6.group(1).equals("false")) {
						playerInventoryItems.setIndex(5, false); 
					}

				}
				if (i7.find()) {
					// true if
					if (i7.group(1).equals("true")) {
						playerInventoryItems.setIndex(6, true); 
					}
					if (i7.group(1).equals("false")) {
						playerInventoryItems.setIndex(6, false); 
					}

				}
				if (i8.find()) {
					// true if
					if (i8.group(1).equals("true")) {
						playerInventoryItems.setIndex(7, true); 
					}
					if (i8.group(1).equals("false")) {
						playerInventoryItems.setIndex(7, false); 
					}

				}
				if (i9.find()) {
					// true if
					if (i9.group(1).equals("true")) {
						playerInventoryItems.setIndex(8, true); 
					}
					if (i9.group(1).equals("false")) {
						playerInventoryItems.setIndex(8, false); 
					}

				}
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/////////////////////////// different file ///////////////////////////////
		try (BufferedReader fileInput = new BufferedReader(new FileReader(new File("GameStats.txt")))) {
			/////// patterns
			Pattern day = Pattern.compile("Day: (\\d*),");
			Pattern resources = Pattern.compile("Gathered resources: (\\d*),");
			Pattern xp = Pattern.compile("Experience gained: (\\d*),");
			Pattern money = Pattern.compile("Gathered money: (\\d*),");
			Pattern essence = Pattern.compile("Gathered essence: (\\d*)");

			//// matchers
			String statss = fileInput.readLine();
			while (statss != null) {
				Matcher m1 = day.matcher(statss);
				Matcher m2 = resources.matcher(statss);
				Matcher m3 = xp.matcher(statss);
				Matcher m4 = money.matcher(statss);
				Matcher m5 = essence.matcher(statss);
				if (m1.find()) {
					Integer x = Integer.valueOf(m1.group(1));
					stats.day = x;
				}
				if (m2.find()) {
					Integer x = Integer.valueOf(m2.group(1));
					stats.NumberOfAllMinedResources = x;
				}
				if (m3.find()) {
					Integer x = Integer.valueOf(m3.group(1));
					stats.NumberOfAllGatheredXP = x;
				}
				if (m4.find()) {
					Integer x = Integer.valueOf(m4.group(1));
					stats.NumberOfAllGatheredMoney = x;
				}
				if (m5.find()) {
					Integer x = Integer.valueOf(m5.group(1));
					stats.NumberOfAllEssence = x;
				}
				statss = fileInput.readLine();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/////////////////////////// different file ///////////////////////////////
		try (BufferedReader fileInput = new BufferedReader(new FileReader(new File("Secret.txt")))) {
			Pattern secretShop = Pattern.compile("secretShop: (true|false)");

			String statss = fileInput.readLine();
			while (statss != null) {
				Matcher m1 = secretShop.matcher(statss);
				if (m1.find()) {
					// true if
					if (m1.group(1).equals("true")) {
						secrets.secretShop = true;
					}
					if (m1.group(1).equals("false")) {
						secrets.secretShop = false;
					}

				}

				statss = fileInput.readLine();
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void NewFile() {

		try {
			FileWriter wr = new FileWriter("Progress.txt");
			FileWriter dr = new FileWriter("GameStats.txt");
			FileWriter sr = new FileWriter("Secret.txt");
			wr.close();
			dr.close();
			sr.close();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

}
