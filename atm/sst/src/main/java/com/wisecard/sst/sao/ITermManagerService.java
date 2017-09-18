package com.wisecard.sst.sao;

import com.sun.tools.javac.util.List;
import com.wisecard.sst.vo.dao.TermInfo;

public interface ITermManagerService {
	public TermInfo get( String id );
	
	public void update( TermInfo termInfo );
	
	public void delete( String id );
	
	public void Insert( TermInfo termInfo );
	
	public TermInfo getTermByIp( String ip );
	
	public List< TermInfo > gets( String conditions );
}
