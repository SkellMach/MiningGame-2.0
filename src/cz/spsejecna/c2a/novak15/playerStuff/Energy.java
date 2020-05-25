package cz.spsejecna.c2a.novak15.playerStuff;

public class Energy {

	int energie;
	private int maxEnergie;

	public int getMaxEnergie() {
		return maxEnergie;
	}

	public void setMaxEnegie(int maxEnergie) {

		this.setMaxEnergie(maxEnergie);
	}

	public int getEnergie() {
		return energie;
	}

	public void setEnergie(int energie) {
		if (energie >= this.getMaxEnergie()) {
			this.energie = this.getMaxEnergie();
			energie = this.getMaxEnergie();

		}
		if (energie < 0) {
			this.energie = 0;
			System.out.println("You have 0 energy");
		} else {
			this.energie = energie;
		}
	}

	@Override
	public String toString() {
		return "Your energy: " + energie + "/" + getMaxEnergie();
	}

	public Energy(int energie, int maxEnergie) {
		super();
		this.energie = energie;
		this.setMaxEnergie(maxEnergie);
	}

	public void setMaxEnergie(int maxEnergie) {
		this.maxEnergie = maxEnergie;
	}

}
