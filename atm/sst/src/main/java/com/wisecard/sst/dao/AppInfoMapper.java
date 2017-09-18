package com.wisecard.sst.dao;

import com.wisecard.sst.vo.dao.AppInfo;

public interface AppInfoMapper {
    int deleteByPrimaryKey(String id);

    int insert(AppInfo record);

    int insertSelective(AppInfo record);

    AppInfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(AppInfo record);

    int updateByPrimaryKey(AppInfo record);
}