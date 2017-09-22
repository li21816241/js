package com.wisecard.sst.vo;

import com.wisecard.sst.enu.KEYTYPE;

public class Workkey extends CommonResult {
	
	private String pinkey;
	
	private KEYTYPE pintkeytype;
	
	private String mackey;
	
	private KEYTYPE mackeytype;

	/**
	 * @return the pinkey
	 */
	public String getPinkey() {
		return pinkey;
	}

	/**
	 * @param pinkey the pinkey to set
	 */
	public void setPinkey(String pinkey) {
		this.pinkey = pinkey;
	}

	/**
	 * @return the pintkeytype
	 */
	public KEYTYPE getPintkeytype() {
		return pintkeytype;
	}

	/**
	 * @param pintkeytype the pintkeytype to set
	 */
	public void setPintkeytype(KEYTYPE pintkeytype) {
		this.pintkeytype = pintkeytype;
	}

	/**
	 * @return the mackey
	 */
	public String getMackey() {
		return mackey;
	}

	/**
	 * @param mackey the mackey to set
	 */
	public void setMackey(String mackey) {
		this.mackey = mackey;
	}

	/**
	 * @return the mackeytype
	 */
	public KEYTYPE getMackeytype() {
		return mackeytype;
	}

	/**
	 * @param mackeytype the mackeytype to set
	 */
	public void setMackeytype(KEYTYPE mackeytype) {
		this.mackeytype = mackeytype;
	}
	
	
}
