package model.clan;

import java.util.List;

public class AttackLog {
	private Defender defender;
	private int attackCount;
	private int districtCount;
	private int districtsDestroyed;
	private List<District> districts;
	public Defender getDefender() {
		return defender;
	}
	public void setDefender(Defender defender) {
		this.defender = defender;
	}
	public int getAttackCount() {
		return attackCount;
	}
	public void setAttackCount(int attackCount) {
		this.attackCount = attackCount;
	}
	public int getDistrictCount() {
		return districtCount;
	}
	public void setDistrictCount(int districtCount) {
		this.districtCount = districtCount;
	}
	public int getDistrictsDestroyed() {
		return districtsDestroyed;
	}
	public void setDistrictsDestroyed(int districtsDestroyed) {
		this.districtsDestroyed = districtsDestroyed;
	}
	public List<District> getDistricts() {
		return districts;
	}
	public void setDistricts(List<District> districts) {
		this.districts = districts;
	}
	
}
