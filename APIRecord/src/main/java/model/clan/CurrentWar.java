package model.clan;

public class CurrentWar {
	private String state;
	private ClanCaracteristics clan;
	private ClanCaracteristics opponent;
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public ClanCaracteristics getClan() {
		return clan;
	}
	public void setClan(ClanCaracteristics clan) {
		this.clan = clan;
	}
	public ClanCaracteristics getOpponent() {
		return opponent;
	}
	public void setOpponent(ClanCaracteristics opponent) {
		this.opponent = opponent;
	}
	
	
}
