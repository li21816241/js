package com.wisecard.sst.sao;

import java.util.List;

import com.wisecard.sst.vo.dao.RecordMatch;
import com.wisecard.sst.vo.dao.TransRecord;

public interface ITransRecordService {
	
	public TransRecord get( int id );
	
	public void Insert( TransRecord transRecord );
	
	public List<TransRecord> getByRecordMatch( RecordMatch recordMatch); 
	
	public List< TransRecord > gets( String conditions );
}
