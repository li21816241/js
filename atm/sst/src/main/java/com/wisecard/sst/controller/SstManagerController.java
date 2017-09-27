package com.wisecard.sst.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.wisecard.sst.sao.ITermManagerService;
import com.wisecard.sst.sao.ITransRecordService;
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
	
	@Autowired
	ITermManagerService termManagerService; 
		
	
	@RequestMapping(path = "/view/{termid}", method={RequestMethod.GET})
	public  TermInfo getTermInfo( @PathVariable String termid ){
		return termManagerService.get( termid );
	}
	
	@RequestMapping(path = "/views")
	public  Pager< TermInfo > getTermInfo( Pager<TermInfo> pager ){
		Page<RecordInfo> page = PageHelper.startPage(pager.getCurrentPage(), 
				pager.getPageSize()).doSelectPage(() -> termManagerService.gets( "1" ) );
		return pager;
	}
	
	@RequestMapping( path="/add" )
	public CommonResult addTerminal( TermInfo termInfo ){
		CommonResult commonResult = new CommonResult();
		
		try{
			termManagerService.Insert(termInfo);
			commonResult.setResult( 0 );
			commonResult.setResultMessage( "add terminal success" );
		}catch( Exception exception ){
			commonResult.setResult( -1 );
			commonResult.setResultMessage( "add terminal success" );
		}
		return commonResult;
	}
	
	@RequestMapping( path="/update", method={RequestMethod.PUT} )
	public CommonResult updateTerminal( TermInfo termInfo ){
		CommonResult commonResult = new CommonResult();
		try{
			termManagerService.update(termInfo);
			commonResult.setResult( 0 );
			commonResult.setResultMessage( "update terminal success" );
		}catch( Exception exception ){
			commonResult.setResult( -1 );
			commonResult.setResultMessage( "update terminal failed" );
		}
		return commonResult;
	}
	
	@RequestMapping( path="/delete", method={RequestMethod.DELETE})
	public CommonResult delTerminal( String termId ){
		CommonResult commonResult = new CommonResult();
		try{
			termManagerService.delete(termId);
			commonResult.setResult( 0 );
			commonResult.setResultMessage( "delete terminal success" );
		}catch( Exception exception ){
			commonResult.setResult( -1 );
			commonResult.setResultMessage( "delete terminal failed" );
		}
		return commonResult;
	}
	
	
	@RequestMapping(path = "/records")
	public Pager< RecordInfo > getRecord( RecordMatch recordMatch, Pager<RecordInfo> pager ){
		StringBuffer stringBuffer = new StringBuffer();
		Page<RecordInfo> page = PageHelper.startPage(pager.getCurrentPage(), 
				pager.getPageSize()).doSelectPage(() -> transRecordService.getByRecordMatch(recordMatch));
		return pager.from( page );
		
	}
}
