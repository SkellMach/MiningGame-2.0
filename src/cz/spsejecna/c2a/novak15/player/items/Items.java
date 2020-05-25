package cz.spsejecna.c2a.novak15.player.items;

public class Items {

	String name; // name of item
	String boostName; // what is boosting this item
	int cost; // cost of this item
	int boostSpeed; // how much is boosting

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBoostName() {
		return boostName;
	}

	public void setBoostName(String boostName) {
		this.boostName = boostName;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public int getBoostSpeed() {
		return boostSpeed;
	}

	public void setBoostSpeed(int boostSpeed) {
		this.boostSpeed = boostSpeed;
	}

	public Items(String name, String boostName, int boostSpeed, int cost) {
		super();
		this.name = name;
		this.boostName = boostName;
		this.cost = cost;
		this.boostSpeed = boostSpeed;
	}

	@Override
	public String toString() {
		return "Item: " + name + ", generating: " + boostName + ", by: " + boostSpeed + ", per day";
	}

}
