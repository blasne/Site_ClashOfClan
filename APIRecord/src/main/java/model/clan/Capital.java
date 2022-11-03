package model.clan;

import java.util.List;

public class Capital {

	private int capitalHallLevel;
	private List<District> districts;

	public int getCapitalHallLevel() {
		return capitalHallLevel;
	}
	public void setCapitalHallLevel(int capitalHallLevel) {
		this.capitalHallLevel = capitalHallLevel;
	}
	public List<District> getDistricts() {
		return districts;
	}
	public void setDistricts(List<District> districts) {
		this.districts = districts;
	}

}
