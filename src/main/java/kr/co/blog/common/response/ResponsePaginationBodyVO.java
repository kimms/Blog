package kr.co.blog.common.response;

import kr.co.blog.common.pagination.PaginationVO;

public class ResponsePaginationBodyVO<T> extends ResponseBodyVO<T>{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5328599410700986008L;

	private PaginationVO pagination;

	public PaginationVO getPagination() {
		return pagination;
	}

	public void setPagination(PaginationVO pagination) {
		this.pagination = pagination;
	}
	
	public void setBody(ResponseBodyVO<T> body) {
		super.setDocCnt(body.getDocCnt());
		super.setDocs(body.getDocs());
	}
}
