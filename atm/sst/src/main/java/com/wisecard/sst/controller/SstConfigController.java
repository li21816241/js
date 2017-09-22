package com.wisecard.sst.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.bouncycastle.jcajce.provider.digest.GOST3411.HashMac;
import org.bouncycastle.jcajce.provider.symmetric.DES;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sun.tools.javac.util.List;
import com.wisecard.sst.dao.IDevInfoMapper;
import com.wisecard.sst.enu.KEYTYPE;
import com.wisecard.sst.sao.IAppManagerService;
import com.wisecard.sst.sao.IDeviceMansgerService;
import com.wisecard.sst.sao.ITermManagerService;
import com.wisecard.sst.vo.AppConfig;
import com.wisecard.sst.vo.CommonConfig;
import com.wisecard.sst.vo.DevModule;
import com.wisecard.sst.vo.MasterKeyResult;
import com.wisecard.sst.vo.TermConfig;
import com.wisecard.sst.vo.DevConfig;
import com.wisecard.sst.vo.TransInfo;
import com.wisecard.sst.vo.Workkey;
import com.wisecard.sst.vo.dao.AppInfo;
import com.wisecard.sst.vo.dao.DevInfo;
import com.wisecard.sst.vo.dao.TermInfo;

@RestController
@RequestMapping(path = "/rest/config", produces = "application/json")
//@MapResource( parent="common.app-my-profile", name="common.app-messages", order="1", url="/my/messages")
public class SstConfigController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	HttpServletResponse httpServletResponse;
	
	@Autowired
	HttpServletRequest httpServletRequest;
	
	@Autowired
	ITermManagerService termManagerService;
	
	@Autowired
	IDeviceMansgerService deviceMansgerService;
	
	@Autowired
	IAppManagerService  appManagerService;
	
	@RequestMapping(path = "/get", method = RequestMethod.GET)
    public TermConfig getconfig(HttpServletRequest request) {
		TermConfig termConfig = new TermConfig();
		TermInfo termInfo = getTermInfo( request );
		if( termInfo == null ){
			logger.error( "config error, can't find any matched terminal" );
			return termConfig;
		}
		
		List< AppInfo > list = appManagerService.gets( "termid=" + termInfo.getId() );
		if( list == null && list.size() == 0 ){
			logger.error( "config error, can't find any matched appinfo" );
			return termConfig;
		}
		AppInfo appInfo = list.get( 0 );
		
		AppConfig appConfig = getAppConfig( appInfo );
		if( appConfig == null ){
			logger.error( "config error, can't find any matched application config by ip({})", termInfo.getIp() );
			return termConfig;
		}
		
		CommonConfig commonConfig = getCommonConfig( termInfo );
		if( commonConfig == null ){
			logger.error( "config error, can't find any matched common config by ip({})", termInfo.getIp() );
			return termConfig;
		}
		
		Map< String, DevModule > mapDevs = getModulesById( termInfo.getDevid() );
		if( mapDevs == null ){
			logger.error( "config error, can't find any matched devices by ip({})", termInfo.getIp() );
			return termConfig;
		}
		Map< String, TransInfo > mapTrans = getTransById( appInfo );
		if( mapTrans == null ){
			logger.warn( "config error, can't find any matched devices by ip({})", termInfo.getIp() );
		}
		termConfig.setResult( 0 );
		termConfig.setModules( mapDevs );
		termConfig.setAppConfig(appConfig);
		termConfig.setCommonConfig(commonConfig);
		termConfig.setTrans( mapTrans );
		Cookie[] cookies = httpServletRequest.getCookies();
		if( cookies != null ){
			for( Cookie cookie : cookies ){
				if( "sessionID".compareTo( cookie.getName() ) == 0 ){
					
				}
			}
		}
		HttpSession httpSession = httpServletRequest.getSession( true );
		httpSession.setAttribute( "terminfo", termConfig );
		Cookie cookie = new Cookie("sessionID", httpSession.getId() );
		httpServletResponse.addCookie( cookie );
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
	
	@RequestMapping(path = "/masterkey", method = RequestMethod.GET)
    public MasterKeyResult masterkey() {
		HttpSession httpSession =  httpServletRequest.getSession();
		MasterKeyResult masterKeyResult = new MasterKeyResult();
		if( httpSession != null ){
			masterKeyResult.setResult( -1 );
		}else{
			masterKeyResult.setResult( 0 );
		}
		httpSession.getAttribute( "" );
		byte[] masterkey = getMasterKeyFromMachine();
		masterKeyResult.setKeytype( KEYTYPE.KT_DES );
		masterKeyResult.setKey( masterkey.toString() );
		return masterKeyResult;
	}
	
	@RequestMapping(path = "/workkey", method = RequestMethod.GET)
    public Workkey workkey() {
		HttpSession httpSession =  httpServletRequest.getSession();
		Workkey workkey = new Workkey();
		if( httpSession != null ){
			workkey.setResult( -1 );
		}else{
			workkey.setResult( 0 );
		}
		httpSession.getAttribute( "" );
		byte[] pinKey = getPinKeyFromMachine();
		workkey.setPintkeytype( KEYTYPE.KT_DES );
		workkey.setPinkey( pinKey.toString() );
		byte[] macKey = getMacKeyFromMachine();
		workkey.setPintkeytype( KEYTYPE.KT_DES );
		workkey.setPinkey( macKey.toString() );
		return workkey;
	}
	
	protected byte[] getMasterKeyFromMachine() {
		return new byte[]{ 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0};
	}
	
	protected byte[] getPinKeyFromMachine() {
		return new byte[]{ 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0};
	}
	
	protected byte[] getMacKeyFromMachine() {
		return new byte[]{ 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0};
	}
}
