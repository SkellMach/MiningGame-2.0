package cz.spsejecna.c2a.novak15.playerStuff;

import cz.spsejecna.c2a.novak15.MyException;

public class Player {

	public String name;
	int lvl; // how many times, he gain skill lvl
	int speed; // increase number of mining (how many times, he can mine per day)
	int efficiency; // increase % chance to mine better resources
	int strength; // increase number of mined resource
	int pickaxe; // decrease number of needed energy for mining
	int money; // amount of money
	int xp; // amount of xp
	int essence; // amount of essence

	public int getEssence() {
		return essence;
	}

	public void setEssence(int essence) {
		this.essence = essence;
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

	public int getSpeed() {

		return speed;
	}

	public void setSpeed(int speed) throws MyException {
		if (speed < 0) {
			throw new MyException("Bruh, idk how did you manage to get negative speed, but ok");
		}
		this.speed = speed;
	}

	public int getEfficiency() {
		return efficiency;
	}

	public void setEfficiency(int efficiency) throws MyException {
		if (efficiency < 0) {
			throw new MyException("Bruh, idk how did you manage to get negative efficiency, but ok");
		}
		this.efficiency = efficiency;
	}

	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) throws MyException {
		if (strength < 0) {
			throw new MyException("Bruh, idk how did you manage to get negative strength, but ok");
		}
		this.strength = strength;
	}

	public int getPickaxe() {
		return pickaxe;
	}

	public void setPickaxe(int pickaxe) throws MyException {
		if (pickaxe < 0) {
			throw new MyException("Bruh, idk how did you manage to get negative pickaxe lvl, but ok");
		}
		this.pickaxe = pickaxe;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) throws MyException {
		if (money < 0) {
			throw new MyException("Bruh, idk how did you manage to get negative money, but ok");
		}
		this.money = money;
	}

	public int getXp() {
		return xp;
	}

	public void setXp(int xp) throws MyException {
		if (xp < 0) {
			throw new MyException("Bruh, idk how did you manage to get negative xp, but ok");
		}
		this.xp = xp;
	}

	public Player(String name, int lvl, int speed, int efficiency, int strength, int pickaxe, int money, int xp,
			int essence) {
		super();
		this.lvl = lvl;
		this.name = name;
		this.speed = speed;
		this.efficiency = efficiency;
		this.strength = strength;
		this.pickaxe = pickaxe;
		this.money = money;
		this.xp = xp;
		this.essence = essence;
	}

	@Override
	public String toString() {
		return "Player name: " + name + ", level: " + lvl + ", speed: " + speed + ", efficiency: " + efficiency
				+ ", strength: " + strength + ", pickaxe lvl: " + pickaxe + ", money: " + money + ", xp: " + xp
				+ ", essence: " + essence;
	}

	public int getLvl() {
		return lvl;
	}

	public void setLvl(int lvl) {
		this.lvl = lvl;
	}

}