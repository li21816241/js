package com.wisecard.sst.sao;

import com.sun.tools.javac.util.List;
import com.wisecard.sst.vo.dao.AppInfo;

public interface IAppManagerService {
	
	public AppInfo get( String id );
	
	public void update( AppInfo appInfo );
	
	public void delete( String id );
	
	public void Insert( AppInfo appInfo );
	
	public List< AppInfo > gets( String conditions );
}
