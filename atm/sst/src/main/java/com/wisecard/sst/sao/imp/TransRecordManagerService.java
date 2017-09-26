package com.wisecard.sst.sao.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.wisecard.sst.dao.ITransRecordMapper;
import com.wisecard.sst.sao.ITransRecordService;
import com.wisecard.sst.vo.dao.RecordMatch;
import com.wisecard.sst.vo.dao.TransRecord;

@Controller
public class TransRecordManagerService implements ITransRecordService{

	@Autowired
	ITransRecordMapper transRecordMapper;
	
	@Override
	public TransRecord get( int id) {
		return transRecordMapper.selectByPrimaryKey( id );
	}

	@Override
	public void Insert(TransRecord transRecord) {
		transRecordMapper.insert( transRecord );
	}

	@Override
	public List<TransRecord> gets(String conditions) {
		return transRecordMapper.gets(conditions);
	}

	@Override
	public List<TransRecord> getByRecordMatch(RecordMatch recordMatch) {
		// TODO Auto-generated method stub
		return transRecordMapper.getRecords(recordMatch);
	}
}
