package model.clan;

import java.util.List;

public class WarLog {
	private List<Log> items;
	private Page paging;
	
	public List<Log> getItems() {
		return items;
	}

	public void setItems(List<Log> items) {
		this.items = items;
	}

	public Page getPaging() {
		return paging;
	}

	public void setPaging(Page paging) {
		this.paging = paging;
	}
	
}
