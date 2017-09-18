package com.wisecard.sst.dao;

import com.wisecard.sst.vo.dao.DevInfo;

public interface DevInfoMapper {
    int deleteByPrimaryKey(String id);

    int insert(DevInfo record);

    int insertSelective(DevInfo record);

    DevInfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DevInfo record);

    int updateByPrimaryKey(DevInfo record);
}