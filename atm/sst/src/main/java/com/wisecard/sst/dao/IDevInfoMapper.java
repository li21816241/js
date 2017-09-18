package com.wisecard.sst.dao;

import com.sun.tools.javac.util.List;
import com.wisecard.sst.vo.dao.DevInfo;

public interface IDevInfoMapper {
    int deleteByPrimaryKey(String id);

    int insert(DevInfo record);

    int insertSelective(DevInfo record);

    DevInfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DevInfo record);

    int updateByPrimaryKey(DevInfo record);
    
    List<DevInfo> getDevs( String conditions );
}