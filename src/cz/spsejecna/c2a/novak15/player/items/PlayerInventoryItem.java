package cz.spsejecna.c2a.novak15.player.items;

import java.util.Arrays;

public class PlayerInventoryItem {

	boolean[] fieldArray = new boolean[8];

	public boolean[] getFieldArray() {
		return fieldArray;
	}

	public void setFieldArray(boolean[] fieldArray) {
		this.fieldArray = fieldArray;
	}

	public PlayerInventoryItem(boolean[] fieldArray) {
		super();
		this.fieldArray = fieldArray;
	}
	public boolean getIndex(int x ) {
		return this.fieldArray[x];
	}
	
	public void setIndex(int x, boolean e ) {
		this.fieldArray[x] = e;
	}
	
	@Override
	public String toString() {
		return "Inventory of items: " +System.lineSeparator()
				+ "Ring: " + fieldArray[0]+System.lineSeparator()
				+ "Amulet: " + fieldArray[1]+System.lineSeparator()
				+ "Talisman: " +  fieldArray[2]+System.lineSeparator()
				+ "Bracelet: " + fieldArray[3]+System.lineSeparator()
				+ "Glove: " + fieldArray[4]+System.lineSeparator()
				+ "Necklace: " +  fieldArray[5]+System.lineSeparator()
				+ "Crown: " + fieldArray[6]+System.lineSeparator()
				+ "Shoulders: " + fieldArray[7]+System.lineSeparator()
				+ "Boots: " + fieldArray[8] + System.lineSeparator();
	}
	
}
