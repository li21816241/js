package com.wisecard.sst.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sun.tools.corba.se.idl.constExpr.Terminal;
import com.sun.tools.doclets.formats.html.TagletWriterImpl;
import com.wisecard.sst.sao.ITransRecordService;
import com.wisecard.sst.trans.vo.IssuseCardRequest;
import com.wisecard.sst.vo.CommonResult;
import com.wisecard.sst.vo.dao.RecordInfo;
import com.wisecard.sst.vo.dao.RecordMatch;
import com.wisecard.sst.vo.dao.TermInfo;
import com.wisecard.web.core.page.Pager;

@RestController
@RequestMapping(path = "/rest/admin/ctm", produces = "application/json")
public class SstManagerController {
	
	@Autowired
	ITransRecordService transRecordService;
	
		
	
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
	
	
	@RequestMapping(path = "/records")
	public Pager< RecordInfo > getRecord( RecordMatch recordMatch, Pager<RecordInfo> pager ){
		StringBuffer stringBuffer = new StringBuffer();
		if( recordMatch.getStart() != null && recordMatch.getEnd() != null ){
			
		}
		Page<RecordInfo> page = PageHelper.startPage(pager.getCurrentPage(), 
				pager.getPageSize()).doSelectPage(() -> transRecordService.getByRecordMatch(recordMatch));
		return pager.from( page );
		
	}
}
