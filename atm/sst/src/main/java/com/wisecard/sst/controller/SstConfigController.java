package com.wisecard.sst.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.bouncycastle.jcajce.provider.digest.GOST3411.HashMac;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sun.tools.javac.util.List;
import com.wisecard.sst.dao.IDevInfoMapper;
import com.wisecard.sst.sao.IAppManagerService;
import com.wisecard.sst.sao.IDeviceMansgerService;
import com.wisecard.sst.sao.ITermManagerService;
import com.wisecard.sst.vo.AppConfig;
import com.wisecard.sst.vo.CommonConfig;
import com.wisecard.sst.vo.DevModule;
import com.wisecard.sst.vo.TermConfig;
import com.wisecard.sst.vo.DevConfig;
import com.wisecard.sst.vo.TransInfo;
import com.wisecard.sst.vo.dao.AppInfo;
import com.wisecard.sst.vo.dao.DevInfo;
import com.wisecard.sst.vo.dao.TermInfo;

@RestController
@RequestMapping(path = "/rest/config", produces = "application/json")
//@MapResource( parent="common.app-my-profile", name="common.app-messages", order="1", url="/my/messages")
public class SstConfigController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	@Autowired
	ITermManagerService termManagerService;
	
	@Autowired
	IDeviceMansgerService deviceMansgerService;
	
	@Autowired
	IAppManagerService  appManagerService;
	
	@RequestMapping(path = "/get", method = RequestMethod.GET)
    public DevConfig getconfig(HttpServletRequest request) {
		TermInfo termInfo = getTermInfo( request );
		if( termInfo == null ){
			logger.error( "config error, can't find any matched terminal" );
			return null;
		}
		
		List< AppInfo > list = appManagerService.gets( "termid=" + termInfo.getId() );
		if( list == null && list.size() == 0 ){
			logger.error( "config error, can't find any matched appinfo" );
			return null;
		}
		AppInfo appInfo = list.get( 0 );
		
		AppConfig appConfig = getAppConfig( appInfo );
		if( appConfig == null ){
			logger.error( "config error, can't find any matched application config by ip({})", termInfo.getIp() );
			return null;
		}
		
		CommonConfig commonConfig = getCommonConfig( termInfo );
		if( commonConfig == null ){
			logger.error( "config error, can't find any matched common config by ip({})", termInfo.getIp() );
			return null;
		}
		
		Map< String, DevModule > mapDevs = getModulesById( termInfo.getDevid() );
		if( mapDevs == null ){
			logger.error( "config error, can't find any matched devices by ip({})", termInfo.getIp() );
			return null;
		}
		Map< String, TransInfo > mapTrans = getTransById( appInfo );
		if( mapTrans == null ){
			logger.warn( "config error, can't find any matched devices by ip({})", termInfo.getIp() );
		}
		
		TermConfig termConfig = new TermConfig();
		termConfig.setModules( mapDevs );
		termConfig.setAppConfig(appConfig);
		termConfig.setCommonConfig(commonConfig);
		termConfig.setTrans( mapTrans );
		return termConfig;
	}
	
	
	
	protected Map<String, DevModule> getModulesById( String DevId ) {
		DevInfo devInfo = deviceMansgerService.get( DevId );
		if( devInfo != null ){
			HashMap< String, DevModule > map = new HashMap<>();
			int value = devInfo.getDevices().intValue();
			for( int i = 0;i < 31; i++ ){
				int type = value & ( 0x01 << i );
				if( type != 0 ){
					DevModule devModule = new DevModule();
					String name = DevInfo.getDevName( type );
					devModule.setName( DevInfo.getDevName( type ) );
					devModule.setId( DevInfo.getDevId( type ) );
					devModule.setType( DevInfo.getDevType( type ) );
					map.put( name, devModule );
				}
			}
			return map;
		}
		return null;
	}
	
	protected Map<String, TransInfo> getTransById( AppInfo appInfo) {
		if( appInfo != null ){
			HashMap< String, TransInfo > map = new HashMap<>();
			int value = appInfo.getSuppertTrans();
			for( int i = 0;i < 31; i++ ){
				int type = value & ( 0x01 << i );
				if( type != 0 ){
					TransInfo transInfo = new TransInfo();
					String name = AppInfo.getTransName( type );
					transInfo.setName( name );
					transInfo.setModule( AppInfo.getTransModule( type ));
					map.put( name, transInfo );
				}
			}
			return map;
		}
		
		return null;
	}
	
	protected CommonConfig	getCommonConfig( TermInfo termInfo ) {
		return null;
	}
	
	protected AppConfig	getAppConfig( AppInfo appInfo ) {
		AppConfig appConfig = new AppConfig();
		appConfig.setMaxcount( 30000 );
		return appConfig;
	}
	
	protected TermInfo getTermInfo( HttpServletRequest request ){
		String ip = request.getHeader("x-forwarded-for"); 
	    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
	      ip = request.getHeader("Proxy-Client-IP"); 
	    } 
	    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
	      ip = request.getHeader("WL-Proxy-Client-IP"); 
	    } 
	    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
	      ip = request.getHeader("HTTP_CLIENT_IP"); 
	    } 
	    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
	      ip = request.getHeader("HTTP_X_FORWARDED_FOR"); 
	    } 
	    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
	      ip = request.getRemoteAddr(); 
	    } 
	    return termManagerService.getTermByIp( ip );
	}
}
