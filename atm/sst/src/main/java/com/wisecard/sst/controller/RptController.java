package com.wisecard.sst.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wisecard.sst.vo.RpttInfo;

@RestController
@RequestMapping(path = "/rest/rpt", produces = "application/json")
public class RptController {

	@Autowired
	HttpServletRequest httpServletRequest;

	@RequestMapping(path = "", method = RequestMethod.GET)
	public RpttInfo doRpt(){
		RpttInfo rpttInfo = new RpttInfo();
		rpttInfo.setUpdateConfig( false );
		rpttInfo.setUpdateMacKey( false );
		rpttInfo.setUpdatePinKey( false );
		rpttInfo.setUpdateMacKey( false );
		return rpttInfo;
	}
	
}
