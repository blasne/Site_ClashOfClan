package model.clan;

import java.util.List;

public class ClanMembers {
	private List<Member> items;
	private Page paging;

	public List<Member> getItems() {
		return items;
	}

	public void setItems(List<Member> items) {
		this.items = items;
	}

	public Page getPaging() {
		return paging;
	}

	public void setPaging(Page paging) {
		this.paging = paging;
	}
	
}
