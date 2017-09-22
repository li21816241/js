package com.wisecard.sst.vo;

import com.wisecard.sst.enu.KEYTYPE;

public class MasterKeyResult extends CommonResult {
	
	private String key;
	
	private KEYTYPE keytype;

	/**
	 * @return the key
	 */
	public String getKey() {
		return key;
	}

	/**
	 * @param key the key to set
	 */
	public void setKey(String key) {
		this.key = key;
	}

	/**
	 * @return the keytype
	 */
	public KEYTYPE getKeytype() {
		return keytype;
	}

	/**
	 * @param keytype the keytype to set
	 */
	public void setKeytype(KEYTYPE keytype) {
		this.keytype = keytype;
	}
	
	
	
}
