package com.wisecard.sst.vo;

public class TermConfig extends DevConfig{
	
	private CommonConfig	commonConfig;
	
	private AppConfig 		appConfig;

	public CommonConfig getCommonConfig() {
		return commonConfig;
	}

	public void setCommonConfig(CommonConfig commonConfig) {
		this.commonConfig = commonConfig;
	}

	public AppConfig getAppConfig() {
		return appConfig;
	}

	public void setAppConfig(AppConfig appConfig) {
		this.appConfig = appConfig;
	}
	
	
}
