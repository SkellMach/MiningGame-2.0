package cz.spsejecna.c2a.novak15.resources;

import cz.spsejecna.c2a.novak15.MyException;

public abstract class Resource {

	///// name of resource
	String name;

	public Resource(String name, int chance, int gold, int xp) {
		this.name = name;
		this.chance = chance;
		this.cost = gold;
		this.xp = xp;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) throws MyException {
		if (name.equals(null)) {
			throw new MyException("Name cannot be null");
		}
		this.name = name;
	}

	///// value of resource
	int cost;

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) throws MyException {
		if (cost < 0) {
			throw new MyException("Bruh, idk how did you manage to set Value of resouce to negative...");
		}
		this.cost = cost;
	}

	///// chance to find it/ mine it
	int chance;

	public int getChance() {
		return chance;
	}

	public void setChance(int chance) throws MyException {
		if (chance < 0) {
			throw new MyException("Bruh, idk how did you manage to set chance of resouce to negative...");
		}
		this.chance = chance;
	}
	///// experience from resource

	int xp;

	public int getXp() {
		return xp;
	}

	public void setXp(int xp) throws MyException {
		if (xp < 0) {
			throw new MyException("Bruh, idk how did you manage to set experience of resouce to negative...");
		}
		this.xp = xp;
	}

	@Override
	public String toString() {
		return name + " [ cost :" + cost + " ] [ chance(%) : " + chance + " ] [ xp : " + xp + " ]";
	}

}
