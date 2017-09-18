package com.wisecard.sst.dao;

import com.wisecard.sst.vo.dao.TransRecord;

public interface TransRecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TransRecord record);

    int insertSelective(TransRecord record);

    TransRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TransRecord record);

    int updateByPrimaryKey(TransRecord record);
}