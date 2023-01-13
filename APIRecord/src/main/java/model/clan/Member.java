package model.clan;

public class Member {
	
	private String tag;
	private String name;
	private String role;
	private int expLevel;
	private League league;
    private int trophies;
    private int versusTrophies;
    private int clanRank;
    private int previousClanRank;
    private int donations;
    private int donationsReceived;
    private PlayerHouse playerHouse;

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
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public int getExpLevel() {
		return expLevel;
	}
	public void setExpLevel(int expLevel) {
		this.expLevel = expLevel;
	}
	public League getLeague() {
		return league;
	}
	public void setLeague(League league) {
		this.league = league;
	}
	public int getTrophies() {
		return trophies;
	}
	public void setTrophies(int trophies) {
		this.trophies = trophies;
	}
	public int getVersusTrophies() {
		return versusTrophies;
	}
	public void setVersusTrophies(int versusTrophies) {
		this.versusTrophies = versusTrophies;
	}
	public int getClanRank() {
		return clanRank;
	}
	public void setClanRank(int clanRank) {
		this.clanRank = clanRank;
	}
	public int getPreviousClanRank() {
		return previousClanRank;
	}
	public void setPreviousClanRank(int previousClanRank) {
		this.previousClanRank = previousClanRank;
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
	public PlayerHouse getPlayerHouse() {
		return playerHouse;
	}
	public void setPlayerHouse(PlayerHouse playerHouse) {
		this.playerHouse = playerHouse;
	}

}
