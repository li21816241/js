package com.wisecard.sst.sao;

import com.sun.tools.javac.util.List;
import com.wisecard.sst.vo.dao.DevInfo;

public interface IDeviceMansgerService {
	public DevInfo get( String id );
	
	public void update( DevInfo devInfo );
	
	public void delete( String id );
	
	public void Insert( DevInfo devInfo );
	
	public List< DevInfo > gets( String conditions );
}
