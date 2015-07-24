package com.stock99.controller;

import net.sf.json.JsonConfig;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.stock99.model.DailyOdersVO;
import com.stock99.model.GrnVO;
import com.stock99.model.OdersVO;
import com.stock99.service.AbstractService;
import com.stock99.service.DailyOdersManager;
import com.stock99.service.GrnManager;
import com.stock99.service.OderManager;



@RequestMapping(value = "/dailytargetreport")
@Controller
public class DailyTargetReportController extends
		AbstractController<DailyOdersVO, Integer> {
	Logger logger = Logger.getLogger(DailyTargetReportController.class);
	@Autowired
	DailyOdersManager dailyOdersManager;

	@Override
	public Logger getLogger() {
		return logger;
	}

	@Override
	public AbstractService<DailyOdersVO> getService() {
		return dailyOdersManager;
	}

	@Override
	public JsonConfig getConfig() {
		return null;
	}

	@Override
	public String getControllerName() {
		return "dailytargetreport";
	}

	
	
}
