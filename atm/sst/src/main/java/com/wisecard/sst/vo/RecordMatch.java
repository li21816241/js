package com.wisecard.sst.vo;


import java.sql.Timestamp;

import com.wisecard.sst.vo.dao.RecordInfo;

public class RecordMatch extends RecordInfo{

	private Timestamp start;
	
	private Timestamp end;

	public Timestamp getStart() {
		return start;
	}

	public void setStart(Timestamp start) {
		this.start = start;
	}

	public Timestamp getEnd() {
		return end;
	}

	public void setEnd(Timestamp end) {
		this.end = end;
	}
}
