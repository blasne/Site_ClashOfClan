package model.clan;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ClanInfo {
	
	private String tag;
	private String name;
	private String type;
	private String description;
	private Location location;	
	private BadgeUrl badgeUrls;
	private int clanLevel;
	private int clanPoints;
	private int clanVersusPoints;
	private int requiredTrophies;
	private String warFrequency;
	private int warWinStreak;
	private int warWins;
	private int warTies;
	private int warLosses;
	@JsonProperty(value="isWarLogPublic")
	private boolean isWarLogPublic;
	private WarLeague warLeague;
	private int members;
	private List<Member> memberList; 
	private List<Label> labels;
	private int requiredVersusTrophies;
	private int requiredTownhallLevel;
	private Capital clanCapital;
	
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	public BadgeUrl getBadgeUrls() {
		return badgeUrls;
	}
	public void setBadgeUrls(BadgeUrl badgeUrls) {
		this.badgeUrls = badgeUrls;
	}
	public int getClanLevel() {
		return clanLevel;
	}
	public void setClanLevel(int clanLevel) {
		this.clanLevel = clanLevel;
	}
	public int getClanPoints() {
		return clanPoints;
	}
	public void setClanPoints(int clanPoints) {
		this.clanPoints = clanPoints;
	}
	public int getClanVersusPoints() {
		return clanVersusPoints;
	}
	public void setClanVersusPoints(int clanVersusPoints) {
		this.clanVersusPoints = clanVersusPoints;
	}
	public int getRequiredTrophies() {
		return requiredTrophies;
	}
	public void setRequiredTrophies(int requiredTrophies) {
		this.requiredTrophies = requiredTrophies;
	}
	public String getWarFrequency() {
		return warFrequency;
	}
	public void setWarFrequency(String warFrequency) {
		this.warFrequency = warFrequency;
	}
	public int getWarWinStreak() {
		return warWinStreak;
	}
	public void setWarWinStreak(int warWinStreak) {
		this.warWinStreak = warWinStreak;
	}
	public int getWarWins() {
		return warWins;
	}
	public void setWarWins(int warWins) {
		this.warWins = warWins;
	}
	public int getWarTies() {
		return warTies;
	}
	public void setWarTies(int warTies) {
		this.warTies = warTies;
	}
	public int getWarLosses() {
		return warLosses;
	}
	public void setWarLosses(int warLosses) {
		this.warLosses = warLosses;
	}
	public boolean isWarLogPublic() {
		return isWarLogPublic;
	}
	public void setWarLogPublic(boolean isWarLogPublic) {
		this.isWarLogPublic = isWarLogPublic;
	}
	public WarLeague getWarLeague() {
		return warLeague;
	}
	public void setWarLeague(WarLeague warLeague) {
		this.warLeague = warLeague;
	}
	public int getMembers() {
		return members;
	}
	public void setMembers(int members) {
		this.members = members;
	}
	public List<Member> getMemberList() {
		return memberList;
	}
	public void setMemberList(List<Member> memeberList) {
		this.memberList = memeberList;
	}
	public List<Label> getLabels() {
		return labels;
	}
	public void setLabels(List<Label> labels) {
		this.labels = labels;
	}
	public int getRequiredVersusTrophies() {
		return requiredVersusTrophies;
	}
	public void setRequiredVersusTrophies(int requiredVersusTrophies) {
		this.requiredVersusTrophies = requiredVersusTrophies;
	}
	public int getRequiredTownhallLevel() {
		return requiredTownhallLevel;
	}
	public void setRequiredTownhallLevel(int requiredTownhallLevel) {
		this.requiredTownhallLevel = requiredTownhallLevel;
	}
	public Capital getClanCapital() {
		return clanCapital;
	}
	public void setClanCapital(Capital clanCapital) {
		this.clanCapital = clanCapital;
	}
	
	
}
