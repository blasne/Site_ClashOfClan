package model.clan;

import java.util.List;

public class Player {
	private String tag;
	private String name;
	private int townHallLevel;
	private int townHallWeaponLevel;
	private int expLevel;
	private int trophies;
	private int bestTrophies;
	private int warStars;
	private int attackWins;
	private int defenseWins;
	private int builderHallLevel;
	private int versusTrophies;
	private int bestVersusTrophies;
	private int versusBattleWins;
	private String role;
	private String warPreference;
	private int donations;
	private int donationsReceived;
	private int clanCapitalContributions;
	private ClanInfo clan;
	private League league;
	private List<Achievement> achievements;
	private House playerHouse;
	private int versusBattleWinCount;
	private List<Label> labels;
	private List<Troop> troops;
	private List<Troop> heroes;
	private List<Troop> spells;
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
	public int getTownHallLevel() {
		return townHallLevel;
	}
	public void setTownHallLevel(int townHallLevel) {
		this.townHallLevel = townHallLevel;
	}
	public int getExpLevel() {
		return expLevel;
	}
	public void setExpLevel(int expLevel) {
		this.expLevel = expLevel;
	}
	public int getTrophies() {
		return trophies;
	}
	public void setTrophies(int trophies) {
		this.trophies = trophies;
	}
	public int getBestTrophies() {
		return bestTrophies;
	}
	public void setBestTrophies(int bestTrophies) {
		this.bestTrophies = bestTrophies;
	}
	public int getWarStars() {
		return warStars;
	}
	public void setWarStars(int warStars) {
		this.warStars = warStars;
	}
	public int getAttackWins() {
		return attackWins;
	}
	public void setAttackWins(int attackWins) {
		this.attackWins = attackWins;
	}
	public int getDefenseWins() {
		return defenseWins;
	}
	public void setDefenseWins(int defenseWins) {
		this.defenseWins = defenseWins;
	}
	public int getBuilderHallLevel() {
		return builderHallLevel;
	}
	public void setBuilderHallLevel(int builderHallLevel) {
		this.builderHallLevel = builderHallLevel;
	}
	public int getVersusTrophies() {
		return versusTrophies;
	}
	public void setVersusTrophies(int versusTrophies) {
		this.versusTrophies = versusTrophies;
	}
	
	public House getPlayerHouse() {
		return playerHouse;
	}
	public void setPlayerHouse(House playerHouse) {
		this.playerHouse = playerHouse;
	}
	public int getBestVersusTrophies() {
		return bestVersusTrophies;
	}
	public void setBestVersusTrophies(int bestVersusTrophies) {
		this.bestVersusTrophies = bestVersusTrophies;
	}
	public int getVersusBattleWins() {
		return versusBattleWins;
	}
	public void setVersusBattleWins(int versusBattleWins) {
		this.versusBattleWins = versusBattleWins;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getWarPreference() {
		return warPreference;
	}
	public void setWarPreference(String warPreference) {
		this.warPreference = warPreference;
	}
	public int getDonations() {
		return donations;
	}
	public void setDonations(int donations) {
		this.donations = donations;
	}
	public int getDonationsReceived() {
		return donationsReceived;
	}
	public void setDonationsReceived(int donationsReceived) {
		this.donationsReceived = donationsReceived;
	}
	public int getClanCapitalContributions() {
		return clanCapitalContributions;
	}
	public void setClanCapitalContributions(int clanCapitalContributions) {
		this.clanCapitalContributions = clanCapitalContributions;
	}
	public ClanInfo getClan() {
		return clan;
	}
	public void setClan(ClanInfo clan) {
		this.clan = clan;
	}
	public League getLeague() {
		return league;
	}
	public void setLeague(League league) {
		this.league = league;
	}
	public List<Achievement> getAchievements() {
		return achievements;
	}
	public void setAchievements(List<Achievement> achievements) {
		this.achievements = achievements;
	}
	public int getVersusBattleWinCount() {
		return versusBattleWinCount;
	}
	public void setVersusBattleWinCount(int versusBattleWinCount) {
		this.versusBattleWinCount = versusBattleWinCount;
	}
	public List<Label> getLabels() {
		return labels;
	}
	public void setLabels(List<Label> labels) {
		this.labels = labels;
	}
	public List<Troop> getTroops() {
		return troops;
	}
	public void setTroops(List<Troop> troops) {
		this.troops = troops;
	}
	public List<Troop> getHeroes() {
		return heroes;
	}
	public void setHeroes(List<Troop> heroes) {
		this.heroes = heroes;
	}
	public List<Troop> getSpells() {
		return spells;
	}
	public void setSpells(List<Troop> spells) {
		this.spells = spells;
	}
	public int getTownHallWeaponLevel() {
		return townHallWeaponLevel;
	}
	public void setTownHallWeaponLevel(int townHallWeaponLevel) {
		this.townHallWeaponLevel = townHallWeaponLevel;
	}
	
	
}
