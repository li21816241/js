package com.wisecard.sst.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wisecard.sst.vo.AppConfig;
import com.wisecard.sst.vo.CommonConfig;
import com.wisecard.sst.vo.DevModule;
import com.wisecard.sst.vo.TermConfig;
import com.wisecard.sst.vo.DevConfig;
import com.wisecard.sst.vo.TransInfo;

@RestController
@RequestMapping(path = "/rest/config", produces = "application/json")
//@MapResource( parent="common.app-my-profile", name="common.app-messages", order="1", url="/my/messages")
public class SstConfigController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping(path = "/get", method = RequestMethod.GET)
    public DevConfig getconfig(HttpServletRequest request) {
		String devId = getDevId();
		if( devId == null ){
			logger.error( "request info err" );
			return null;
		}
		
		AppConfig appConfig = getAppConfig( devId );
		if( appConfig == null ){
			logger.error( "config error, can't find any matched application config by dev({})", devId );
			return null;
		}
		
		CommonConfig commonConfig = getCommonConfig( devId );
		if( commonConfig == null ){
			logger.error( "config error, can't find any matched common config by dev({})", devId );
			return null;
		}
		
		Map< String, DevModule > mapDevs = getModulesById( devId );
		if( mapDevs == null ){
			logger.error( "config error, can't find any matched devices by dev({})", devId );
			return null;
		}
		Map< String, TransInfo > mapTrans = getTransById( devId );
		if( mapTrans == null ){
			logger.warn( "config error, can't find any matched devices by dev({})", devId );
		}
		
		TermConfig termConfig = new TermConfig();
		termConfig.setModules( mapDevs );
		termConfig.setAppConfig(appConfig);
		termConfig.setCommonConfig(commonConfig);
		termConfig.setTrans( mapTrans );
		return termConfig;
	}
	
	
	
	protected Map<String, DevModule> getModulesById( String DevId ) {
		return null;
	}
	
	protected Map<String, TransInfo> getTransById( String DevId ) {
		return null;
	}
	
	protected CommonConfig	getCommonConfig( String devId ) {
		return null;
	}
	
	protected AppConfig	getAppConfig( String devId ) {
		return null;
	}
	
	protected String getDevId(){
		return "";
	}
}
