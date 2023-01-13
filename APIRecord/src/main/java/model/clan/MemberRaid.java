package model.clan;

public class MemberRaid {
	private String tag;
	private String name;
	private int attacks;
	private int attackLimit;
	private int bonusAttackLimit;
	private int capitalResourcesLooted;
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAttacks() {
		return attacks;
	}
	public void setAttacks(int attacks) {
		this.attacks = attacks;
	}
	public int getAttackLimit() {
		return attackLimit;
	}
	public void setAttackLimit(int attackLimit) {
		this.attackLimit = attackLimit;
	}
	public int getBonusAttackLimit() {
		return bonusAttackLimit;
	}
	public void setBonusAttackLimit(int bonusAttackLimit) {
		this.bonusAttackLimit = bonusAttackLimit;
	}
	public int getCapitalResourcesLooted() {
		return capitalResourcesLooted;
	}
	public void setCapitalResourcesLooted(int capitalResourcesLooted) {
		this.capitalResourcesLooted = capitalResourcesLooted;
	}
	
	
}
