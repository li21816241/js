package com.wisecard.sst.dao;

import com.sun.tools.javac.util.List;
import com.wisecard.sst.vo.dao.RecordInfo;

public interface IRecordInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RecordInfo record);

    int insertSelective(RecordInfo record);

    RecordInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RecordInfo record);

    int updateByPrimaryKey(RecordInfo record);
    
    List< RecordInfo > gets( String conditions );
}