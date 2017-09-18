package com.wisecard.sst.sao.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.sun.tools.javac.util.List;
import com.wisecard.sst.dao.ITermInfoMapper;
import com.wisecard.sst.sao.ITermManagerService;
import com.wisecard.sst.vo.dao.TermInfo;

@Controller
public class TermServices implements ITermManagerService{
	
	@Autowired
	ITermInfoMapper termInfoMapper;
	
	public TermInfo get( String id ){
		TermInfo termInfo = termInfoMapper.selectByPrimaryKey( id );
		if( termInfo == null ){
			
		}
		return termInfo;
	}
	
	public void update( TermInfo termInfo ){
		termInfoMapper.updateByPrimaryKeySelective( termInfo );
	}
	
	public void delete( String id ){
		termInfoMapper.deleteByPrimaryKey( id );
	}
	
	public void Insert( TermInfo termInfo ){
		termInfoMapper.insert( termInfo );
	}
	
	public List< TermInfo > gets( String conditions ){
		return termInfoMapper.getTerms( conditions );
	}

	@Override
	public TermInfo getTermByIp(String ip) {
		List< TermInfo > list = termInfoMapper.getTerms( "ip=" + ip );
		if( list != null && list.size() > 0 )
			return list.get( 0 );
		return null;
	}
	
	
}
