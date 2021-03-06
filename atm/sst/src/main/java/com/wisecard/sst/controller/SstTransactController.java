package com.wisecard.sst.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wisecard.sst.trans.vo.IssuseCardRequest;
import com.wisecard.sst.trans.vo.QueryRequest;
import com.wisecard.sst.trans.vo.RequestInfo;
import com.wisecard.sst.trans.vo.TransResult;

@RestController
@RequestMapping(path = "/rest/trans", produces = "application/json", method=RequestMethod.POST )
public class SstTransactController {

	@RequestMapping(path = "/query")
	public TransResult query( HttpServletRequest request, QueryRequest requestInfo){
		
		return null;
	}
	
	@RequestMapping(path = "/issusecard")
	public TransResult issusecard( IssuseCardRequest requestInfo){
		return null;
	}
}
