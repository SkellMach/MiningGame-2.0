package cz.spsejecna.c2a.novak15;

public class GameStats {

	int day;
	int NumberOfAllMinedResources;
	int NumberOfAllGatheredXP;
	int NumberOfAllGatheredMoney;
	int NumberOfAllEssence;
	
	public int getNumberOfAllEssence() {
		return NumberOfAllEssence;
	}

	public void setNumberOfAllEssence(int numberOfAllEssence) {
		NumberOfAllEssence = numberOfAllEssence;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getNumberOfAllMinedResources() {
		return NumberOfAllMinedResources;
	}

	public void setNumberOfAllMinedResources(int numberOfAllMinedResources) {

		NumberOfAllMinedResources = numberOfAllMinedResources;
	}

	public int getNumberOfAllGatheredXP() {
		return NumberOfAllGatheredXP;
	}

	public void setNumberOfAllGatheredXP(int numberOfAllGatheredXP) {
		NumberOfAllGatheredXP = numberOfAllGatheredXP;
	}

	public int getNumberOfAllGatheredMoney() {
		return NumberOfAllGatheredMoney;
	}

	public void setNumberOfAllGatheredMoney(int numberOfAllGatheredMoney) {
		NumberOfAllGatheredMoney = numberOfAllGatheredMoney;
	}

	public GameStats(int day, int numberOfAllMinedResources, int numberOfAllGatheredXP, int numberOfAllGatheredMoney,	int NumberOfAllEssence) {
		super();
		this.day = day;
		this.NumberOfAllMinedResources = numberOfAllMinedResources;
		this.NumberOfAllGatheredXP = numberOfAllGatheredXP;
		this.NumberOfAllGatheredMoney = numberOfAllGatheredMoney;
		this.NumberOfAllEssence = NumberOfAllEssence;
	}

	@Override
	public String toString() {
		return "GameStats: " + "Day: " + day + ", Gathered resources: " + NumberOfAllMinedResources
				+ ", Experience gained: " + NumberOfAllGatheredXP + ", Gathered money: " + NumberOfAllGatheredMoney + ", Gathered Essence: "+NumberOfAllEssence;
	}

}
