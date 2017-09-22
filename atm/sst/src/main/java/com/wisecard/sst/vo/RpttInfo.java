package com.wisecard.sst.vo;

public class RpttInfo extends CommonResult{
	
	boolean updateMasterKey;
	
	boolean updatePinKey;
	
	boolean updateMacKey;
	
	boolean updateConfig;

	/**
	 * @return the updateMasterKey
	 */
	public boolean isUpdateMasterKey() {
		return updateMasterKey;
	}

	/**
	 * @param updateMasterKey the updateMasterKey to set
	 */
	public void setUpdateMasterKey(boolean updateMasterKey) {
		this.updateMasterKey = updateMasterKey;
	}

	/**
	 * @return the updatePinKey
	 */
	public boolean isUpdatePinKey() {
		return updatePinKey;
	}

	/**
	 * @param updatePinKey the updatePinKey to set
	 */
	public void setUpdatePinKey(boolean updatePinKey) {
		this.updatePinKey = updatePinKey;
	}

	/**
	 * @return the updateMacKey
	 */
	public boolean isUpdateMacKey() {
		return updateMacKey;
	}

	/**
	 * @param updateMacKey the updateMacKey to set
	 */
	public void setUpdateMacKey(boolean updateMacKey) {
		this.updateMacKey = updateMacKey;
	}

	/**
	 * @return the updateConfig
	 */
	public boolean isUpdateConfig() {
		return updateConfig;
	}

	/**
	 * @param updateConfig the updateConfig to set
	 */
	public void setUpdateConfig(boolean updateConfig) {
		this.updateConfig = updateConfig;
	}
	
}
