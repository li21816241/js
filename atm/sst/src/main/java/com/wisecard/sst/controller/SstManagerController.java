package com.wisecard.sst.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wisecard.sst.trans.vo.IssuseCardRequest;
import com.wisecard.sst.vo.TransResult;

@RestController
@RequestMapping(path = "/rest/admin/ctm", produces = "application/json")
public class SstManagerController {
	
	@RequestMapping(path = "/view/{termid}")
	public  ( @PathVariable String termid ){
		return null;
	}
	
	@RequestMapping(path = "/issusecard")
	public TransResult issusecard( IssuseCardRequest requestInfo){
		return null;
	}
}
