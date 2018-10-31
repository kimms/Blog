package kr.co.blog.common.pagination;

import java.io.Serializable;

public class PaginationVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4170052414648887529L;

	private int totalCount;
	private int pageViewSize;
	private int currentPageNum;
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getPageViewSize() {
		return pageViewSize;
	}
	public void setPageViewSize(int pageViewSize) {
		this.pageViewSize = pageViewSize;
	}
	public int getCurrentPageNum() {
		return currentPageNum;
	}
	public void setCurrentPageNum(int currentPageNum) {
		this.currentPageNum = currentPageNum;
	}
	public int getPageOffSet() {
		return (this.currentPageNum - 1) * this.pageViewSize;
	}
	
}
