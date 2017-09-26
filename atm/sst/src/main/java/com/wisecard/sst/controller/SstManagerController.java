package com.wisecard.sst.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sun.tools.corba.se.idl.constExpr.Terminal;
import com.sun.tools.doclets.formats.html.TagletWriterImpl;
import com.wisecard.sst.dao.IRecordInfoMapper;
import com.wisecard.sst.trans.vo.IssuseCardRequest;
import com.wisecard.sst.vo.CommonResult;
import com.wisecard.sst.vo.RecordMatch;
import com.wisecard.sst.vo.dao.RecordInfo;
import com.wisecard.sst.vo.dao.TermInfo;
import com.wisecard.web.core.page.Pager;

@RestController
@RequestMapping(path = "/rest/admin/ctm", produces = "application/json")
public class SstManagerController {
	
	@Autowired
	IRecordInfoMapper recordInfoMapper;
	
		
	
	@RequestMapping(path = "/view/{termid}")
	public  TermInfo getTermInfo( @PathVariable String termid ){
		return null;
	}
	
	@RequestMapping(path = "/views")
	public  Pager< TermInfo > getTermInfo( Pager<TermInfo> pagerParam ){
		Pager< TermInfo > pager = null;
		return pager;
	}
	
	@RequestMapping( path="/add" )
	public CommonResult addTerminal( TermInfo termInfo ){
		CommonResult commonResult = new CommonResult();
		return commonResult;
	}
	
	@RequestMapping( path="/update" )
	public CommonResult updateTerminal( TermInfo termInfo ){
		CommonResult commonResult = new CommonResult();
		return commonResult;
	}
	
	@RequestMapping( path="/delete" )
	public CommonResult delTerminal( String termId ){
		CommonResult commonResult = new CommonResult();
		return commonResult;
	}
	
	
	@RequestMapping(path = "/record")
	public RecordInfo getRecord( RecordMatch recordMatch ){
		
		recordInfoMapper.selectByPrimaryKey(id)
	}
	
	@RequestMapping(path = "/records")
	public Pager< RecordInfo > getRecords( Pager<RecordInfo> pager ){
		Pager<RecordInfo> pager2;
		return pager;
	}
}
