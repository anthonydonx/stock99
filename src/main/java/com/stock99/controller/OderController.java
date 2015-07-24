package com.stock99.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JsonConfig;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.stock99.model.DailyOdersVO;
import com.stock99.model.JsonObjectUtil;
import com.stock99.model.OdersVO;
import com.stock99.service.AbstractService;
import com.stock99.service.DailyOdersManager;
import com.stock99.service.OderManager;

@RequestMapping(value = "/oder")
@Controller
public class OderController extends AbstractController<OdersVO, Integer> {
	Logger logger = Logger.getLogger(OderController.class);
	@Autowired
	OderManager oderManager;
	@Autowired
	DailyOdersManager dailyOdersManager;

	@Override
	public Logger getLogger() {
		return logger;
	}

	@Override
	public AbstractService<OdersVO> getService() {
		return oderManager;
	}

	@Override
	public JsonConfig getConfig() {
		return null;
	}

	@Override
	public String getControllerName() {
		return "oder";
	}

	@RequestMapping(value = "/getSalesOderidFromStyle", method = RequestMethod.GET)
	public void getSalesOderidFromStyle(
			HttpServletResponse httpservletResponse, @RequestParam String style) {
		try {
			List<OdersVO> valueObj = oderManager.getSalesOderidFromStyle(style);
			if (valueObj != null && valueObj.size() > 0) {
				ObjectMapper mapper = new ObjectMapper();
				ObjectNode objectNode = new ObjectNode(mapper.getNodeFactory());
				JsonObjectUtil<OdersVO> jsonUtil = new JsonObjectUtil<OdersVO>();
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

	@RequestMapping(value = "/getDataFromStyleAndSalesoder", method = RequestMethod.GET)
	public void getDataFromStyleAndSalesoder(
			HttpServletResponse httpservletResponse,
			@RequestParam String style, @RequestParam String salesoder) {
		try {
			List<OdersVO> valueObj = oderManager.getDataFromStyleAndSalesoder(
					style, salesoder);
			if (valueObj != null && valueObj.size() > 0) {
				ObjectMapper mapper = new ObjectMapper();
				ObjectNode objectNode = new ObjectNode(mapper.getNodeFactory());
				JsonObjectUtil<OdersVO> jsonUtil = new JsonObjectUtil<OdersVO>();
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

	@RequestMapping(value = "/getDataFromStyleAndSalesoderLineItem", method = RequestMethod.GET)
	public void getDataFromStyleAndSalesoderLineItem(
			HttpServletResponse httpservletResponse,
			@RequestParam String style, @RequestParam String salesoder,
			@RequestParam String lineitem) {
		try {
			List<OdersVO> valueObj = oderManager
					.getDataFromStyleAndSalesoderLineItem(style, salesoder,
							lineitem);
			if (valueObj != null && valueObj.size() > 0) {
				ObjectMapper mapper = new ObjectMapper();
				ObjectNode objectNode = new ObjectNode(mapper.getNodeFactory());
				JsonObjectUtil<OdersVO> jsonUtil = new JsonObjectUtil<OdersVO>();
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

	@RequestMapping(value = "/getDataFromStyleAndSalesoderLineItemSize", method = RequestMethod.GET)
	public void getDataFromStyleAndSalesoderLineItemSize(
			HttpServletResponse httpservletResponse,
			@RequestParam String style, @RequestParam String salesoder,
			@RequestParam String lineitem, @RequestParam String size) {
		try {
			List<OdersVO> valueObj = oderManager
					.getDataFromStyleAndSalesoderLineItemSize(style, salesoder,
							lineitem, size);
			if (valueObj != null && valueObj.size() > 0) {
				ObjectMapper mapper = new ObjectMapper();
				ObjectNode objectNode = new ObjectNode(mapper.getNodeFactory());
				JsonObjectUtil<OdersVO> jsonUtil = new JsonObjectUtil<OdersVO>();
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

	@RequestMapping(value = "/getDataFromOthers", method = RequestMethod.GET)
	public void getDataFromOthers(HttpServletResponse httpservletResponse,
			@RequestParam String style, @RequestParam String salesoder,
			@RequestParam String lineitem, @RequestParam String size,
			@RequestParam String module) {
		try {
			List<OdersVO> valueObj = oderManager.getDataFromOthers(style,
					salesoder, lineitem, size, module);
			if (valueObj != null && valueObj.size() > 0) {
				ObjectMapper mapper = new ObjectMapper();
				ObjectNode objectNode = new ObjectNode(mapper.getNodeFactory());
				JsonObjectUtil<OdersVO> jsonUtil = new JsonObjectUtil<OdersVO>();
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

	/*@RequestMapping(value = "/updateAllowedQuantity", method = RequestMethod.GET)
	public void getDataFromOthers(HttpServletResponse httpservletResponse) {
		try {
			oderManager.updateAllowedQuantity(20, 222);

		} catch (Exception e) {
			getLogger().error(e.getMessage());
			writeJsonString(httpservletResponse,
					"{\"Data\":\"" + e.getMessage() + "\",\"success\":false}");

		}
	}*/

	

	@RequestMapping(value = "/setDailyTarget", method = RequestMethod.POST)
	public void setDailyTarget(HttpServletResponse httpservletResponse,
			@ModelAttribute OdersVO odersVO,
			@ModelAttribute DailyOdersVO dailyOdersVO) {

		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Date date = new Date();
		// dateFormat.format(date);

		try {
			List<OdersVO> oderVOList = oderManager.getDataFromOthers(
					odersVO.getStyle(), odersVO.getSalesOder(),
					odersVO.getLineItem(), odersVO.getSize(),
					odersVO.getModule());

			OdersVO oVO = oderVOList.get(0);
			dailyOdersVO.setOrders(oVO);
			dailyOdersVO.setdate(dateFormat.format(date));
			dailyOdersVO.setStatus("Pending");
			dailyOdersVO.setDayIss(0);
			dailyOdersManager.add(dailyOdersVO);

			ObjectMapper mapper = new ObjectMapper();
			ObjectNode node2 = new ObjectNode(mapper.getNodeFactory());

			JsonObjectUtil<OdersVO> jsonUtil = new JsonObjectUtil<OdersVO>();
			String m = jsonUtil.getJsonObjectDataDetail(oderVOList, 2);
			// System.out.println(m);
			ArrayNode node = mapper.readValue(m, ArrayNode.class);
			node2.put("Data", node);
			node2.put("success", true);

			writeJson(httpservletResponse, node2, mapper);

		} catch (Exception e) {
			System.out.print(e);
			writeJsonString(httpservletResponse,
					"{\"Data\":\"" + e.getMessage() + "\",\"success\":false}");

		}
	}

}
