package model.clan;

public class District {

	private int id;
	private String name;
	private int districtHallLevel;
	private int destructionPercent;
	private int stars;
	private int attackCount;
	private int totalLooted;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDistrictHallLevel() {
		return districtHallLevel;
	}
	public void setDistrictHallLevel(int districtHallLevel) {
		this.districtHallLevel = districtHallLevel;
	}
	public int getDestructionPercent() {
		return destructionPercent;
	}
	public void setDestructionPercent(int destructionPercent) {
		this.destructionPercent = destructionPercent;
	}
	public int getStars() {
		return stars;
	}
	public void setStars(int stars) {
		this.stars = stars;
	}
	public int getAttackCount() {
		return attackCount;
	}
	public void setAttackCount(int attackCount) {
		this.attackCount = attackCount;
	}
	public int getTotalLooted() {
		return totalLooted;
	}
	public void setTotalLooted(int totalLooted) {
		this.totalLooted = totalLooted;
	}
	
	
}
