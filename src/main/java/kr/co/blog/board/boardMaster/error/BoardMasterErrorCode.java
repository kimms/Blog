package kr.co.blog.board.boardMaster.error;

import kr.co.blog.common.error.ErrorCode;

public enum BoardMasterErrorCode implements ErrorCode{
    BOARD_NAME_IS_DUPLICATE("BDM0N01-412")
    
    ;
	
	private String errorCode;
	
	BoardMasterErrorCode(String errorCode){
		this.errorCode = errorCode;
	}
	
	@Override
	public String getErrorCode() {
		return errorCode;
	}
}

