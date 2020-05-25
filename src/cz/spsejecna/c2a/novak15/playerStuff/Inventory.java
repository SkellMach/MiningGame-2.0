package cz.spsejecna.c2a.novak15.playerStuff;

import cz.spsejecna.c2a.novak15.MyException;

public class Inventory {
	int coal;
	int iron;
	int kobalt;
	int magnetit;
	int gold;
	int emerald;
	int diamond;
	int uran;

	public int getCoal() {
		return coal;
	}

	public void setCoal(int coal) throws MyException {
		coal += this.coal;
		if (coal < 0) {
			throw new MyException("Bruh, idk how did you manage to get negative amount of coal...");
		}
		this.coal = coal;
	}

	public int getIron() {
		return iron;
	}

	public void setIron(int iron) throws MyException {
		iron += this.iron;
		if (iron < 0) {
			throw new MyException("Bruh, idk how did you manage to get negative amount of iron...");
		}
		this.iron = iron;
	}

	public int getKobalt() {

		return kobalt;
	}

	public void setKobalt(int kobalt) throws MyException {
		kobalt += this.kobalt;
		if (kobalt < 0) {
			throw new MyException("Bruh, idk how did you manage to get negative amount of kobalt...");
		}
		this.kobalt = kobalt;
	}

	public int getMagnetit() {
		return magnetit;
	}

	public void setMagnetit(int magnetit) throws MyException {
		magnetit += this.magnetit;
		if (magnetit < 0) {
			throw new MyException("Bruh, idk how did you manage to get negative amount of magnetit...");
		}
		this.magnetit = magnetit;
	}

	public int getGold() {
		return gold;
	}

	public void setGold(int gold) throws MyException {
		gold += this.gold;
		if (gold < 0) {
			throw new MyException("Bruh, idk how did you manage to get negative amount of gold...");
		}
		this.gold = gold;
	}

	public int getEmerald() {
		return emerald;
	}

	public void setEmerald(int emerald) throws MyException {
		emerald += this.emerald;
		if (emerald < 0) {
			throw new MyException("Bruh, idk how did you manage to get negative amount of emerald...");
		}
		this.emerald = emerald;
	}

	public int getDiamond() {
		return diamond;
	}

	public void setDiamond(int diamond) throws MyException {
		diamond += this.diamond;
		if (diamond < 0) {
			throw new MyException("Bruh, idk how did you manage to get negative amount of diamond...");
		}
		this.diamond = diamond;
	}

	public int getUran() {
		return uran;
	}

	public void setUran(int uran) throws MyException {
		uran += this.uran;
		if (uran < 0) {
			throw new MyException("Bruh, idk how did you manage to get negative amount of uran...");
		}
		this.uran = uran;
	}

	public Inventory(int coal, int iron, int kobalt, int magnetit, int gold, int emerald, int diamond, int uran) {
		super();
		this.coal = coal;
		this.iron = iron;
		this.kobalt = kobalt;
		this.magnetit = magnetit;
		this.gold = gold;
		this.emerald = emerald;
		this.diamond = diamond;
		this.uran = uran;
	}

	@Override
	public String toString() {
		return "Inventory: " + "coal: " + coal + ", iron: " + iron + ", kobalt: " + kobalt + ", magnetit: " + magnetit
				+ ", gold: " + gold + ", emerald: " + emerald + ", diamond: " + diamond + ", uran: " + uran;
	}

}
