package model.clan;

import java.util.List;

public class CapitalRaid {
    private String state;
    private String startTime;
    private String endTime;
    private int capitalTotalLoot;
    private int raidsCompleted;
    private int totalAttacks;
    private int enemyDistrictsDestroyed;
    private int offensiveReward;
    private int defensiveReward;
    private List<MemberRaid> members;
    private List<AttackLog> attackLog;
    private List<DefenseLog> defenseLog;
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public int getCapitalTotalLoot() {
		return capitalTotalLoot;
	}
	public void setCapitalTotalLoot(int capitalTotalLoot) {
		this.capitalTotalLoot = capitalTotalLoot;
	}
	public int getRaidsCompleted() {
		return raidsCompleted;
	}
	public void setRaidsCompleted(int raidsCompleted) {
		this.raidsCompleted = raidsCompleted;
	}
	public int getTotalAttacks() {
		return totalAttacks;
	}
	public void setTotalAttacks(int totalAttacks) {
		this.totalAttacks = totalAttacks;
	}
	public int getEnemyDistrictsDestroyed() {
		return enemyDistrictsDestroyed;
	}
	public void setEnemyDistrictsDestroyed(int enemyDistrictsDestroyed) {
		this.enemyDistrictsDestroyed = enemyDistrictsDestroyed;
	}
	public int getOffensiveReward() {
		return offensiveReward;
	}
	public void setOffensiveReward(int offensiveReward) {
		this.offensiveReward = offensiveReward;
	}
	public int getDefensiveReward() {
		return defensiveReward;
	}
	public void setDefensiveReward(int defensiveReward) {
		this.defensiveReward = defensiveReward;
	}
	public List<MemberRaid> getMembers() {
		return members;
	}
	public void setMembers(List<MemberRaid> members) {
		this.members = members;
	}
	public List<AttackLog> getAttackLog() {
		return attackLog;
	}
	public void setAttackLog(List<AttackLog> attackLog) {
		this.attackLog = attackLog;
	}
	public List<DefenseLog> getDefenseLog() {
		return defenseLog;
	}
	public void setDefenseLog(List<DefenseLog> defenseLog) {
		this.defenseLog = defenseLog;
	}
    
    
}
