package com.wisecard.sst.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wisecard.sst.vo.RpttInfo;

@RestController
@RequestMapping(path = "/rest/rpt", produces = "application/json")
public class RptController {


	@RequestMapping(path = "", method = RequestMethod.GET)
	public RpttInfo doRpt(){
		RpttInfo rpttInfo = new RpttInfo();
		return rpttInfo;
	}
	
}
