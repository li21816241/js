package com.wisecard.sst.dao;

import com.sun.tools.javac.util.List;
import com.wisecard.sst.vo.dao.TermInfo;

public interface ITermInfoMapper {
    int deleteByPrimaryKey(String id);

    int insert(TermInfo record);

    int insertSelective(TermInfo record);

    TermInfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TermInfo record);

    int updateByPrimaryKey(TermInfo record);
    
    List<TermInfo>	getTerms(String conditions );
}