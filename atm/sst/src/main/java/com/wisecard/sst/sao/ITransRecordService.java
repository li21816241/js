package com.wisecard.sst.sao;

import com.sun.tools.javac.util.List;
import com.wisecard.sst.vo.dao.TransRecord;

public interface ITransRecordService {
	
	public TransRecord get( int id );
	
	public void Insert( TransRecord transRecord );
	
	public List< TransRecord > gets( String conditions );
}
