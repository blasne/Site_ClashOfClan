package model.clan;

import java.util.List;

public class CapitalRaidSeasons {
	private List<CapitalRaid> items;
	private Page paging;
	public List<CapitalRaid> getItems() {
		return items;
	}
	public void setItems(List<CapitalRaid> items) {
		this.items = items;
	}
	public Page getPaging() {
		return paging;
	}
	public void setPaging(Page paging) {
		this.paging = paging;
	}
	
	
}
