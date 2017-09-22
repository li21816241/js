package com.wisecard.sst.vo;

import java.sql.Timestamp;

import com.wisecard.common.core.base.ResultVO;

public class CommonResult extends ResultVO{
	
	public CommonResult(){
		timestamp = new Timestamp( System.currentTimeMillis() ); 
	}
		
	private Timestamp timestamp;

	/**
	 * @param result the result to set
	 */
	public void setResult(int result) {
		this.setResultCode( Integer.toString( result ) );
	}

	/**
	 * @return the timestamp
	 */
	public Timestamp getTimestamp() {
		return timestamp;
	}

	/**
	 * @param timestamp the timestamp to set
	 */
	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}
	
	
	
}
