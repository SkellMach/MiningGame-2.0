package cz.spsejecna.c2a.novak15.resources;

public class Unlucky {

	boolean coal;
	boolean diamond;
	boolean emerald;
	boolean gold;
	boolean iron;
	boolean kobalt;
	boolean magnetit;
	boolean uran;

	public boolean isCoal() {
		return coal;
	}

	public void setCoal(boolean coal) {
		this.coal = coal;
	}

	public boolean isDiamond() {
		return diamond;
	}

	public void setDiamond(boolean diamond) {
		this.diamond = diamond;
	}

	public boolean isEmerald() {
		return emerald;
	}

	public void setEmerald(boolean emerald) {
		this.emerald = emerald;
	}

	public boolean isGold() {
		return gold;
	}

	public void setGold(boolean gold) {
		this.gold = gold;
	}

	public boolean isIron() {
		return iron;
	}

	public void setIron(boolean iron) {
		this.iron = iron;
	}

	public boolean isKobalt() {
		return kobalt;
	}

	public void setKobalt(boolean kobalt) {
		this.kobalt = kobalt;
	}

	public boolean isMagnetit() {
		return magnetit;
	}

	public void setMagnetit(boolean magnetit) {
		this.magnetit = magnetit;
	}

	public boolean isUran() {
		return uran;
	}

	public void setUran(boolean uran) {
		this.uran = uran;
	}

	public Unlucky(boolean coal, boolean diamond, boolean emerald, boolean gold, boolean iron, boolean kobalt,
			boolean magnetit, boolean uran) {
		super();
		this.coal = coal;
		this.diamond = diamond;
		this.emerald = emerald;
		this.gold = gold;
		this.iron = iron;
		this.kobalt = kobalt;
		this.magnetit = magnetit;
		this.uran = uran;
	}

	@Override
	public String toString() {
		if (this.coal == false && this.diamond == false && this.emerald == false && this.gold == false
				&& this.iron == false && this.kobalt == false && this.magnetit == false && this.uran == false)
			return "You found nothing... :(";
		if (this.coal == true && this.diamond == true && this.emerald == true && this.gold == true && this.iron == true
				&& this.kobalt == true && this.magnetit == true && this.uran == true)
			return "Woaw, you were really lucky this time...";
		return "";
	}

}
