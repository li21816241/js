package com.wisecard.sst.dao;

import com.sun.tools.javac.util.List;
import com.wisecard.sst.vo.dao.AppInfo;

public interface IAppInfoMapper {
	
    int deleteByPrimaryKey(String id);

    int insert(AppInfo record);

    int insertSelective(AppInfo record);

    AppInfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(AppInfo record);

    int updateByPrimaryKey(AppInfo record);
    
    List<AppInfo> getApps( String conditions );
}