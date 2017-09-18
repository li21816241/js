package com.wisecard.sst.sao.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.sun.tools.javac.util.List;
import com.wisecard.sst.dao.IDevInfoMapper;
import com.wisecard.sst.sao.IDeviceMansgerService;
import com.wisecard.sst.vo.dao.DevInfo;

@Controller
public class DeviceService implements IDeviceMansgerService{
	
	@Autowired
	IDevInfoMapper devInfoMapper;
	
	public DevInfo get( String id ){
		DevInfo devInfo = devInfoMapper.selectByPrimaryKey( id );
		if( devInfo == null ){
			
		}
		return devInfo;
	}
	
	public void update( DevInfo devInfo ){
		devInfoMapper.updateByPrimaryKeySelective( devInfo );
	}
	
	public void delete( String id ){
		devInfoMapper.deleteByPrimaryKey( id );
	}
	
	public void Insert( DevInfo devInfo ){
		devInfoMapper.insert( devInfo );
	}
	
	public List< DevInfo > gets( String conditions ){
		return devInfoMapper.getDevs( conditions );
	}
	
}
