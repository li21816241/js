package com.wisecard.sst.dao;

import com.wisecard.sst.vo.dao.TermInfo;

public interface TermInfoMapper {
    int deleteByPrimaryKey(String id);

    int insert(TermInfo record);

    int insertSelective(TermInfo record);

    TermInfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TermInfo record);

    int updateByPrimaryKey(TermInfo record);
}