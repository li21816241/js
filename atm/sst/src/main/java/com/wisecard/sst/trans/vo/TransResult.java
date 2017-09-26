package com.wisecard.sst.trans.vo;

import java.sql.Timestamp;

import com.wisecard.sst.vo.CommonResult;

public class TransResult extends CommonResult{
	
	private int requestId;
	
	private int resultid;
	
	private String devId;
	
	private Object resultdata;

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
