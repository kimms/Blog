package kr.co.blog.common.pagination;

import java.io.Serializable;

public class PaginationQueryParamVO<T> implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1290359645416584640L;

	private T queryParam;
	private PaginationVO paginationVO;
	private String language;
	
	public T getQueryParam() {
		return queryParam;
	}
	public void setQueryParam(T queryParam) {
		this.queryParam = queryParam;
	}
	public PaginationVO getPaginationVO() {
		return paginationVO;
	}
	public void setPaginationVO(PaginationVO paginationVO) {
		this.paginationVO = paginationVO;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
}
