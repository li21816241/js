package com.wisecard.sst.sao.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.sun.tools.javac.util.List;
import com.wisecard.sst.dao.IAppInfoMapper;
import com.wisecard.sst.sao.IAppManagerService;
import com.wisecard.sst.vo.dao.AppInfo;

@Controller
public class AppServices implements IAppManagerService {
	
	@Autowired
	IAppInfoMapper appInfoMapper;
	
	public AppInfo get( String id ){
		AppInfo appInfo = appInfoMapper.selectByPrimaryKey( id );
		if( appInfo == null ){
			
		}
		return appInfo;
	}
	
	public void update( AppInfo appInfo ){
		appInfoMapper.updateByPrimaryKeySelective( appInfo );
	}
	
	public void delete( String id ){
		appInfoMapper.deleteByPrimaryKey( id );
	}
	
	public void Insert( AppInfo appInfo ){
		appInfoMapper.insert( appInfo );
	}
	
	public List< AppInfo > gets( String conditions ){
		return appInfoMapper.getApps( conditions );
	}	
}
