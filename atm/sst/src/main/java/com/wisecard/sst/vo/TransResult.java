package com.wisecard.sst.vo;

import java.sql.Timestamp;

public class TransResult {
	
	private int resultcode;
	
	private String reason;
	
	private int requestId;
	
	private int resultid;
	
	private Timestamp timestamp;
	
	private String devId;
	
	private Object resultdata;

	public int getResultcode() {
		return resultcode;
	}

	public void setResultcode(int resultcode) {
		this.resultcode = resultcode;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public int getRequestId() {
		return requestId;
	}

	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}

	public int getResultid() {
		return resultid;
	}

	public void setResultid(int resultid) {
		this.resultid = resultid;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	public String getDevId() {
		return devId;
	}

	public void setDevId(String devId) {
		this.devId = devId;
	}

	public Object getResultdata() {
		return resultdata;
	}

	public void setResultdata(Object resultdata) {
		this.resultdata = resultdata;
	}

	
}
