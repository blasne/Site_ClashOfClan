package model.clan;

public class Defender {
    private String tag;
    private String name;
    private int level;
    private BadgeUrl badgeUrls;
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
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public BadgeUrl getBadgeUrls() {
		return badgeUrls;
	}
	public void setBadgeUrls(BadgeUrl badgeUrls) {
		this.badgeUrls = badgeUrls;
	}

}
