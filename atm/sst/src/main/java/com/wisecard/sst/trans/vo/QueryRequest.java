package com.wisecard.sst.trans.vo;

public class QueryRequest extends RequestInfo {
	
	private String cardNo;
	
	private String queryType;
	

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getQueryType() {
		return queryType;
	}

	public void setQueryType(String queryType) {
		this.queryType = queryType;
	}
	
	
}
