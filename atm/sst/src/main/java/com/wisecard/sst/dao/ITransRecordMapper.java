package com.wisecard.sst.dao;

import java.util.List;

import com.wisecard.sst.vo.dao.RecordMatch;
import com.wisecard.sst.vo.dao.TransRecord;

public interface ITransRecordMapper {
	
    int deleteByPrimaryKey(Integer id);

    int insert(TransRecord record);

    int insertSelective(TransRecord record);

    TransRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TransRecord record);

    int updateByPrimaryKey(TransRecord record);
    
    List<TransRecord> getRecords( RecordMatch recordMatch );
    
    List<TransRecord> gets( String conditions);
}