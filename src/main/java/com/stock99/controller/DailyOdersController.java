package com.stock99.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JsonConfig;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.stock99.model.DailyOdersVO;
import com.stock99.model.GrnVO;
import com.stock99.model.JsonObjectUtil;
import com.stock99.model.OdersVO;
import com.stock99.service.AbstractService;
import com.stock99.service.DailyOdersManager;
import com.stock99.service.GrnManager;
import com.stock99.service.OderManager;



@RequestMapping(value = "/dailyoders")
@Controller
public class DailyOdersController extends
		AbstractController<DailyOdersVO, Integer> {
	Logger logger = Logger.getLogger(DailyOdersController.class);
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
		return "dailyoders";
	}
	
	
	/*Use DailyTargetReport
	Get daily Targets from selected date*/
	
	@RequestMapping(value = "/getDailyTargetDetailsByDate", method = RequestMethod.GET)
	public void getSalesOderidFromStyle(
			HttpServletResponse httpservletResponse, @RequestParam String selectedDate) {
		try {
			List<DailyOdersVO> valueObj = dailyOdersManager.getDailyTargetDetailsByDate(selectedDate);
			if (valueObj != null && valueObj.size() > 0) {
				ObjectMapper mapper = new ObjectMapper();
				ObjectNode objectNode = new ObjectNode(mapper.getNodeFactory());
				JsonObjectUtil<DailyOdersVO> jsonUtil = new JsonObjectUtil<DailyOdersVO>();
				String m = jsonUtil.getJsonObjectDataDetail(valueObj, 1);
				ArrayNode node = mapper.readValue(m, ArrayNode.class);
				objectNode.put("Data", node);
				objectNode.put("success", true);
				writeJson(httpservletResponse, objectNode, mapper);
			} else {
				writeJsonString(httpservletResponse,
						"{\"Data\":\"Empty\",\"success\":false}");
			}
		} catch (Exception e) {
			getLogger().error(e.getMessage());
			writeJsonString(httpservletResponse,
					"{\"Data\":\"" + e.getMessage() + "\",\"success\":false}");

		}
	}
	
	
}
