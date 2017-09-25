package com.wisecard.sst.vo;

import java.util.Map;

import com.fasterxml.jackson.databind.ser.std.SerializableSerializer;

public class DevConfig extends CommonResult{
	
	private Map< String, DevModule >	modules;
	
	private Map< String, TransInfo >	trans;
	
	public Map<String, DevModule> getModules() {
		return modules;
	}

	public void setModules(Map<String, DevModule> modules) {
		this.modules = modules;
	}

	public Map<String, TransInfo> getTrans() {
		return trans;
	}

	public void setTrans(Map<String, TransInfo> trans) {
		this.trans = trans;
	}	
}
