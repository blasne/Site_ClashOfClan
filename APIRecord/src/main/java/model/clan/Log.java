package model.clan;

public class Log {

    private String result;
    private String endTime;
    private int teamSize;
    private int attacksPerMember;
    private ClanCaracteristics clan;
    private ClanCaracteristics opponent;
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public int getTeamSize() {
		return teamSize;
	}
	public void setTeamSize(int teamSize) {
		this.teamSize = teamSize;
	}
	public int getAttacksPerMember() {
		return attacksPerMember;
	}
	public void setAttacksPerMember(int attacksPerMember) {
		this.attacksPerMember = attacksPerMember;
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
