package cz.spsejecna.c2a.novak15.playerStuff;

public class Boost {
	String boostName;
	String whatBoost;
	int howMany;
	int howLong;
	boolean IsActivated;

	public boolean isIsActive() {
		return IsActive;
	}

	public void setIsActive(boolean isActive) {
		IsActive = isActive;
	}

	public String getBoostName() {
		return boostName;
	}

	public void setBoostName(String boostName) {
		this.boostName = boostName;
	}

	public String getWhatBoost() {
		return whatBoost;
	}

	public void setWhatBoost(String whatBoost) {
		this.whatBoost = whatBoost;
	}

	public int getHowMany() {
		return howMany;
	}

	public void setHowMany(int howMany) {
		this.howMany = howMany;
	}

	public int getHowLong() {
		return howLong;
	}

	public void setHowLong(int howLong) {
		this.howLong = howLong;
	}

	@Override
	public String toString() {
		return "You have activate boost called: " + boostName + ", it's boosting " + this.whatBoost + " by " + howMany
				+ " %, for " + howLong + " day.";
	}

	public Boost(String boostName, String whatBoost, int howMany, int howLong, boolean isActive) {
		super();
		this.boostName = boostName;
		this.whatBoost = whatBoost;
		this.howMany = howMany;
		this.howLong = howLong;
		this.IsActive = isActive;
	}

}