package org.scrutmydocs.webapp.api.search.data;

import java.io.Serializable;

public class SearchQuery implements Serializable {
	private static final long serialVersionUID = 1L;

	protected String search;
	protected int first;
	protected int pageSize;
    protected String index;
	/**
	 * @return the search
	 */
	public String getSearch() {
		return search;
	}
    /**
     * @return the search
     */
    public String getIndex() {
        return index;
    }
	/**
	 * @param search the search to set
	 */
	public void setSearch(String search) {
		this.search = search;
	}
	/**
	 * @return the first
	 */
	public int getFirst() {
		return first;
	}
	/**
	 * @param first the first to set
	 */
	public void setFirst(int first) {
		this.first = first;
	}
	/**
	 * @return the pageSize
	 */
	public int getPageSize() {
		return pageSize;
	}
	/**
	 * @param pageSize the pageSize to set
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}



}
