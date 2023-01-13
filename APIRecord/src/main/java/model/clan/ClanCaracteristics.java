package model.clan;

public class ClanCaracteristics {
    private String tag;
    private String name;
    private BadgeUrl badgeUrls;
    private int clanLevel;
    private int attacks;
    private int stars;
    private int destructionPercentage;
    private int expEarned;
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
	public int getAttacks() {
		return attacks;
	}
	public void setAttacks(int attacks) {
		this.attacks = attacks;
	}
	public int getStars() {
		return stars;
	}
	public void setStars(int stars) {
		this.stars = stars;
	}
	public int getDestructionPercentage() {
		return destructionPercentage;
	}
	public void setDestructionPercentage(int destructionPercentage) {
		this.destructionPercentage = destructionPercentage;
	}
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
	public int getExpEarned() {
		return expEarned;
	}
	public void setExpEarned(int expEarned) {
		this.expEarned = expEarned;
	} 
    
    
}
